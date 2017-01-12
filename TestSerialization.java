import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 问题来源：在看arrayList源码时候发现其中变量elementData是被transient修饰的
 * 		     而且arrayList是实现了Serializable接口的，elementData是存储arrayList中值的
 * 		     那么arrayList是如何实现序列化与反序列化的呢？
 * 问题解决：首先我们知道序列化与反序列化是使用ObjectInputStream、ObjectOutputStream中的
 * 		  readObject、writeObject方法实现的，那么即使arrayList中的elementData被修饰
 * 		     成transient的，也可以在arrayList中定义这两个方法，并在其中调用ObjectInputStream、
 * 		  ObjectOutputStream中的这个两个方法，而看arrayList源码中确实有定义这两个方法，但是现在
 * 		   是否定义的这两个方法后就会被调用呢？这里就做了这个测试来看看序列化与反序列化是否会成功.
 * @author Administrator
 *
 */
public class TestSerialization implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient int    num;

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException
    {
        s.defaultWriteObject();
        s.writeObject(num);
        System.out.println("writeObject of "+this.getClass().getName());
    }

    /**
     * @param s
     * @throws java.io.IOException
     * @throws ClassNotFoundException
     */
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException
    {
        s.defaultReadObject();
        num = (Integer) s.readObject();
        System.out.println("readObject of "+this.getClass().getName());
    }

    public static void main(String[] args)
    {
        TestSerialization test = new TestSerialization();
        test.setNum(10);
        System.out.println("序列化之前的值："+test.getNum());
        // 写入
        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream("D:\\test.tmp"));
            outputStream.writeObject(test);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        // 读取
        try
        {
            ObjectInputStream oInputStream = new ObjectInputStream(
                    new FileInputStream("D:\\test.tmp"));
            try
            {
                TestSerialization aTest = (TestSerialization) oInputStream.readObject();
                System.out.println("读取序列化后的值："+aTest.getNum());
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
## 理解String的不可变

1、String被final修饰  不可以被继承
2、String中的用于存储字符串的是成员变量value  其声明是这样的
	private final char value[];
其中value被final修饰，value的引用地址不可变
3、String类没有对value进行值(引用地址中的值)修改操作的方法
综上可以得出，String的不可变是因为他本身出于安全考虑不提供修改value的方法并且value本身也被final修饰，不可以改变，最后将String定义为不可被继承的，防止被继承后被破坏，所以达到了不可变。

我们平时说的String可变其实改变的只是String s;中s的引用地址，这么千万别和value搞混了，value不可以改变引用地址，但是s是String类型的引用变量，s在声明的时候没有被我们声明为final，也和String类的final无关，所以s的引用地址是可以变化的。

如何对String达到真正的使其变化，即value值的变化。
可以使用反射获取value
具体可以百度Java如何使用反射获取类的私有成员变量



## Switch支持String的实现原理是什么？

  Swtch在JDK1.7的版本支持String作为参数匹配，是通过String的hashCode转换为int类型的值进行匹配，再调用equals方法判断值是否相等。
  底层的JVM没有对此进行新的指令操作，而是通过Javac生成的相应代码。
  传入的String不能为NULL，否则调用hashCode方法就会报NullPointerException。

  学习自：http://www.cnblogs.com/IT-Monkey/p/4047085.html
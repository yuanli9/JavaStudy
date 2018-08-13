# redis学习与总结



### redis命令

- redis客户端连接

​	 redis-cli -h [address] -p [port] -a [password]	

> [root@VM_0_13_centos redis]# redis-cli -h 118.25.22.227 -p 6379 -a xxxxxxx



- config get requirepass 查看redis密码

> 118.25.22.227:6379> config get requirepass
> 1) "requirepass"
> 2) "xxxxxxx"
> 118.25.22.227:6379> 

- config set requirepass 修改redis密码

> 118.25.22.227:6379> config set 'yyyyyyyy'
> OK
> 118.25.22.227:6379> 


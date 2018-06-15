# Linux环境redis安装与部署



## redis下载

- 下载地址：http://download.redis.io/releases/redis-4.0.9.tar.gz

  下载方法1：手动下载移入linux系统指定文件夹下

  下载方法2：wget http://download.redis.io/releases/redis-4.0.9.tar.gz



## redis 安装

- 解压安装包：
  - tar -zxvf redis-4.0.9.tar.gz
- 建立redis目录软连接（方便版本管理，省略也可）：
  - ln -s redis-4.0.9 redis
- 进入redis目录：
  - cd redis (前面省略则 cd redis-4.0.9)
- 编译（确保gcc已安装）：
  - make
- 安装（将redis相关运行文件放到/usr/local/bin,可在任意目录下执行redis命令）
  - make install



## redis启动

- redis-server启动redis

如果启动失败：

>  WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower value of 128.
>
> 解决方法：执行  echo 511 > /proc/sys/net/core/somaxconn 

> WARNING overcommit_memory is set to 0! Background save may fail under low memory condition. To fix this issue add 'vm.overcommit_memory = 1' to /etc/sysctl.conf and then reboot or run the command 'sysctl vm.overcommit_memory=1' for this to take effect.
>
> 解决方法：执行  echo 1 > /proc/sys/vm/overcommit_memory 

> WARNING you have Transparent Huge Pages (THP) support enabled in your kernel.  This will create latency and memory usage issues with Redis.  To fix this issue run the command 'echo never > /sys/kernel/mm/transparent_hugepage/enabled' as root,  and add it to your /etc/rc.local in order to retain the setting after a reboot. Redis must be restarted after THP is disabled. 
>
> 解决方法：echo never > /sys/kernel/mm/transparent_hugepage/enabled

另有参照：https://www.cnblogs.com/paul8339/p/6999769.html?utm_source=itdadao&utm_medium=referral




- tail -f -n 500 xxx.log

  查看xxx.log后500行日志并实时监控

  

- head -n 500 xxx.log

  查看xxx.log前500行日志

  

- cat -n xxx.log|grep "search-info"

  查看xxx.log中“search-info”

  

- grep '2018-8-6 10:30:10' xxx.log

  查看xxx.log中有没有该时间点的日志记录

  

- sed  -n 'yyyy-MM-dd HH:mm:ss'/,/yyyy-MM-dd HH:mm:ss/p' xxx.log

  查看时间区域内的日志

  

- sed -n '5,10p' xxx.log

  看到xxx.log第5~10行日志

  

- cat -n xxx.log|grep "search-info" |more

  查看“search-info"日志，并可以使用空格翻页查看所有相关日志

  

- cat -n xxx.log|grep "search-info" >xxx.txt

  查找“search-info"日志并输出生成xxx.txt
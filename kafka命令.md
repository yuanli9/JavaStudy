> 查看所有有效的topic

- ./kafka-topics.sh --list --zookeeper 22.144.101.116:2181,22.144.101.116:2181,22.144.101.116:2181

> 新建消息

- ./kafka-console-producer.sh --broker-list  22.144.101.116:2181,22.144.101.116:2181,22.144.101.116:2181 --topic apply

> 查看topic消费情况

- kafka-run-class.sh kafka.tools.ConsumerOffsetChecker --group xxx --topic xxx  --zookeeper xxx

- 显示结果说明：

  | GROUP    | TOPIC  | PID    | OFFSET           | LOGSIZE | LAG          |
  | -------- | ------ | ------ | ---------------- | ------- | ------------ |
  | 消费者组 | 话题id | 分区id | 当前已消费的条数 | 总条数  | 未消费的条数 |

  


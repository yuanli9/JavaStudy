# NIO

## 概述

传统IO，又成BIO 即阻塞式IO（Blocking IO），当一个线程调用read() 或 write()时，该线程被阻塞，直到有一些数据被读取，或数据完全写入。

NIO，即非阻塞式IO（NON Blocking IO） 

### 核心组件

- Channels
- Buffers
- Selectors


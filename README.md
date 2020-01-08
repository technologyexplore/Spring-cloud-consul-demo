# Spring-cloud-consul-demo
consul的介绍和使用

1.什么是consul

Consul是一个分布式高可用的系统服务发现与配置工具。简单来说，它与Eureka的核心功能一样，但略有不同：

   ① Consul使用go语言编写，以HTTP方式对外提供服务。

   ② Consul支持多数据中心，这是它的一大特色。

   ③ Consul除了服务发现之外，还有一些别的功能。

   ④ Consul的一致性协议是Raft。

2.consul能做什么

  Consul可以作为服务治理组件和配置中心

3.工作原理

  

  ① 当 Producer 启动的时候，会向 Consul 发送一个 post 请求，告诉 Consul 自己的 IP 和 Port

  ② Consul 接收到 Producer 的注册后，每隔10s（默认）会向 Producer 发送一个健康检查的请求，检验Producer是否健康

  ③ 当 Consumer 发送 GET 方式请求 /api/address 到 Producer 时，会先从 Consul 中拿到一个存储服务 IP 和 Port 的临时表，从表中拿到 Producer 的 IP 和 Port 后再发送 GET 方式请求 /api/address

  ④ 该临时表每隔10s会更新，只包含有通过了健康检查的 Producer

4.架构

consul官方/公司架构


5.特点及对比


6.常用命令

 ① consul agent --dev: 以开发模式运行(该节点的启动不能用于生产环境，因为该模式下不会持久化任何状态)

 ② consul –v: 查看版本号 consul members:查看consul cluster中的每一个consul节点的信息

 ③ consul join ip:将agent加入到集群 consul leave:将节点移除所在集群

 ④ consul agent –help:命令选项

 ⑤ consul agent –dev –client 192.168.5.129: 使用-client可以指定允许客户端使用什么ip进行访问



7.入门案例

Spring Cloud Consul模块介绍：

① Spring Cloud Counsul-Discovery(案例): 对Consul服务治理功能封装

② Spring Cloud Counsul-Binder：对Consul的事件功能封装

③ Spring Cloud Counsul-Config(案例)：对Consul的配置功能封装

④ Spring Cloud Counsul-Core：基础配置和健康检查模块



8.提问

1.罗昌勇：UDP协议是在多个server节点间同步数据，还是服务进行服务注册时用到？

 张川：UDP可用于consul中 Serf LAN（默认8301）,Serf WAN（默认8302）,DNS接口（默认8600）这几个端口之间通信。

2.何伟铭：client与server节点的数量有没有规则能确定各自应该设立多少个？

 张川：每个数据中心的 server 数量推荐为 3 个或是 5 个（奇数个），client节点可以设置1-2个。

3.何伟铭：对于conusl集群的节点数有没有什么限定？例如必须为偶数个?

 张川：Server模式运行的Consul服务不能太多，推荐3或5个，因为太多开会选举性能不佳，并且个数要求是奇数（选举算法要求）。

4.何伟铭:   consul是怎么进行选举的?

 张川：consul选举基于paxos算法实现，具体可参考paxos算法

5.林浩鹏：shein consul和consul的区别？

 张川：相较于正常的consul，公司的consul暂不使用consul的DNS功能， 每个机房部署3台服务端组成集群。（暂时不开启WAN GOSSIP）

6.曹金：配置文件是否会同步 如何同步？

 张川：配置文件会进行同步，由Leader节点同步给其他从节点
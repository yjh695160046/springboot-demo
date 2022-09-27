一个分布式的全局事务，整体是两阶段提交Try-[Comfirm/Cancel] 的模型。
在Seata中，AT模式与TCC模式事实上都是两阶段提交的具体实现。他们的区别在于：

AT 模式基于支持本地 ACID 事务 的 关系型数据库（目前支持Mysql、Oracle与PostgreSQL）：

一阶段 prepare 行为：在本地事务中，一并提交业务数据更新和相应回滚日志记录。
二阶段 commit 行为：马上成功结束，自动异步批量清理回滚日志。
二阶段 rollback 行为：通过回滚日志，自动生成补偿操作，完成数据回滚。

相应的，TCC 模式，不依赖于底层数据资源的事务支持：

一阶段 prepare 行为：调用 自定义 的 prepare 逻辑。
二阶段 commit 行为：调用 自定义的 commit 逻辑。
二阶段 rollback 行为：调用 自定义的 rollback 逻辑。

所谓 TCC 模式，是指支持把 自定义 的分支事务纳入到全局事务的管理中。

简单点概括，SEATA的TCC模式就是手工的AT模式，它允许你自定义两阶段的处理逻辑而不依赖AT模式的undo_log。
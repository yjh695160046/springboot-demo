

**mybatis的相关源码解析**

mybatis 的一级缓存及二级缓存

spring整合mybatis时一级缓存会失效 每次都会创建新的sqlSession 而一级缓存是基于sqlSession的

多表操作一定不要使用二级缓存 会产生脏数据
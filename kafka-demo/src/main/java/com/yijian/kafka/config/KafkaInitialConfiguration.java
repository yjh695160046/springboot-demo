package com.yijian.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/2 14:58
 * @Description:
 */
@Configuration
public class KafkaInitialConfiguration {


    /**
     * 创建一个名为testtopic的Topic并设置分区数为8，分区副本数为2
     *
     *   错误1  Replication factor: 2 larger than available brokers: 1.
     *
     *         原因：是因为replication-factor（topic副本）个数不能超过broker（服务器）的个数
     *
     *
     */

    //@Bean
    //public NewTopic initialTopic() {
    //    return new NewTopic("topic1",8, (short) 1 );
    //}

}

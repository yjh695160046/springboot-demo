package com.yijian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import javax.annotation.Resource;

/**
 * @author: yxyaojinhua
 * @date: 2021/10/29 16:00
 * @description: redis的发布订阅
 */
@Configuration
public class RedisListenerConfig {

    @Resource
    private  RedischannelSub redischannelSub;

    @Resource
    private  RedisPmpSub redisPmpSub;
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter(redischannelSub), new PatternTopic("channel"));
        container.addMessageListener(listenerAdapter(redisPmpSub), new PatternTopic("pmp"));
        return container;
    }


    @Bean
    @Scope("prototype")
    MessageListenerAdapter listenerAdapter(RedisMsg redisMsg) {
        return new MessageListenerAdapter(redisMsg, "receiveMessage");
    }
}

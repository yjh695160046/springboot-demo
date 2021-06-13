package com.yijian.rocketmq.listener;

import com.alibaba.fastjson.JSON;
import com.yijian.rocketmq.pojo.MqMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: yaojinhua
 * @date: 2021/5/22 14:22
 * @description: 消费监听类 rocketmq
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "test_locat_topic", consumerGroup = "test-group")
public class TestConsumerListener implements RocketMQReplyListener<MessageExt, ConsumeConcurrentlyStatus> {


    @Override
    public ConsumeConcurrentlyStatus onMessage(MessageExt message) {
        System.out.println("message :" + JSON.toJSONString(message));
        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }
}

package com.yijian.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/20 15:49
 * @description:
 * 消费者采用负载均衡方式消费消息，多个消费者共同消费队列消息，每个消费者处理的消息不同
 */
public class LoadBalance1Consumer {

    public static void main(String[] args) throws Exception {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test-group");
        // 指定Namesrv地址信息.
        consumer.setNamesrvAddr("192.168.56.10:9876");
        consumer.subscribe("TopicTest", "*");
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    System.out.printf("%s Receive New Messages: %s %n",
                            Thread.currentThread().getName(),  new String(msgs.get(0).getBody(), StandardCharsets.UTF_8));
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
        });
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }

}

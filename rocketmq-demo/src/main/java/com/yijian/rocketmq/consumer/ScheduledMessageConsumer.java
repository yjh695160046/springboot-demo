package com.yijian.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/21 15:07
 * @description:
 */
public class ScheduledMessageConsumer {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ExampleConsumer");
        consumer.setNamesrvAddr("192.168.56.10:9876");
        // 默认负载均衡
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.subscribe("ScheduledMessageTopic", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt message : msgs) {
                    // Print approximate delay time period
                    System.out.println("Receive message[msgId=" +
                            message.getMsgId() + "] " + (System.currentTimeMillis() -
                            message.getStoreTimestamp()) + "ms later");
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者
        consumer.start();
    }


}

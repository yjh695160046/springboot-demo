package com.yijian.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/20 19:26
 * @description: 模拟订单的流程的顺序消息 , 消费消息
 */
public class SequenceConsumer {
    public static void main(String[] args) throws Exception {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test-group");
        // 指定Namesrv地址信息.
        consumer.setNamesrvAddr("192.168.56.10:9876");
        consumer.subscribe("OrderTopic", "TagA || TagD || TagC");
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            Random random = new Random();
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println("consumeThread=【" +
                            Thread.currentThread().getName() + "】 queueId=" + msg.getQueueId() + ", content:"
                            + new String(msg.getBody()));
                }
                try {
                   //模拟业务逻辑处理中...
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer Started.");

    }

}

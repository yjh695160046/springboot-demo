package com.yijian.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;


/**
 * @author: yxyaojinhua
 * @date: 2022/4/19 17:13
 * @description: 可靠性同步发送、比如重要的消息通知
 */
public class SyncProducer {

    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("192.168.56.10:9876");
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message message = new Message("TopicTest", "TagA", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
        }

        // producer.shutdown();

    }

}

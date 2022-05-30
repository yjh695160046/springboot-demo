package com.yijian.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/21 15:03
 * @description: 提交了一个订单就可以发送一个延时消息，1h后去检查这个订单的状态，如果还是未付款
 * 就取消订单释放库存。
 */
public class ScheduledMessageProducer {
    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
        producer.setNamesrvAddr("192.168.56.10:9876");
        producer.start();
        int totalMessagesToSend = 100;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("ScheduledMessageTopic", ("Hello scheduled message "
                    + i).getBytes());
            // 设置延时等级3,这个消息将在10s之后发送(现在只支持固定的几个时间,详看
            message.setDelayTimeLevel(3);
            // 发送消息
            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
        }

    }

}

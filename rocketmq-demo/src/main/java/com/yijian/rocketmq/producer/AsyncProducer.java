package com.yijian.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;


/**
 * @author: yxyaojinhua
 * @date: 2022/4/19 17:13
 * @description: 异步消息通常用在对响应时间敏感的业务场景，即发送端不能容忍长时间地等待Broker的响应
 */
public class AsyncProducer {

    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("192.168.56.10:9876");
        producer.setRetryTimesWhenSendAsyncFailed(0);
        producer.start();
        for (int i = 0; i < 100; i++) {
            final int index = i;
            Message message = new Message("TopicTest", "TagA", "OrderId199", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });

        }

        // producer.shutdown();

    }

}

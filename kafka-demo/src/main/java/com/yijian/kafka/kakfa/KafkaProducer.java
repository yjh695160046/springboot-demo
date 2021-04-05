package com.yijian.kafka.kakfa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/2 15:01
 * @Description:
 */
@Component
public class KafkaProducer<K, V> {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 将数据发送到没有密钥或分区的提供的主题。
     * 参数：
     * 主题–主题。
     * 数据–数据。
     */
    public void send(String topic, V data){
        //指定key 及分区
        //kafkaTemplate.send(topic, 1, topic, data);

        ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send(topic, data);
        SendResult<String, Object> stringObjectSendResult = null;
        try {
            stringObjectSendResult = send.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        stringObjectSendResult.getRecordMetadata();
    }




}

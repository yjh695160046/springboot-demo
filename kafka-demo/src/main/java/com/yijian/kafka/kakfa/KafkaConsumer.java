package com.yijian.kafka.kakfa;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/2 15:28
 * @Description:
 */
@Component
public class KafkaConsumer {

    //@KafkaListener(topics = "topic1", )
    //@KafkaListener(topicPartitions = {@TopicPartition =())
    //@KafkaListener(groupId = "jinhua1", topicPartitions = {@TopicPartition(topic = "topic1", partitions = {"0", "1"})})
    @KafkaListener(topics = "topic2")
    public void onMessage(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        //System.out.println("分区0-1");
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value()+"-"+record.offset() +"-"+record.headers());
    }
    //@KafkaListener(groupId = "jinhua2", topicPartitions = {@TopicPartition(topic = "topic1", partitions = {"3", "4"})})
    //public void onMessage1(ConsumerRecord<?, ?> record){
    //    // 消费的哪个topic、partition的消息,打印出消息内容
    //    System.out.println("分区3-4");
    //    System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    //}
    //@KafkaListener(groupId = "jinhua3",topics = "topic2")
    //public void onMessage2(ConsumerRecord<?, ?> record){
    //    // 消费的哪个topic、partition的消息,打印出消息内容
    //    System.out.println("不指定分区 消费所有的分区");
    //    System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    //}
}

// package com.yijian.rocketmq.controller;
//
// import com.yijian.rocketmq.pojo.MqMessage;
// import org.apache.rocketmq.common.message.Message;
// import org.apache.rocketmq.spring.core.RocketMQTemplate;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// import javax.annotation.Resource;
// import java.util.Date;
//
// /**
//  * @author: yaojinhua
//  * @date: 2021/5/22 14:10
//  * @description:
//  */
// @RestController
// @RequestMapping("/api/testRocketMQ")
// public class TestProducerController {
//
//     /**
//      * 用于发送消息到 RocketMQ 的api
//      */
//     @Resource
//     public RocketMQTemplate rocketMqTemplate;
//
//     @RequestMapping("/sendMsg")
//     public Object testSendMsg() {
//         String topic = "test_locat_topic";
//         MqMessage message = new MqMessage();
//         message.setId(1);
//         message.setName("yaojinhua");
//         message.setStatus("default");
//         message.setCreateTime(new Date());
//         rocketMqTemplate.convertAndSend(topic, message);
//         return "send message success";
//     }
//
//
// }

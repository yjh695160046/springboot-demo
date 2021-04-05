package com.yijian.kafka.controller;

import com.yijian.demospringbootstarter.ServiceBean;
import com.yijian.kafka.kakfa.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/1 19:55
 * @Description:
 */
@RestController
@RequestMapping("/kafka")
public class HelloController {

    @Autowired
    private ServiceBean serviceBean;

    @Autowired
    private KafkaProducer<String, Object> kafkaProducer;

    @RequestMapping(value = "test01", method = RequestMethod.GET)
    public Object test01() {
        kafkaProducer.send("topic1", "简单消费");
        return serviceBean.sayHello("yaojinhua");
    }

}

package com.yijian.kafka.controller;

import com.yijian.demospringbootstarter.ServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("test01")
    public String test01(){
          return  serviceBean.sayHello("yaojinhua");
    }

}

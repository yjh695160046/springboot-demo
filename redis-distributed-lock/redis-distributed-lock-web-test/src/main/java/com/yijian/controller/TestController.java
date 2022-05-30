package com.yijian.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: yaojinhua
 * @date: 2021/6/1 15:47
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/checkDate")
    public Object saveSet(@RequestBody Map<String, Object> map) {

        return map;


    }

    @RequestMapping("/redis/sendMessage")
    public void sendMessage(){
        stringRedisTemplate.convertAndSend("pmp", String.valueOf(Math.random()));
        stringRedisTemplate.convertAndSend("channel", String.valueOf(Math.random()));
    }
}

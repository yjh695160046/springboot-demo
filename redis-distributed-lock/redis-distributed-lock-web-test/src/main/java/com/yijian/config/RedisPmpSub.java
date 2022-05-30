package com.yijian.config;

import org.springframework.stereotype.Component;

/**
 * @author: yxyaojinhua
 * @date: 2021/10/29 16:04
 * @description:
 */
@Component
public class RedisPmpSub implements RedisMsg {
    @Override
    public void receiveMessage(String message) {
        System.out.println("这是RedisPmpSub" + "----" + message);
    }
}

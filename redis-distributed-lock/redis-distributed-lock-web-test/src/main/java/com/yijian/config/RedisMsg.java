package com.yijian.config;

/**
 * @author: yxyaojinhua
 * @date: 2021/10/29 16:02
 * @description:
 */
public interface RedisMsg {

    void receiveMessage(String message);
}

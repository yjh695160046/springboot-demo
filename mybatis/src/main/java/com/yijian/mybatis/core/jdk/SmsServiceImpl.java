package com.yijian.mybatis.core.jdk;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/10 16:05
 * @description: 真实主题角色
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public void send() {
        System.out.println("发送短信成功！！");
    }
}

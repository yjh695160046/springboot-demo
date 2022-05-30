package com.yijian.javabase.proxy.dynamic.jdk;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/10 16:12
 * @description:
 */
public class JdkMain {
    public static void main(String[] args) {
        SmsService proxy = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        proxy.send();
    }
}

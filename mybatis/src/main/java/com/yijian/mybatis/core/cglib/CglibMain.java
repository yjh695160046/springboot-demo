package com.yijian.mybatis.core.cglib;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/11 16:01
 * @description:
 */
public class CglibMain {
    public static void main(String[] args) {

        SmsServiceImpl proxy = (SmsServiceImpl) CglibProxyFactory.getProxy(SmsServiceImpl.class);
//        proxy.send();
    }
}

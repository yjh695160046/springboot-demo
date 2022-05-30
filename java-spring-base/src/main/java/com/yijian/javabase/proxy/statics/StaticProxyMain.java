package com.yijian.javabase.proxy.statics;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/8 20:38
 * @description:
 */
public class StaticProxyMain {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);
        proxy.select();
        proxy.update();
    }
}

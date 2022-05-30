package com.yijian.javabase.proxy.statics;

import java.util.Date;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/8 20:35
 * @description: Proxy（代理主题角色) 代理类
 */
public class UserServiceProxy implements UserService {

    /**
     * 被代理的对象
     */
    private final UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void select() {
        before();
        // 这里才实际调用真实主题角色的方法
        target.select();
        after();
    }

    @Override
    public void update() {
        before();
        // 这里才实际调用真实主题角色的方法
        target.update();
        after();
    }

    /**
     *  在执行方法之前执行
     */
    private void before() {
        System.out.printf("log start time [%s] %n", new Date());
    }

    /**
     *  在执行方法之后执行
     */
    private void after() {
        System.out.printf("log end time [%s] %n", new Date());
    }

}

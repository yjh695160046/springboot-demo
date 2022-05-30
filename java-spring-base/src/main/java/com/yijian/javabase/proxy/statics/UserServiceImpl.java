package com.yijian.javabase.proxy.statics;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/8 20:34
 * @description: RealSubject（真实主题角色）
 */
public class UserServiceImpl implements UserService{
    @Override
    public void select() {
        System.out.println("查询 selectById");
    }

    @Override
    public void update() {
        System.out.println("更新 update");
    }
}

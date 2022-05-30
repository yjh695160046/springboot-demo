package com.yijian.mybatis.core.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/10 16:06
 * @description:
 */
@Deprecated
public class SmsServiceInvocationHandler implements InvocationHandler {

    /**
     *  将委托类注入处理类（这里我们用 Object 代替，方便扩展）
     */
    private final Object target;

    public SmsServiceInvocationHandler(Object target) {
        this.target = target;
    }
    /**
     * 执行
     * @param proxy 调用该方法的代理实例
     * @param method 委托类的方法
     * @param args 传给委托类的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}

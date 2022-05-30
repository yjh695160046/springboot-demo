package com.yijian.mybatis.core.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/11 16:25
 * @description:
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        // 通过反射调用委托类的方法
        Object object = methodProxy.invokeSuper(o, args);
        // 调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return object;
    }
}

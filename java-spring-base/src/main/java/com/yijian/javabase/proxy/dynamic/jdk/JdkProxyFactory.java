package com.yijian.javabase.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/10 16:11
 * @description:
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    //调用方法之前，我们可以添加自己的操作
                    System.out.println("before method " + method.getName());
                    Object result = method.invoke(target, args);
                    //调用方法之后，我们同样可以添加自己的操作
                    System.out.println("after method " + method.getName());
                    return result;
                }
        );
    }
}

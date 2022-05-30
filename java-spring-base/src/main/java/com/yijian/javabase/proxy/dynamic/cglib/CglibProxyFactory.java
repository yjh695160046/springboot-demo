package com.yijian.javabase.proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/11 15:56
 * @description:
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理类
        Enhancer enhancer = new Enhancer();
        // 设置委托类
        enhancer.setSuperclass(clazz);
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
         // 设置方法拦截器
        enhancer.setCallback(new MethodInterceptor() {
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
        });
        // 创建代理类
        return enhancer.create();
    }


}

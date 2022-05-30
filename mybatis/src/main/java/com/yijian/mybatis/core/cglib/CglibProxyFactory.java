package com.yijian.mybatis.core.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/11 15:56
 * @description:
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置委托类（设置父类）
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}

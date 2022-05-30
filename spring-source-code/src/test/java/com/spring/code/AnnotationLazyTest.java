package com.spring.code;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/31 16:11
 * @description: spring 懒加载的实现 @Lazy 测试类
 */

public class AnnotationLazyTest {

    /**
     * 未开启@Lazy 懒加载模式  IOC创建时会把单实例bean创建成功 加载到容器中
     */
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationLazyConfig.class);
        System.out.println("IOC容器创建完成");
    }

    /**
     * 开启懒加载模式 获取bean对象才会去创建bean实例 多次获取不会创建多个bean
     *   源码分析：
     *
     */
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationLazyConfig.class);
        System.out.println("IOC容器创建完成");
        Person bean = (Person) applicationContext.getBean("person01");
        System.out.println(bean.getAge());
//        Person bean1 = applicationContext.getBean(Person.class);
//        System.out.println(bean == bean1);
    }
}

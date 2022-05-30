package com.spring.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/31 16:07
 * @description: spring 懒加载的实现 @Lazy
 */
@Configuration
@Import(MyBeanFactoryPostProcessor.class)
public class AnnotationLazyConfig {

//    @Bean
//    public Person person(){
//        System.out.println("给容器中加入Person对象");
//        return new Person();
//    }

//    @Lazy
    @Bean
    public Person person01(){
        System.out.println("给容器中加入Person01对象");
        return new Person("zhangsan",2);
    }

}
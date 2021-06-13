package com.yijian.javabase.dependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: yaojinhua
 * @date: 2021/5/6 15:08
 * @description:
 */
public class SpringContextHolder implements ApplicationContextAware, BeanFactoryAware {

    private static  ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    }
}
    
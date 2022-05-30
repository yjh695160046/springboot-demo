package com.spring.code;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author: yxyaojinhua
 * @date: 2021/9/3 14:40
 * @description:  自定义的BeanFactoyPostProcessor
 *
 *   1.参数的属性替换 例: 在yaml中的写${jdbc.username}会有对应的beanFactoryPostProcessor进行处理
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(@NonNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        System.out.println(beanFactory);
//        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person01");
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues()) {
            System.out.println(propertyValue);
        }

    }
}

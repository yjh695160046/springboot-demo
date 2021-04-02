package com.yijian.demospringbootstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/1 17:31
 * @Description:
 */
@Configuration
@ConditionalOnBean(annotation = EnableAutoConfigTest.class)
public class AutoConfigurationTest {

    @Bean
    public ServiceBean serviceBean() {
        return new ServiceBean();
    }


}

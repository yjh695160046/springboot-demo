package com.yijian.demospringbootstarter;

import com.yijian.demospringbootstarter.config.SmsProperties;
import com.yijian.demospringbootstarter.service.SmsService;
import com.yijian.demospringbootstarter.service.impl.SmsServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/1 17:31
 * @Description:
 */
@Configuration
@ConditionalOnBean(annotation = EnableAutoConfigTest.class)
@EnableConfigurationProperties(value = {SmsProperties.class})
public class AutoConfigurationTest {

    @Bean
    public SmsService smsService(){
        return new SmsServiceImpl();
    }

}

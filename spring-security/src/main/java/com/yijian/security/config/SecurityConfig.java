package com.yijian.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/27 11:22
 * @description: Security配置 bf091fcc-90e0-4200-b936-bae545eb8f2b
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("yijian")
//                .password("123").roles("admin");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//         super.configure(http);
        //只允许路由由test开头的需要进行权限认证，其他的接口不需要权限认证；requestMatchers().anyRequest()即所有接口可以不进行认证；
//        http.requestMatchers().anyRequest().and().authorizeRequests().
//                antMatchers("/hello/*").authenticated();
         //只有以test开头的接口需要进行权限认证
        http.authorizeRequests().antMatchers("/hello/**").authenticated();

    }
}

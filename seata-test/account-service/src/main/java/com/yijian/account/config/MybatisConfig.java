package com.yijian.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yaojinhua
 */
@Configuration
@MapperScan("com.yijian.account.mapper")
public class MybatisConfig {
}

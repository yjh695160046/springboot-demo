package com.yijian.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yijian.order.mapper")
public class MybatisConfig {
}

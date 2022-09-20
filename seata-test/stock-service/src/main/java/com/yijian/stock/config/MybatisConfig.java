package com.yijian.stock.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yijian.stock.mapper")
public class MybatisConfig {
}

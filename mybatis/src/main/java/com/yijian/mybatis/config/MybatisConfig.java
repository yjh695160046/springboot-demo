package com.yijian.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/17 20:24
 * @description: mybaits配置文件
 */
@Configuration
@MapperScan("com.yijian.mybatis.mapper")
public class MybatisConfig {

}

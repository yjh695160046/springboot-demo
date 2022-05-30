package com.yijian.springcommon.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/9 10:24
 * @description:  初始换数据服务
 *                1.初始化热点缓存数据进Redis(缓存预热)
 *                ...
 */
@Configuration
public class InitDataService {


    /**
     * 使用 @PostConstruct 在项目启动时加载数据
     */

    @PostConstruct
    public void initDataIntoRedis(){
        System.out.println("使用 @PostConstruct 在项目启动时加载数据");
    }
}

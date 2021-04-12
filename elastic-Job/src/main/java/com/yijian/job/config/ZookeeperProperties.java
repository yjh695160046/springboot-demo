package com.yijian.job.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/8 13:45
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "elasticjob.zookeeper")
public class ZookeeperProperties {

    //zookeeper地址列表
    private String serverlist;

    //zookeeper命名空间
    private String namespace;

}

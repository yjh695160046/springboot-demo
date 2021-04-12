package com.yijian.job.config;

import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/8 13:44
 * @Description:
 */
@Configuration
@ConditionalOnProperty("elasticjob.zookeeper.server-list")
@EnableConfigurationProperties(ZookeeperProperties.class)
public class ZookeeperAutoConfig {

    private final ZookeeperProperties zookeeperProperties;

    public ZookeeperAutoConfig(ZookeeperProperties zookeeperProperties) {
        this.zookeeperProperties = zookeeperProperties;
    }

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter zkCenter(){
        String serverList = zookeeperProperties.getServerlist();
        String namespace = zookeeperProperties.getNamespace();

        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(serverList, namespace);
        ZookeeperRegistryCenter zookeeperRegistryCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
        return zookeeperRegistryCenter;
    }

}

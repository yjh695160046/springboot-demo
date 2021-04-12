package com.yijian.job.config;

import org.apache.shardingsphere.elasticjob.api.listener.ShardingContexts;
import org.apache.shardingsphere.elasticjob.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/9 9:51
 * @Description:
 */
@Component
public class CustomerJobListener extends AbstractDistributeOnceElasticJobListener {


    @Autowired
    private ZookeeperRegistryCenter zookeeperRegistryCenter;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 设置间隔时间
     */
    public CustomerJobListener() {
        super(0L, 0L);
    }

    /**
     * 任务开始
     * @param shardingContexts
     */
    @Override
    public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
        System.out.println("任务开始");

        List<Integer> asList = Arrays.asList(2, 2, 2, 2, 2, 2, 2, 22, 2, 2, 2);

    }

    /**
     * 任务结束
     * @param shardingContexts
     */
    @Override
    public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
        System.err.println("任务结束");
    }
}

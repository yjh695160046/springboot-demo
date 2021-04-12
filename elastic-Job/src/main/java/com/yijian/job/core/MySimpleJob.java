package com.yijian.job.core;

import com.yijian.job.config.ElasticSimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/8 13:54
 * @Description:
 */
@Slf4j
@ElasticSimpleJob(jobName = "mySimpleJob",
        cron = "0/10 * * * * ?",
        shardingTotalCount = 3,
        shardingParameter = "0=Beijing,1=Shanghai,2=Guangzhou",
        overwrite = true)
@Component
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info(String.format("------Thread ID: %s, 任务总片数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "当前任务名称: %s.当前任务参数: %s",
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
        ));


        //
        // 0
         // id =
        // 1
        // 2
    }
}

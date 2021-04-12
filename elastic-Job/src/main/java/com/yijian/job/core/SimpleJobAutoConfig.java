package com.yijian.job.core;

import com.yijian.job.config.ElasticSimpleJob;
import com.yijian.job.config.ZookeeperAutoConfig;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.api.listener.ElasticJobListener;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/8 13:56
 * @Description:
 */
@Configuration
@ConditionalOnBean(CoordinatorRegistryCenter.class)
@AutoConfigureAfter(ZookeeperAutoConfig.class)
public class SimpleJobAutoConfig {

    @Autowired
    private CoordinatorRegistryCenter coordinatorRegistryCenter;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ElasticJobListener elasticJobListener;

    /**
     * 自动注册
     */
    @PostConstruct
    public void initSimpleJob() {
        //获取spring的上下文
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(ElasticSimpleJob.class);
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            Object instance = entry.getValue();
            Class<?>[] interfaces = instance.getClass().getInterfaces();
            for (Class<?> superInterface : interfaces) {
                if (superInterface == SimpleJob.class) {
                    ElasticSimpleJob annotation = instance.getClass().getAnnotation(ElasticSimpleJob.class);
                    String jobName = annotation.jobName();
                    String cron = annotation.cron();
                    int shardingTotalCount = annotation.shardingTotalCount();
                    String shardingItemParameters = annotation.shardingParameter();
                    boolean overwrite = annotation.overwrite();
                    //注册定时任务
                    //job 核心配置
                     // .shardingItemParameters(shardingItemParameters)
                    JobConfiguration.Builder builder = JobConfiguration.newBuilder(jobName, shardingTotalCount).cron(cron);
                    builder.shardingItemParameters(shardingItemParameters);
                    builder.overwrite(overwrite);
                    JobConfiguration jobConfig = builder.build();
                    // 调度基于 class 类型的作业
                    ScheduleJobBootstrap bootstrap = new ScheduleJobBootstrap(coordinatorRegistryCenter, new MySimpleJob(), jobConfig, elasticJobListener);
                    bootstrap.schedule();
                    //JobCoreConfiguration buildJcc = JobCoreConfiguration
                    //        .newBuilder(jobName, cron, shardingTotalCount)
                    //        .build();
                    ////job类型配置
                    //SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(
                    //        buildJcc, instance.getClass().getCanonicalName()
                    //);
                    //// job配置(LiteJobConfiguration)
                    //LiteJobConfiguration buildLiteJobConfiguration = LiteJobConfiguration
                    //        .newBuilder(simpleJobConfiguration)
                    //        .overwrite(overwrite)
                    //        .build();
                    //
                    ////启动
                    //new JobScheduler(coordinatorRegistryCenter, buildLiteJobConfiguration).init();
                }
            }
        }

    }
}

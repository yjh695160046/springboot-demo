package com.yijian.job.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/8 13:52
 * @Description:
 */
@Target(ElementType.TYPE)//表示使用在哪：这里是类，
@Retention(RetentionPolicy.RUNTIME)//表示运行时进行启动
public @interface ElasticSimpleJob {

    String jobName() default "";

    String cron() default "";

    int shardingTotalCount() default 1;

    boolean overwrite() default false;

    String shardingParameter() default  "";

}
package com.yijian.job.mq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: yaojinhua
 * @date: 2021/5/22 15:07
 * @description:
 */
@Component
public class RocketMqPullConsumer {

    @Resource
    public RocketMQTemplate rocketMqTemplate;

    public void test(){

    }


}

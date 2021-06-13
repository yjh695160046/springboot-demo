package com.yijian.rocketmq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yaojinhua
 * @date: 2021/5/21 16:21
 * @description:
 */
@Component
@ConfigurationProperties(prefix = "rocketmq")
public class RocketMqProperties {

    /**
     * nameserver
     */
    private String namesrvAddr;

    /**
     * 发送消息的超时时间
     */
    private Integer sendMsgTimeoutMillis;

    /**
     * 失败重试次数
     */
    private Integer reconsumeTimes;

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public Integer getSendMsgTimeoutMillis() {
        return sendMsgTimeoutMillis;
    }

    public void setSendMsgTimeoutMillis(Integer sendMsgTimeoutMillis) {
        this.sendMsgTimeoutMillis = sendMsgTimeoutMillis;
    }

    public Integer getReconsumeTimes() {
        return reconsumeTimes;
    }

    public void setReconsumeTimes(Integer reconsumeTimes) {
        this.reconsumeTimes = reconsumeTimes;
    }
}

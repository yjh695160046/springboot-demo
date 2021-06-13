package com.yijian.rocketmq.pojo;

import lombok.Data;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: yaojinhua
 * @date: 2021/5/22 14:06
 * @description:
 */
@Data
public class MqMessage implements Message,Serializable {

    private static final long serialVersionUID = -3954584921643679512L;

    private Integer id;

    private String name;

    private String status;

    private Date createTime;

    @Override
    public Object getPayload() {
        return null;
    }

    @Override
    public MessageHeaders getHeaders() {
        return null;
    }
}

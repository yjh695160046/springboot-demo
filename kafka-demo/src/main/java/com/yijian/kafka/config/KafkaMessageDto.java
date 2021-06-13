package com.yijian.kafka.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class KafkaMessageDto {


    private String messageId;

    private Object data;
}

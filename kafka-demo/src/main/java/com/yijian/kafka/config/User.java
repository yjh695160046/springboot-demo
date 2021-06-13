package com.yijian.kafka.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/13 11:17
 * @Description:
 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private String name;

    private Integer age;
}

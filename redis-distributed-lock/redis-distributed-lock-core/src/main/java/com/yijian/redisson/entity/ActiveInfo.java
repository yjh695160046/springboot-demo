package com.yijian.redisson.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yxyaojinhua
 */
@Data
public class ActiveInfo implements Serializable {

    private static final long serialVersionUID = 7875568398810867188L;

    private String time;

    private String mobile;

    private String ipAddress;

    private String account;

    private String city;

}

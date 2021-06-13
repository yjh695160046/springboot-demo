package com.yijian.kafka.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Login implements Serializable {
    private String mobile;
    private String password;
    private String code;

    //    private boolean isValidate = false; //是否开启验证  默认false
    private String sessionId;   //会话ID
    private String sig;         //签名串
    private String token;
    private String scene;       //场景标识

    private Long activateTime;

}
package com.yijian.demospringbootstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.io.Serializable;

/**
 * 类描述：SmsProperties
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-28 15:39
 */
@ConfigurationProperties("demo.sms")
public class SmsProperties implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 访问ID、即帐号
     */
    private String accessKeyId;

    /**
     * 访问凭证，即密码
     */
    private String accessKeySecret;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}

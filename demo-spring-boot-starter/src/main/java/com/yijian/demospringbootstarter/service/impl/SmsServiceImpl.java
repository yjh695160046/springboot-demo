package com.yijian.demospringbootstarter.service.impl;

import com.yijian.demospringbootstarter.config.SmsProperties;
import com.yijian.demospringbootstarter.service.SmsService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 类描述：SmsServiceImpl
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-28 15:35
 */
public class SmsServiceImpl implements SmsService {

    @Resource
    private SmsProperties smsProperties;

    @Override
    public void send(String phone, String templateCode, Map<Object, Object> params) {
        System.out.println("接入短信系统，accessKeyId=" + smsProperties.getAccessKeyId()
                + ",accessKeySecret=" + smsProperties.getAccessKeySecret());
        System.out.println("短信发送，phone=" + phone + ",templateCode=" + templateCode + ",params=" + params);
    }

}

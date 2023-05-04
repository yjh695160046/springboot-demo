package com.yijian.demospringbootstarter.service;

import java.util.Map;

/**
 * 接口描述：短信服务
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-28 15:33
 */
public interface SmsService {


    /**
     * 发送短信
     *
     * @param phone        手机号
     * @param templateCode 短信模板
     * @param params       参数
     */
    void send(String phone, String templateCode, Map<Object, Object> params);

}

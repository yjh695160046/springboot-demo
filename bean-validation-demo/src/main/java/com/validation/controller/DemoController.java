package com.validation.controller;

import com.yijian.demospringbootstarter.service.SmsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 类描述：DemoController
 *
 * @author yaojinhua
 * @version v1.0
 * @date 2023-02-28 15:48
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private SmsService smsService;

    @PostMapping("/send/sms")
    public void sendSms(){
        HashMap<Object, Object> paramMap = new HashMap<>(16);
        paramMap.put("code", 123);
        paramMap.put("time", "5分钟");
        smsService.send("15071415590",
                "123", paramMap);
    }

}

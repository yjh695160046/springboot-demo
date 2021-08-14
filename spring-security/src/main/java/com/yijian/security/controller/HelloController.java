package com.yijian.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/27 10:51
 * @description:
 */
@RestController
@Slf4j
public class HelloController {

    /**
     * 默认 引入security后 接口就受保护了 未加任何配置之前 请求接口需要登录
     *      默认用户密码user 密码启动项目时生成
     * @return
     */
    @RequestMapping("/hello/security")
    public String hello(){

        return "hello security  ";
    }
}

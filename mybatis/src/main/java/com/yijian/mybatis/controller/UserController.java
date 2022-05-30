package com.yijian.mybatis.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.yijian.mybatis.core.cglib.CglibProxyFactory;
import com.yijian.mybatis.entity.User;
import com.yijian.mybatis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/17 20:20
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/select/{id}")
    private User selectUser(@PathVariable("id") Long id,
                            @RequestParam(required = true, value = "requestParam") String requestParam,
                            Map<String, Object> map, User user) throws Exception{
        Long aa = null;
        DateTime dateTime = DateUtil.offsetMonth(new DateTime(aa), 3);
        return userService.selectUserById(id);
    }

    @GetMapping("/update/{id}")
    private User updatetUser(@PathVariable("id") Long id) {
        return userService.updateUserById(id);
    }
    @GetMapping("/arthas")
    private void arthas() {
//        SmsService proxy = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
//        System.out.println(proxy);
        com.yijian.mybatis.core.cglib.SmsServiceImpl cglibProxy = (com.yijian.mybatis.core.cglib.SmsServiceImpl) CglibProxyFactory.getProxy(com.yijian.mybatis.core.cglib.SmsServiceImpl.class);
        cglibProxy.send();
    }
}


package com.yijian.mybatis.controller;

import com.yijian.mybatis.entity.CommonResult;
import com.yijian.mybatis.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/4 16:42
 * @description: 验证spring的事务
 */
@RestController
@RequestMapping("/spring/transaction")
public class SpringTransactionController {

    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public Object springTransaction(@RequestParam("id") Long id){

        try {
            userService.selectUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return CommonResult.success();

    }
}

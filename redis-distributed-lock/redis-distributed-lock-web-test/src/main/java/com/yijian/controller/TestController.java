package com.yijian.controller;

import cn.hutool.core.date.DateUtil;
import com.yijian.redisson.entity.ActiveInfo;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: yaojinhua
 * @date: 2021/6/1 15:47
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/checkDate")
    public Object saveSet() {

        return DateUtil.offsetDay(new Date(), -29);


    }

}

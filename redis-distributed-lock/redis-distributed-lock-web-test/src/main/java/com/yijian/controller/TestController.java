package com.yijian.controller;

import cn.hutool.core.date.DateUtil;
import com.yijian.redisson.entity.ActiveInfo;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author: yaojinhua
 * @date: 2021/6/1 15:47
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/checkDate")
    public Object saveSet(@RequestBody Map<String, Object> map) {

        return map;


    }

}

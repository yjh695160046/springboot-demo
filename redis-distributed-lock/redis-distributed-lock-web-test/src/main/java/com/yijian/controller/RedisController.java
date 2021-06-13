package com.yijian.controller;

import com.yijian.redisson.entity.ActiveInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: yaojinhua
 * @date: 2021/6/1 10:25
 * @description:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/saveSet")
    public Object saveSet() {
        SetOperations<String, Object> opsForSet = redisTemplate.opsForSet();

        String dayKey = "active_day_set" + "_" + "2021-06-01";
        for (int i = 0; i < 10; i++) {
            ActiveInfo activeInfo = new ActiveInfo();
            activeInfo.setCity("3301");
            activeInfo.setAccount("15071415590");
            opsForSet.add(dayKey, activeInfo);
        }

        return opsForSet.members(dayKey);
    }




}

package com.yijian.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author: yxyaojinhua
 * @date: 2022/5/19 17:02
 * @description:
 */
@RestController
@RequestMapping("/api")
public class SeckillController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/seckill")
    @ResponseBody
    public Object testSeckill(@RequestParam(defaultValue = "1") Integer activityId) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Long requestNum = redisTemplate.opsForValue().increment("requestNum", 1);
        if (requestNum > 500) {
            resultMap.put("msg", "活动太火爆了。。。");
            return resultMap;
        }
        System.out.println(requestNum + "恭喜您秒杀成功，请及时下单");
        resultMap.put("msg", "恭喜您秒杀成功，请及时下单。。。");
        return resultMap;
    }
}

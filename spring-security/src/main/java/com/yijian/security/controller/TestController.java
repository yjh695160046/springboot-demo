package com.yijian.security.controller;

//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import javax.annotation.Resource;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/13 16:39
 * @Description:
 */
@Controller
public class TestController {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/hello")
    @ResponseBody
    public Object helloSecurity() {
        Map<String, Object> resultCapacityInfo = new HashMap<>();
        // 预留总容量、已使用容量、用户平均使用量
        resultCapacityInfo.put("reservedSpace", "100000TB");
        //resultCapacityInfo.put("usedSpace", stringRedisTemplate.opsForValue().get(RedisNasStatsKey.ALL_USER_CAPACITYUSED_TOTAL_KEY));
        //resultCapacityInfo.put("userAverageSpace", stringRedisTemplate.opsForValue().get(RedisNasStatsKey.ALL_USER_CAPACITYUSED_TOTAL_AVERAGE_KEY));
        //String key = RedisNasStatsKey.NAS_REGISTER_RECENT_AREA_TOTAL + RedisNasStatsKey.SUFFIX;
        //stringRedisTemplate.opsForValue().increment(String.format(key, nasUserBackupEntity.getProvince(), nasUserBackupEntity.getCity()), 1);
        //stringRedisTemplate.opsForValue().increment(String.format(key, nasUserBackupEntity.getProvince(), 0), 1);
        Set<String> test = stringRedisTemplate.keys("test*");
        return test;
    }
}

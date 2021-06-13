package com.yijian.kafka;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yijian.kafka.entity.NasUserBackup1Entity;
import com.yijian.kafka.mapper.NasUserBackup1Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/7 14:52
 * @Description:
 */
@SpringBootTest
public class JunitTest {
    @Resource
    private NasUserBackup1Mapper nasUserBackup1Mapper;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test01() {
        //List<NasUserBackup1Entity> list = nasUserBackup1Mapper.selectList(new QueryWrapper<>());
        //System.out.println(list.size());s
        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("tet", 111);
    }

}


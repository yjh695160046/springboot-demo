package com.yijian.mybatis;

import com.yijian.mybatis.entity.User;
import com.yijian.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/13 17:09
 * @description:
 */
@SpringBootTest
public class MybatisApplicationTests {


    @Resource
    private SqlSessionFactory SqlSessionFactory;

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;



    @Test
    public void list(){

        ListOperations<String, Integer> opsForList = redisTemplate.opsForList();

        // 左  头插
        opsForList.leftPush("leftlist", 1);
        opsForList.leftPush("leftlist", 2);
        opsForList.leftPush("leftlist", 3);
        opsForList.leftPush("leftlist", 4);
        // 把5加在4之前
        opsForList.leftPush("leftlist", 4, 5);
        List<Integer> leftlist = opsForList.range("leftlist", 0, -1);
        leftlist.forEach(System.out::println);
        System.out.println("--------------------------------");

        opsForList.rightPush("rightlist", 1);
        opsForList.rightPush("rightlist", 2);
        opsForList.rightPush("rightlist", 3);
        opsForList.rightPush("rightlist", 4);
        opsForList.rightPush("rightlist", 4, 5);
        List<Integer> rightlist = opsForList.range("rightlist", 0, -1);
        rightlist.forEach(System.out::println);



    }

    /**
     * 有序集合操作 跳表来实现的 建立多级索引
     */
    @Test
    public void zSet(){
        ZSetOperations<String, Integer> zSet = redisTemplate.opsForZSet();
        zSet.add("1", 2, 1);
        zSet.add("1", 3, 0);
        zSet.add("1", 3, 0);
        zSet.add("1", 3, 0);
        zSet.add("1", 3, 0);
        zSet.add("1", 3, 5);
        Set<Integer> range = zSet.range("1", 0, -1);
        for (Object o : range) {
            System.out.println(o);
        }
    }










    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1L);
        System.out.println(user);
        User user2 = mapper.selectById(1L);
        System.out.println(user2);
    }
}

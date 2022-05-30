package com.yijian.mybatis.controller;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: yxyaojinhua
 * @date: 2022/1/20 15:15
 * @description:
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    @Resource
    private RedisTemplate<String, Object> objectRedisTemplate;

    @RequestMapping("/hash")
    public Object hash(){
        HashOperations<String, Object, Object> hashOperations = objectRedisTemplate.opsForHash();
        hashOperations.put("hash", 1, "这是第一个hash");
        hashOperations.put("hash", 2, "这是第二个hash");
        Map<Object, Object> hash = hashOperations.entries("hash");
        hash.forEach((o, o2) -> System.out.println("o ==>" + o + ", o2 ==> " + o2));
        System.out.println(hashOperations.get("hash", 1));
        return hash;
    }


    @RequestMapping("/set")
    public Object set(){
        SetOperations<String, Object> setOperations = objectRedisTemplate.opsForSet();
        setOperations.add("set", "set", 1, 2 ,3, 4, 8, 5, "9", "set");
        Set<Object> setList = setOperations.members("set");
        for (Object integer : setList) {
            System.out.print(integer + "、");
        }
        return setList;
    }

    /**
     * 有序集合，不可重复
     */
    @RequestMapping("/zset")
    public void zset() {
        ZSetOperations<String, Integer> zSet = redisTemplate.opsForZSet();
        zSet.add("zset", 3, 5);
        zSet.add("zset", 2, 1);
        zSet.add("zset", 3, 0);
        zSet.add("zset", 3, 0);
        zSet.add("zset", 3, 0);
        zSet.add("zset", 3, 0);
        // 根据第三个参数double score分值 来进行排序的
        Set<Integer> range = zSet.range("1", 0, -1);
        Set<ZSetOperations.TypedTuple<Integer>> typedTuples = zSet.rangeWithScores("1", 0, -1);
        for (ZSetOperations.TypedTuple<Integer> typedTuple : typedTuples) {
            System.out.println(typedTuple.getValue() + " : " + typedTuple.getScore());
        }
        for (Object o : range) {
            System.out.println(o);
        }
    }


    @RequestMapping("/list")
    public void list() {
        ListOperations<String, Integer> opsForList = redisTemplate.opsForList();
        // 左  头插/**/
        opsForList.leftPush("leftlist", 1);
        opsForList.leftPush("leftlist", 2);
        opsForList.leftPush("leftlist", 3);
        opsForList.leftPush("leftlist", 4);
        /**
         *  pivot 支点，轴点
         * 把5加在4之前 before pivot支点 将value放到指定参数第一次出现之前，
         *  如果参数在列表中找不到则不加 ， Long leftPush(K key, V pivot, V value);
         */
        opsForList.leftPush("leftlist", 4, 3);
        List<Integer> leftlist = opsForList.range("leftlist", 0, -1);
        leftlist.forEach(System.out::println); // 先入后出

        /**
         *  leftPop： 移除返回列表中的头元素
         *  其中： leftPush + leftPop 可组成栈 先入后出
         */
        Integer leftPop1 = opsForList.leftPop("leftlist");
        System.out.println(leftPop1);
        /**
         * rightPop : 移除列表中的尾元素
         * 其中： leftPush +  rightPop 可组成队列 先入先出
         */
        Integer rightPop = opsForList.rightPop("leftlist");
        System.out.println(rightPop);

        System.out.println("--------------------------------");

        // 右 尾插
        opsForList.rightPush("rightlist", 1);
        opsForList.rightPush("rightlist", 2);
        opsForList.rightPush("rightlist", 3);
        opsForList.rightPush("rightlist", 4);
        /**
         *  pivot 支点，轴点
         *  5加在4之后 after pivot支点 将value放到指定参数第一次出现之后，
         *    如果参数在列表中找不到则不加 Long rightPush(K key, V pivot, V value);
         */
        opsForList.rightPush("rightlist", 4, 5);
        List<Integer> rightlist = opsForList.range("rightlist", 0, -1);
        rightlist.forEach(System.out::println);

    }



}

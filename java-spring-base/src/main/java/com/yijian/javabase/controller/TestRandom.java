package com.yijian.javabase.controller;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/14 16:12
 * @description: 负载均衡随机
 */
public class TestRandom {

    private static final Map<String, Integer> serverMap = new LinkedHashMap<>();
    static ThreadLocalRandom random = ThreadLocalRandom.current();

    static {
        serverMap.put("127.0.0.1", 1);
        serverMap.put("127.0.0.2", 1);
        serverMap.put("127.0.0.3", 1);
    }

    public static String random() {
        Map<String, Integer> randomMap = new ConcurrentHashMap<>(serverMap);
        // 取出key
        Set<String> ipSet = serverMap.keySet();
        List<String> ipList = new ArrayList<>(ipSet);
        int pos = random.nextInt(ipList.size());
        System.out.println("pos : " + pos);
        return ipList.get(pos);
    }

}

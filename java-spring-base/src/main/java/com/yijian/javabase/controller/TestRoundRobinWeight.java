package com.yijian.javabase.controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/14 16:52
 * @description: 负载均衡轮询加权重
 */
@Component
public class TestRoundRobinWeight {

    private static final Map<String, Integer> SERVER_MAP = new LinkedHashMap<>(3);
    private static final ArrayList<String> WEIGHT_SERVER_LIST = new ArrayList<>();
    // 服务器下标
    volatile Integer pos = 0;

    static {
        SERVER_MAP.put("127.0.0.1", 5);
        SERVER_MAP.put("127.0.0.2", 3);
        SERVER_MAP.put("127.0.0.3", 1);
        List<String> ipServerList = new LinkedList<>(SERVER_MAP.keySet());
        Iterator<String> iterator = ipServerList.iterator();
        while (iterator.hasNext()) {
            String nextServerName = iterator.next();
            Integer weight = SERVER_MAP.get(nextServerName);
            for (int i = 0; i < weight; i++) {
                WEIGHT_SERVER_LIST.add(nextServerName);
            }
        }
    }

    public synchronized String pollingWeight() {
        String serverName = "";
        if (pos >= WEIGHT_SERVER_LIST.size()) {
            pos = 0;
        }
        System.out.println(pos);
        serverName = WEIGHT_SERVER_LIST.get(pos);
        System.out.println(serverName);
        pos++;
        return serverName;
    }


}

package com.yijian.javabase.controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/14 16:52
 * @description: 负载均衡轮询
 */
@Component
public class TestRoundRobin {

    private static final Map<String, Integer> SERVER_MAP = new LinkedHashMap<>();
    Integer pos = 0;

    static {
        SERVER_MAP.put("127.0.0.1", 1);
        SERVER_MAP.put("127.0.0.2", 1);
        SERVER_MAP.put("127.0.0.3", 1);
    }

    public String polling() {
        String serverName;
        Set<String> keySet = SERVER_MAP.keySet();
        ArrayList<String> arrayList = new ArrayList<>(keySet);
        synchronized (this) {
            if (pos >= arrayList.size()) {
                pos = 0;
            }
            serverName = arrayList.get(pos);
            System.out.println(serverName);
            pos++;
        }
        return serverName;
    }


}

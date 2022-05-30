package com.example.demo;

import java.util.concurrent.ConcurrentHashMap;

// @SpringBootApplication
public class Java17Application {

    public static void main(String[] args) {
        Class<ConcurrentHashMap> concurrentHashMapClass = ConcurrentHashMap.class;

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        objectObjectConcurrentHashMap.put("a", 1);
        objectObjectConcurrentHashMap.put("a", 1);
        System.out.println(objectObjectConcurrentHashMap);

        // SpringApplication.run(Java17Application.class, args);
    }

}

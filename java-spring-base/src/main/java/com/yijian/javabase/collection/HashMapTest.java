package com.yijian.javabase.collection;

import java.util.HashMap;

/**
 * @author: yxyaojinhua
 * @date: 2021/10/17 14:51
 * @description:
 */
public class HashMapTest {
    public static void main(String[] args) {

        HashMap<Integer, Object> map = new HashMap<>(3);
        map.put(12, "张三");
        map.put(13, "李四");
        map.put(14, "王五");
        map.put(15, "马六");
        map.put(null, "赵六");
        map.put(null, "田七");
        map.put(19, null);
//        HashMap<Integer, Object> newHashmap = new HashMap<>(map);
//        System.out.println(newHashmap.toString());
    }
}

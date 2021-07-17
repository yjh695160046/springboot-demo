package com.yijian.javabase.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/13 17:00
 * @description:  cas 比较并交换 compareAndSet 缺点是底层有循环 对CPU带来很大开销 保证原子性 是底层的Unsafe类
 *                 CPU并发原语
 */
public class CASDemo {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data: "+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data: "+atomicInteger.get());

        System.out.println(60 * 60 * 24 * 7);
    }
}

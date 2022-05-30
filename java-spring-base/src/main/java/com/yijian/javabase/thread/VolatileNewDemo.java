package com.yijian.javabase.thread;


import lombok.SneakyThrows;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/14 15:42
 * @description:
 */
public class VolatileNewDemo {

    int a = 10;

    public static void main(String[] args) throws Exception {
//        VolatileNewDemo volatileNewDemo = new VolatileNewDemo();
//        new Thread(new Runnable() {
//            @SneakyThrows
//            @Override
//            public void run() {
//                TimeUnit.SECONDS.sleep(1);
//                volatileNewDemo.a = 20;
//            }
//        }).start();
//
//        while (volatileNewDemo.a == 10) {}
//        System.out.println(Thread.currentThread().getName() + "\t mission is over");
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo, "AAA").start();
        while (demo.flag == 10) {}
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}

class ThreadDemo implements Runnable {
    volatile int flag = 10;
    @Override
    @SneakyThrows
    public void run() {
        Thread.sleep(2000);
        flag = 20;
    }
}
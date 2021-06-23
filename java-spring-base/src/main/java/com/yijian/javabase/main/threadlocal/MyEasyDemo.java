package com.yijian.javabase.main.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yaojinhua
 * @date: 2021/6/15 14:42
 * @description:
 */
public class MyEasyDemo {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        // 多个线程访问同一个变量 会出现线程安全的问题 线程间的数据没有隔离 但是每个线程都创建MyEaseDemo对象 维护自己的变量 则没有问题
        MyEasyDemo demo = new MyEasyDemo();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                demo.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("-----------------------");
                System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
            });
            thread.setName("线程" + i);
            thread.start();
        }















        // 最大线程数和核心线程数一致
        //ExecutorService executorService = Executors.newFixedThreadPool(5);
        //MyEasyDemo demo = new MyEasyDemo();
        //for (int i = 0; i < 10; i++) {
        //    final int index = i;
        //    executorService.execute(new Runnable() {
        //        @Override
        //        public void run() {
        //            demo.setContent(Thread.currentThread().getName() + index +"的数据");
        //            System.out.println("----------------------------------------");
        //            System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
        //        }
        //    });
        //}
    }
}

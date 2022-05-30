package com.yijian.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/27 10:54
 * @description:
 */
public class CountDownLatchTest {
    /**
     * 概念：
     *   是一个同步工具类，用来协调多个线程间的同步，或者说起到线程之间的通信
     *   CountDownLatch能够使一个线程在等待另外一些线程完成各自的工作之后，再继续执行
     *      使用一个计数器进行实现，计数器初始值为线程的数量，当每一个线程完成自己的任务后，计数器就会减一，
     *      当计数器的值为0时，便表示所有的线程都已经完成了一些任务，然后在CountDownLatch上等待的线程就可以恢复执行接下来的任务。
     *
     * 用法：
     *    1、当一线程在开始运行前等待n个线程执行完毕，将CountDownLatch的值在计数器初始化new CountDownLatch(n)，每当一个任务线程执行完毕，
     *       就将计数器减一 countdownLathc.conutDown()， 当计数器的值变成0时， 在CountDownLatch上await()的线程就会被唤醒。
     *       一个典型的应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后在继续执行。
     * 不足：
     *   CountDownLatch是一次性的，计数器的值只能在构造方法中初始化一次，之后没有任何机制再次对其设置值，当CountDownLatch使用完毕后，不能再次被使用。
     *
     *
     */
    public static void main(String[] args) throws Exception {
        final CountDownLatch count = new CountDownLatch(7);
        for (int i = 1; i < 8; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format(Thread.currentThread().getName() + ": 第 %s 颗龙珠被找到了， date : %s", finalI, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
                    count.countDown();
                }
            }, "A" + finalI).start();
        }
        count.await();
        // 主线程的执行必须等到子线程任务都执行完毕
        System.out.println(String.format(Thread.currentThread().getName() + " : 龙珠集齐， date : %s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));

        // twoCountDownLatch();
    }

    /**
     * 两个CountDownLatch实现顺序打印
     */
    private static void twoCountDownLatch() {
        final CountDownLatch count = new CountDownLatch(1);
        final CountDownLatch count1 = new CountDownLatch(1);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("打开冰箱。。。。");
                count.countDown();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    count.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("放入牛奶。。。。");
                count1.countDown();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    count1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("关闭冰箱。。。。");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }





}

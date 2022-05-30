package com.yijian.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: yxyaojinhua
 * @date: 2022/5/8 17:21
 * @description:
 */
public class CyclicBarrierTest {
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5,
            () -> System.out.println("所有运动员入场，裁判员一声令下！！！"));

    public static void main(String[] args) {
        System.out.println("运动员准备进场，全场欢呼......");
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 运动员到达起点，准备好了！！！");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 运动员出发！！！");
                }
            }).start();
        }
    }
}

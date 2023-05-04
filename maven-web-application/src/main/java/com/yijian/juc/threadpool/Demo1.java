package com.yijian.juc.threadpool;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {
        //阻塞队列，设置阻塞任务最多为10个
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);
        //线程工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //拒绝策略 当线程池的最大工作线程跑满以及阻塞队列满了的话，会由拒绝策略处理剩下的任务
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        //创建线程池  核心线程数为5  最大线程数为10 非核心线程空闲存活时间为60s
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 60L,
                TimeUnit.SECONDS, blockingQueue, threadFactory, discardPolicy
        );
        for (int i = 0; i < 20; i++) {
            //创建10个任务，如果要是创建>20个任务，则20以外的任务会交由拒绝策略处理
            Task task = new Task("task" + i);
            //让我们自定义的线程池去跑这些任务
            threadPoolExecutor.execute(task);
        }
        System.out.println(threadPoolExecutor);
        //记得要关闭线程池
        threadPoolExecutor.shutdown();
    }
}

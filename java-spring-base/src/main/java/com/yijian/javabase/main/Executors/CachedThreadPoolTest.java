package com.yijian.javabase.main.Executors;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yaojinhua
 * @date: 2021/5/31 11:08
 * @description:
 */
public class CachedThreadPoolTest {

    /**
     * 核心线程数为0 都是空闲线程 临时创建 用完到时间就销毁  最大线程数为 Integer.MAX_VALUE  线程数可以无限制增加
     * public static ExecutorService newCachedThreadPool() {
     *     return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
     *                                   60L, TimeUnit.SECONDS,
     *                                   new SynchronousQueue<Runnable>());
     * }
     *
     *
     *
     */
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            final int index = i;
            executorService.execute(() -> {
                System.out.println(DateUtil.now() + " " + Thread.currentThread().getName() + " " + index);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            });

        }
        executorService.shutdown();




    }
}

package com.yijian.javabase.main.Executors;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yaojinhua
 * @date: 2021/5/31 10:54
 * @description:
 */
public class SingleThreadExecutorTest {
    /**
     * 线程的特点是它的核心线程数和最大线程数均为 1，我们也可以将其任务是一个单例线程池
     * 不管任务有多少 只有唯一的线程去执行 没有空闲线程 都是常驻线程
     *  这个线程池非常适合任务按照顺序执行的场景 是个串行
     *  public static ExecutorService newSingleThreadExecutor() {
     *     return new FinalizableDelegatedExecutorService
     *         (new ThreadPoolExecutor(1, 1,
     *                                 0L, TimeUnit.MILLISECONDS,
     *                                 new LinkedBlockingQueue<Runnable>()));
     * }
     *
     */
    public static void main(String[] args) {
        /**
         * Ctrl + Alt + V 快速生成方法返回值
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            executorService.execute(() -> {
                System.out.println(DateUtil.now() + " " + Thread.currentThread().getName() + " " + index);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            });

        }

    }


}

package com.yijian.javabase.main.Executors;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yaojinhua
 * @date: 2021/5/28 17:10
 * @description:
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) throws Exception {

        /**
         *   FixedThreadPool 核心线程数和最大线程数一致
         *   内部创建 线程调用的是 ThreadPoolExecutor
         *    param : nThreads 作为最大线程数及核心线程数
         *        public static ExecutorService newFixedThreadPool(int nThreads) {
         *         return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *      }
         *   可以看做固定线程数的线程池  最开始从0开始创建 但是创建好后就不再销毁 全部作为常驻线程存在
         *    核心线程数等于最大线程数  而线程池中的线程总数不得大于最大线程数 所有线程池的线程全部作为常驻线程存在
         *    做为常驻线程 不会被销毁 所以3、4参数无意义 它们是空闲线程时间
         *
         *    当线程处理不了时会加入到阻塞队列 、队列采用了一个链表结构的有界队列  最大长度是Integer. MAX_VALUE
         *
         */


        ExecutorService executorService = Executors.newFixedThreadPool(100);

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

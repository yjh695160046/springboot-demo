package com.yijian.javabase.main.Executors;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: yaojinhua
 * @date: 2021/5/31 11:24
 * @description:
 */
public class ScheduledThreadPoolTest {
    /**
     * 线程池是支持定时或者周期性执行任务
     */
    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        // 1. 延迟一定时间执行一次
        System.out.println(DateUtil.now() + " " + "任务开始");
        //executorService.schedule(() -> {
        //    System.out.println(DateUtil.now() + " " + "schedule ==> 云栖简码-i-code.online");
        //}, 30, TimeUnit.SECONDS);

        // 2. 按照固定频率周期执行  initialDelay 初始延迟
        executorService.scheduleAtFixedRate(() -> {
            System.out.println(DateUtil.now() + "scheduleAtFixedRate ==> 云栖简码-i-code.online");
        }, 6, 6, TimeUnit.SECONDS);

        ////3. 按照固定频率周期执行
        //executorService.scheduleWithFixedDelay(() -> {
        //    System.out.println("scheduleWithFixedDelay ==> 云栖简码-i-code.online");
        //}, 2, 5, TimeUnit.SECONDS);


    }
}

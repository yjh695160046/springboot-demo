package com.yijian.juc.threadpool;


import cn.hutool.core.date.DateUtil;

public class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            //模拟每个任务的耗时
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        System.out.println("now: " + DateUtil.now() + " +线程池系列 当前线程名字是 " + name + "  处理了  " + taskName + "  任务");
    }
}
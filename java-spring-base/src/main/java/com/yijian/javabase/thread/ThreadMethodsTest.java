package com.yijian.javabase.thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author: yaojinhua
 * @date: 2021/6/23 11:07
 * @description:
 */
public class ThreadMethodsTest {

    public static void main(String[] args) {
        /**
         * 常用方法：
         *  start() Thread类的方法 启动当前线程 就绪状态
         *  run() 开启一个线程后 需要执行的操作
         *  currentThread Thread的静态方法 返回执行当前代码的线程
         *  getName 获取当前线程的名称
         *  setName 设置线程的名称
         *  yield()  礼让线程 释放当前cpu的执行权 线程状态从 运行 -> 就绪 (当前线程有可能再次执行 cpu分配到了)
         *  join() 在线程a中调用线程b的join 此时线程a进入阻塞状态 直到线程b执行完 线程a结束阻塞状态 返回就绪状态 等待cpu执行 (重点)
         *  daemon() 后台守护线程 所有的线程都是守护线程则jvm退出
         *  sotp() 已过时 强制结束当前线程
         *  sleep(long time) time休眠的毫秒数 在指定的毫秒数内线程是阻塞状态 不释放锁
         *
         * 线程的调度
         *   时间片
         *   抢占式 高优先级的抢占cpu
         *   MIN_PRIORITY = 1;
         *   NORM_PRIORITY = 5; -- 默认优先级
         *   MAX_PRIORITY = 10;
         *   如何获取线程优先级和设置优先级
         *      setPriority(int p) 设置线程的优先级
         *      getPriority() 获取线程优先级
         *     说明从概率上来讲 高优先级的要抢占第优先级的cpu的执行权 但不意味着 高优先级的执行完 低优先级的才能执行
         *
         *
         *
         *
         */
        // 打印main线程默认优先级 是多少
        System.out.println(Thread.currentThread().getPriority());

        Thread thread1 = new Thread(ThreadMethodsTest::testRun1);
        thread1.setPriority(10);
        thread1.start();
        //try {
        //    thread1.join();
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        Thread thread2 = new Thread(ThreadMethodsTest::testRun2);
        thread1.setPriority(1);
        thread2.start();
        //try {
        //    thread2.join();
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        System.out.println("我是main线程我在等待testRun1执行完");
    }
    static void testRun1(){
        //
        Thread.yield();
        //try {
        //    Thread.sleep(3000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        for (int i = 0; i < 10; i++) {
            System.out.println("testRun1:" + i);
        }
        //System.out.println("我是匿名匿名内部类runnable testRun1");
        //Thread.currentThread().setName("我是一个新建的线程 testRun1");
        //System.out.println(Thread.currentThread().getName());

    }
    static void testRun2(){
        for (int i = 0; i < 10; i++) {
            System.out.println("testRun2:" + i);
        }
        //System.out.println("我是匿名匿名内部类runnable testRun2");
        //Thread.currentThread().setName("我是一个新建的线程 testRun2");
        //System.out.println(Thread.currentThread().getName());

    }

}

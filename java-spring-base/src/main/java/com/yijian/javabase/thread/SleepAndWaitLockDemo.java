package com.yijian.javabase.thread;

/**
 * @author: yaojinhua
 * @date: 2021/6/30 11:06
 * @description: wait() 和 sleep()锁释放问题
 */
public class SleepAndWaitLockDemo {
    private  Object objectLock = new Object();
    public static void main(String[] args) {
        SleepAndWaitLockDemo sleepAndWaitLockDemo = new SleepAndWaitLockDemo();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> sleepAndWaitLockDemo.waitTest()).start();
        }

    }


    /**
     * wait() 会释放锁
     */
    public  void waitTest(){
        synchronized(this){
            System.out.println(this instanceof SleepAndWaitLockDemo);
            try {
                // 默认写是this
                wait(5000);
                System.out.println("我是wait() 我释放锁 ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * sleep() 不会释放锁
     */
    public synchronized void sleepTest(){
        System.out.println(this instanceof SleepAndWaitLockDemo);
        try {
            Thread.sleep(2000);
            System.out.println("我是sleep() 我不释放锁 必须要等待休眠时间到");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

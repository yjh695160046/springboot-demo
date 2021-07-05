package com.yijian.javabase.thread;

/**
 * @author: yaojinhua
 * @date: 2021/6/30 15:38
 * @description:
 */
class MyData {

    public volatile int number;

    public void add() {
        this.number = 60;
    }

}

public class VolatileDemo {

    /**
     * 轻量级的同步机制
     * 1.保证可见性
     * 2.不保证原子性
     * 3.禁止指令重排（保证有序性）
     * <p>
     * JMM  JAVA内存模型
     *
     *
     */


    public static void main(String[] args) {

        // 可见性
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
        }, "线程A").start();

        while (myData.number == 0) {
            //System.out.println("主线程number:" + myData.number);
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }


}

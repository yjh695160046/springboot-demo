package com.yijian.javabase.thread;

import lombok.SneakyThrows;

/**
 * @author: yaojinhua
 * @date: 2021/6/22 15:02
 * @description:
 */
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : 我是main线程");
        //MyThread myThread = new MyThread();
        //myThread.start();
        //
        ////new Thread(new MyRunnable()).start();
        //for (int i = 0; i < 20; i++) {
        //    System.out.println(Thread.currentThread().getName() + "index ： " + i + "  : 我是main线程");
        //}
        //
        //Runnable r = new Runnable() {//多态
        //    //重写run方法，设置线程任务
        //    @Override
        //    public void run() {
        //        for (int i = 0; i < 20; i++) {
        //            System.out.println(Thread.currentThread().getName() + "-->" + "B");
        //        }
        //
        //    }
        //};
        //创建Runnable接口的实现类对象
        SellTicket run = new SellTicket();
        //创建Thread对象，构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);

        //调用方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "index ： " + i + "  : 我是通过继承Thread类来实现创建线程的");
        }

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "index ： " + i + "  : 我是通过继承Runnable接口来实现创建线程的");
        }
    }
}


class SellTicket implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true){

            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
                --ticket;
            } else {
            }
        }
    }
}



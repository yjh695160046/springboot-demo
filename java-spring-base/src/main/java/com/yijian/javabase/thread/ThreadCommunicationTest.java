package com.yijian.javabase.thread;

/**
 * @author: yaojinhua
 * @date: 2021/6/24 16:28
 * @description:
 */

import lombok.SneakyThrows;

/**
 * 模拟线程通信 交替打印1-100
 * wait() 阻塞
 * sleep()
 * <p>
 * notity()
 * notityAll()
 */
class Number implements Runnable {
    private int i = 0;

    @SneakyThrows
    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                notifyAll();
                if (i <= 100) {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                } else {
                    System.out.println("break :" + i);
                    break;
                }
                wait();
            }
            //try {
            //    Thread.sleep(10);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
        }


    }
}

public class ThreadCommunicationTest {
    public static void main(String[] args) {

        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
        thread1.start();
        thread2.start();

    }
}

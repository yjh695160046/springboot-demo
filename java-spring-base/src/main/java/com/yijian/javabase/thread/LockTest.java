package com.yijian.javabase.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yaojinhua
 * @date: 2021/6/28 19:36
 * @description:
 */
public class LockTest {


    private static int num = 100;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(LockTest::testRun, "a").start();
        new Thread(LockTest::testRun, "b").start();
        new Thread(LockTest::testRun, "c").start();
        new Thread(LockTest::testRun, "d").start();


    }


    public static void testRun() {
        //Lock lock = new ReentrantLock();
        while (true) {
            //try {
            //    lock.lock();
            //    if (num <= 100 && num > 0 ) {
            //        System.out.println(Thread.currentThread().getName() + ":" + num);
            //        num--;
            //    } else {
            //        break;
            //    }
            //} catch (Exception e) {
            //    System.out.println(e);
            //} finally {
            //    lock.unlock();
            //}

            try {
                if (lock.tryLock(1, TimeUnit.SECONDS)) {
                    if (num <= 100 && num > 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + num);
                        Thread.sleep(2000);
                        num--;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("获取锁失败");
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }


        }
    }
}

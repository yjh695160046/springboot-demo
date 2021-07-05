package com.yijian.javabase.thread;

/**
 * @author: yaojinhua
 * @date: 2021/6/28 15:24
 * @description:   礼让线程
 */
public class YieldTest {
    public static void main(String[] args) {
        try {

            Thread.currentThread().interrupt();
        } catch (Exception e){
            System.out.println("出异常了" + e);
            return;
        }
        Thread a = new Thread(YieldTest::testRun, "A");
        a.start();
        try {
            a.interrupt();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()  + ":" + i );
        }

    }


    public static void testRun(){
        Thread.yield();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()  + ":" + i );
        }


    }

}

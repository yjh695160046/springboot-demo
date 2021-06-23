package com.yijian.javabase.main.threadlocal;

/**
 * @author: yaojinhua
 * @date: 2021/6/15 14:59
 * @description: 通过ThreadLocal 提供线程内部的局部变量 做到线程间隔离
 */
public class MyThreadLocalDemo {
    /**
     *  总结：
     *    多线程并发的场景下
     *    提供线程内部的局部变量  不同线程直接不会互相干扰 这种变量在线程的生命周期中起作用
     *
     * synchronized： 原理 -> 同步机制采用’以时间换空间’的方式, 只提供了一份变量,让不同的线程排队访问
     *
     *
     */
    private static final ThreadLocal<String> THREAD_LOCAL_STRING = new ThreadLocal<>();
    private String content;

    private String getContent() {
        return THREAD_LOCAL_STRING.get();
    }

    private void setContent(String content) {
        THREAD_LOCAL_STRING.set(content);
    }

    private void remove(){
        THREAD_LOCAL_STRING.remove();
    }


    public static void main(String[] args) {

        MyThreadLocalDemo demo = new MyThreadLocalDemo();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                demo.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("-----------------------");
                System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
            });
            thread.setName("线程" + i);
            thread.start();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println((int)(Math.random()*8998)+1000+1);

        }


    }
}

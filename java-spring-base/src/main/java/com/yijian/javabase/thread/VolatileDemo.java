package com.yijian.javabase.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yaojinhua 无所畏惧
 * @date: 2021/6/30 15:38
 * @description: volatile:
 */
class MyData {

    public volatile int visibilityNumber;
    public volatile int atomicityNumber;
    AtomicInteger number2 = new AtomicInteger();
    Lock lock = new ReentrantLock();

    public void add() {
        this.visibilityNumber = 60;
    }

    public void addPlus() {
        // this.atomicityNumber++; 会分成三个指令
        lock.lock();
        try {
            this.atomicityNumber++;
        } finally {
            lock.unlock();
        }
    }

    public void addAtomicInteger() {
        number2.getAndIncrement();
    }
}

/**
 * 指令重排案例
 */
class ReSortSeqDemo {
    int a = 0;
    boolean flag = false;

    public void method01(){
        a = 1;//语句1
        flag = true;//语句2
    }

    public void method02(){
        if(flag){
            a = a + 5; //语句3
        }
        System.out.println("retValue: " + a);//可能是6或1或5或0
    }
   // 交替执行method01() 和method01() 时 指令重排优化
}
public class VolatileDemo {

    /**
     * 轻量级的同步机制
     * 1.保证可见性 (当多个线程访问同一个共享变量时，一个线程修改这个变量的值 ，其他线程立即能够看到这个修改后的值)
     * 2.不保证原子性 (原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行 同时失败)
     * 3.禁止指令重排优化（保证有序性） -- 指程序的执行顺序按照代码的顺序执行
     *      重排：为了提高性能 编辑器和处理器会对指令进行重排  重排的目的是为了提高性能
     *       单线程下处理器在进行指令重排时要考虑数据的依赖性 执行结果不能被改变
     * <p>
     * JMM JAVA内存模型 描述的是一种规范 本身是一种抽象的概念并不存在
     *   JMM关于同步的规定：
     *      线程解锁前，必须把共享变量的值刷新回主内存
     *      线程加锁前，必须读取主内存的最新值到自己的工作内存
     *      加锁解锁是同一把锁
     * 主内存
     * 工作内存(栈空间)
     * <p>
     * 栈空间线程私有 每个线程私有的
     */


    public static void main(String[] args) {
        MyData myData = new MyData();
//        visibility(myData);


        notAtomicity(myData);

    }

    /**
     * 不保证原子性
     * @param myData
     */
    private static void notAtomicity(MyData myData) {
        // 创建20个线程
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        myData.addPlus();
                        myData.addAtomicInteger();
                    }
                }
            }, String.valueOf(i)).start();
        }
        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
//        while (Thread.activeCount() > 2) {
//            // yield表示不执行
//            Thread.yield();
//            System.out.println("这次还是我" + Thread.activeCount());
//        }
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 查看最终的值
        // 假设volatile保证原子性，那么输出的值应该为：  20 * 1000 = 20000
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.atomicityNumber);
        System.out.println(Thread.currentThread().getName() + "\t finally AtomicInteger value: " + myData.number2);
    }

    /**
     * 可见性
     */
    private static void visibility(MyData myData) {
        // 可见性

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.add();
        }, "线程A").start();

        while (myData.visibilityNumber == 0) {
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over" + myData.visibilityNumber);
    }


}

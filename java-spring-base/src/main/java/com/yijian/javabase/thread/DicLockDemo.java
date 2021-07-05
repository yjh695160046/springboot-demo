package com.yijian.javabase.thread;

/**
 * @author: yaojinhua
 * @date: 2021/6/29 16:39
 * @description: 死锁问题 两个或两个以上的线程在争夺资源过程中 发生的一种相互等待的过程
 */
public class DicLockDemo {

    public static void main(String[] args) {

        new Thread(new DicLock(true)).start();
        new Thread(new DicLock(false)).start();

    }
}

class DicLock implements Runnable {

    private boolean flag;

    public DicLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (LockObject.OBJA) {
                System.out.println("if OBJA");
                synchronized (LockObject.OBJB) {
                    System.out.println("if OBJB");
                }
            }
        } else {
            synchronized (LockObject.OBJB) {
                System.out.println("else OBJB");
                synchronized (LockObject.OBJA) {
                    System.out.println("if OBJA");
                }
            }
        }
    }
}

/**
 * 创建两把锁
 */
class LockObject {

    public final static Object OBJA = new Object();
    public final static Object OBJB = new Object();

}

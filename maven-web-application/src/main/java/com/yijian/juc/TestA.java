package com.yijian.juc;

/**
 * @author: yxyaojinhua
 * @date: 2022/5/13 16:32
 * @description:
 */
public class TestA {
    public volatile static int state = 10;

    public static void main(String[] args) {
      new Thread(()->{
          test();
      }, "t1").start();

        new Thread(()->{
            test();
        },"t2'").start();
    }

    public static boolean test(){
        for (;;) {
            System.out.println(Thread.currentThread().getName() + "循环");
            int c = getState();
            if (c == 0)
                return false;
            int nextc = c-1;
            if (compareAndSetState(c, nextc))
                return nextc == 0;
        }
    }

    private static boolean compareAndSetState(int c, int nextc) {
        return false;
    }

    private static int getState() {
        return state;
    }
}

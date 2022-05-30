package com.yijian.javabase.thread;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/14 20:11
 * @description:
 */
public class VolatileNoAtomicityDemo {

    public static void main(String[] args) {
        NumPlus numPlus = new NumPlus();
        /**
         * 创建了10个线程，每个线程执行2000次num++操作
         * 字节码底层 i++抽象为3个动作
         * 即先取值、再自增、然后赋值
         */
        for (int i = 0; i <= 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        numPlus.numPlusPlus();
                    }
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        // 查看最终的值
        // 假设volatile保证原子性，那么输出的值应该为：  20 * 1000 = 20000
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + numPlus.num);
    }

}

class NumPlus {

    public  int num;

    public void numPlusPlus() {
        num++;
    }

}

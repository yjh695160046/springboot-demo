package com.yijian.juc;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: yxyaojinhua
 * @date: 2022/5/7 16:08
 * @description:
 */
public class Test {
    public static void main(String[] args) {

        A obj = new A();
        System.out.println("上:" + ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj){
            System.out.println("中:" + ClassLayout.parseInstance(obj).toPrintable());
        }

        System.out.println("下:" + ClassLayout.parseInstance(obj).toPrintable());

    }
}

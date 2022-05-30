package com.yijian.javabase.main.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yxyaojinhua
 * @date: 2021/9/16 15:47
 * @description:
 */
public class ArrayListTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.add("t1-" + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.add("t2-" + i);
                }
            }
        });
        t1.start();
        t2.start();

        Thread.sleep(2000);
        int size = list.size();
        System.out.println("size = " + size);
        for (int i = 0; i < size; i++) {
            System.out.println("索引为" + i + "的元素为：" + list.get(i));
        }

    }


}

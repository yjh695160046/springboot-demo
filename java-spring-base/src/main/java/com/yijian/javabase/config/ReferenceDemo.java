package com.yijian.javabase.config;

import java.lang.ref.SoftReference;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/6 10:02
 * @Description: java 强 软 弱 虚 引用
 */
public class ReferenceDemo {
    /**
     * 强引用：
     *    Object strongReference  = new Object() 这种就是强引用
     *    如果对象具有强引用 垃圾回收器从不回收 当内存不足时 Java虚拟机宁愿抛出内存泄漏 都不进行回收 使程序异常终止
     *    当强引用对象不使用时 显示的将值置为空
     *    强引用在方法内部时 随着方法的调用结束 就会退出方法栈，则引用对象的引用数为0，这个对象会被回收
     *    强引用为全局变量时 这需要在不用这个对象时赋值为null 因为垃圾回收器不会回收
     *
     * 虚引用:
     *   不会决定对象的生命周期 在任何时候都会被垃圾回收器回收   主要是用来跟踪垃圾回收器的活动
     *   虚引用必须和引用队列来一起使用
     *
     */
    public static void main(String[] args) {

        // 强引用 平常开发中大部分都是强引用
        //String str  = new String("abc");

        // 强引用
        String strongReference = new String("abc");
        // 软引用
        String str = new String("abc");
        SoftReference<String> softReference = new SoftReference<>(str);
        System.out.println(softReference.get());


    }


}

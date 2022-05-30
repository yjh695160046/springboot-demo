package com.yijian.javabase.base;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/12 19:35
 * @description:
 */
public class Test1 {
    public static void main(String[] args) {

        Integer a =10;
        doSomething(1);


    }

   public static void doSomething(double a){
       System.out.println("double.....");
   }

    public static void doSomething(Integer a){
        System.out.println("Integer.....");
    }

}

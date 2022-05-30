package com.yijian.javabase.base;


import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/15 17:17
 * @description:
 */
public class Test {
    public static void main(String[] args) throws Exception {

//        Unsafe unsafe = Unsafe.getUnsafe();
//        Object o = unsafe.allocateInstance(User.class);
//        unsafe();
//        int age = 25;
//        float weight = 77.5f;
//        valueCrossTest(age, weight);
//        System.out.println("方法执行后的age：" + age);
//        System.out.println("方法执行后的weight：" + weight);

        User user = new User();
        user.name = "张三";
        userCrossTest(user);
        System.out.println("方法执行后的name：" + user.name);

//        User user = new User();
//        User user1 = new User();
//        User user2 = new User();
//        System.out.println("user hashcode:"+ user.hashCode());
//        System.out.println("user1 hashcode:"+ user1.hashCode());
//        System.out.println("user2 hashcode:"+ user2.hashCode());
//        user.name = "张三";
//        String string = "string";
//        String string1 = "string";
//        String string2 = "string";
//        System.out.println("string hashcode:"+ string.hashCode());
//        System.out.println("string1 hashcode:"+ string1.hashCode());
//        System.out.println("string2 hashcode:"+ string2.hashCode());
//        String string = new String("string");
//        Integer integer = new Integer(1);
//        Double aDouble = 1.1;
//        referenceTypeCrossTest(string, integer, aDouble);
//        System.out.println("方法执行后的String：" + string);
//        System.out.println("方法执行后的Integer：" + integer);
//        System.out.println("方法执行后的Double：" + aDouble);
    }

    private static void referenceTypeCrossTest(String string, Integer integer, Double aDouble) {
        System.out.println("传入的String：" + string);
        System.out.println("传入的Integer：" + integer);
        System.out.println("传入的Double：" + aDouble);
        string = "changedString";
        integer = 2;
        aDouble = 2.1;
        System.out.println("方法内重新赋值后的String：" + string);
        System.out.println("方法内重新赋值后的Integer：" + integer);
        System.out.println("方法内重新赋值后的Double：" + aDouble);
    }

    private static void userCrossTest(User user) {
        System.out.println("传入的name：" + user.name);
        user = new User();
        user.name = "李四";
        System.out.println("方法内重新赋值后的name：" + user.name);
    }

    private static void valueCrossTest(int age, float weight) {
        System.out.println("传入的age：" + age);
        System.out.println("传入的weight：" + weight);
        age = 33;
        weight = 89.5f;
        System.out.println("方法内重新赋值后的age：" + age);
        System.out.println("方法内重新赋值后的weight：" + weight);
    }

    private static void valueCrossTest(Integer a) {
        a = 4;
        System.out.println("test:" + a);
    }


    /**
     * Unsafe类创建对象
     *
     * @throws Exception
     */
    private static void unsafe() throws Exception {
        Class<Unsafe> unsafeClass = Unsafe.class;
        Constructor<Unsafe> constructor = unsafeClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Unsafe unsafe = constructor.newInstance();
        User o = (User) unsafe.allocateInstance(User.class);
        System.out.println(o.name);
        System.out.println("--------------------");

        Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe2 = (Unsafe) theUnsafe.get(null);
        User o2 = (User) unsafe2.allocateInstance(User.class);
        System.out.println(o2.name);
    }

}

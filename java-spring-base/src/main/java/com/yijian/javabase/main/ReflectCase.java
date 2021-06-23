package com.yijian.javabase.main;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: yaojinhua
 * @date: 2021/5/26 16:26
 * @description: 反射案例
 */
public class ReflectCase {

    public static void main(String[] args) throws Exception {
        reflectCreateObjectAndGetMethodorFields();
    }


    /**
     * 通过反射创建对象 并获取方法 字段
     *
     * @throws Exception
     */
    private static void reflectCreateObjectAndGetMethodorFields() throws Exception {
        //通过class类调用其他类的构造函数
        Class<?> case1 = null;
        case1 = Class.forName("com.yijian.javabase.main.Student");
        Student student1 = null;
        Student student2 = null;
        Student student3 = null;
        // 直接newInstance() 获取无参 类中没有无参则报错
        student3 = (Student) case1.newInstance();

        System.out.println(student3);
        // getConstructor() 获取本类中公有无参构造方法
        Constructor<?> constructorNotParam = case1.getConstructor();
        // getConstructor() 获取本类中无参构造方法
        Constructor<?>[] declaredConstructors = case1.getDeclaredConstructors();
        // getConstructor() 获取有参构造方法 tip: 已知参数个数
        Constructor<?> constructorWithParam = case1.getConstructor(Integer.class, Integer.class, String.class);
        // getConstructors() 获取本类所有的共有构造方法 tip: 顺序不知
        Constructor<?>[] constructorArray = case1.getConstructors();
        // getDeclaredConstructors() 获取本类中所有的构造方法 tip: 顺序不知
        // 循环获取构造方法 创建对象 通过getParameterTypes()获取参数个数 测试时练习 生产不可取
        for (Constructor<?> constructor : constructorArray) {
            System.out.println(constructor);
            // 无参
            if (constructor.getParameterTypes().length == 0) {
                student1 = (Student) constructor.newInstance();
                System.out.println(student1);
            } else {
                // 参数类型要完全一致 不然创建对象时提示错误 argument type mismatch类型不匹配
                student2 = (Student) constructor.newInstance(1, 1, "222");
                // 打破修饰符作用域 可以访问私有成员方法 成员变量等
                System.out.println(student2);
                // 有参构造方法 参数必须要传
                //student2 = (Student) constructor.newInstance();
                //System.out.println(student2);
                student2 = (Student) constructor.newInstance(1, 1, "2223");
                System.out.println(student2);
            }

        }


        // 获取本类的指定的成员方法 第一个参数 方法名称 第二个参数 方法名称参数的类型，多个就加逗号写多个类型
        Method declaredMethod = case1.getDeclaredMethod("privateMethod", String.class);
        // setAccessible = ture 访问修饰符失效 可以随意访问对象中的所有方法及属性
        declaredMethod.setAccessible(true);
        // ivvoke 执行方法 第一个参数 调用方法的对象 第二个参数 方法的实参 多个就加逗号写多个
        declaredMethod.invoke(student2, "调用私有方法");
        // 获取本类中指定的公共成员方法
        Method publicMethod = case1.getMethod("publicMethod", String.class);
        publicMethod.invoke(student2, "调用公有方法");

        // 获取本类及超类的所有公共方法
        Method[] methods = case1.getMethods();
        for (Method method : methods) {
            // 通过名称来匹配方法 判断参数个数 已知方法的名称
            String NAME = method.getName();
            if ("publicMethod".equals(NAME)) {

            }
            System.out.println("common -->" + NAME);
        }
        // 获取本类中的所有方法(不包括继承方法)
        Method[] declaredMethods = case1.getDeclaredMethods();
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            // 通过名称来匹配方法 判断参数个数 已知方法的名称
            String NAME = method.getName();
            if ("privateMethod".equals(NAME)) {

            }
            System.out.println("declaredMethods --> " + NAME);
        }


        // getFields() 获取本类中所有公共字段(不包括继承)
        for (Field field : case1.getFields()) {
            System.out.println("fields --> " + field);
        }

        // getDeclaredFields() 获取本类中所有字段（不包括继承）
        for (Field field : case1.getDeclaredFields()) {
            System.out.println("declaredFields -->" + field);
        }
    }

}

//@Data
class Student extends Person {

    private Integer age;

    public Integer sex;

    public String NAME;


    public Student() {

    }

    private Student(Integer age, Integer sex, String NAME) {
        this.age = age;
        this.sex = sex;
        this.NAME = NAME;
    }

    private Object privateMethod(String message) {
        System.out.println(NAME + "的 privateMethod message" + message);
        return message;
    }

    public Object publicMethod(String message) {
        System.out.println(NAME + "的 publicMethod message" + message);
        return message;
    }

    void defaultMethod(String message) {
        System.out.println(NAME + "的 defaultMethod message" + message);
    }

    protected void protectedMethod(String message) {
        System.out.println(NAME + "的 protectedMethod message" + message);
    }

}

//@Data
class Person implements School{

    private int height;

    private Double weight;

    public Person() {
    }

    public Person(int height, Double weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String course() {
        return "我是抽象方法";
    }
}


interface School {
    /**
     * 常量：接口中的成员变量只能是常量，总是：public static final 修饰。不写也是。
     */
    String NAME = "实验高中";

    /**
     * 方法：
     * 抽象方法：没有方法体 被abstract关键字修饰 默认可以不写 被子类实现  必须被public修饰 不能被保护
     * 静态方法：被接口直接调用 实现类不能重写 也不能调用 静态是基于.class文件的 被static修饰 默认public JDK1.8
     * 默认方法: default 修饰 实现类重写或者直接调用 默认public JDK1.8
     * 私有方法: JDK1.9
     *
     * @return 课程
     */
    public abstract String course();


    public default void interfaceDefaultMethod() {
        System.out.println("interfaceDefaultMethod : " + "接口默认方法");
    }

    public static void interfaceStaticMethod(){
        System.out.println("interfaceStaticMethod : " + "接口静态方法");
    }

    //private void interfacePrivateMethod(){
    //    System.out.println("interfaceStaticMethod : " + "接口静态方法");
    //}
}
package com.yijian.javabase.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author: yaojinhua
 * @date: 2021/5/6 10:43
 * @description:
 */
@Configuration
public class SpringConfig {

    // spring 的循环依赖（多个类嵌套依赖） N个bean互相引用对方 最终形成闭环  N也可以等于1 极限情况 自己依赖自己
    /**
     * 注意点1
     *    循环引用不是方法间的循环引用 而是对象的相互依赖关系。（方法之间循环调用若有出口也是能够正常work的）
     *
     *
     */
    public static void main(String[] args) {
        System.out.println(new A());

    }



}

class A {
    // 无参构造
    public A() {
        new B();
    }
}

class B {
    // 无参构造
    public B() {
        new A();
    }
}

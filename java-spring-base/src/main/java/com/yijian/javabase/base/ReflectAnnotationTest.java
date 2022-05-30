package com.yijian.javabase.base;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/15 15:01
 * @description:
 */
public class ReflectAnnotationTest {

    public static void main(String[] args) {
        Class<Child> childClass = Child.class;
        Annotation[] annotations = childClass.getAnnotations();
        Annotation[] declaredAnnotations = childClass.getDeclaredAnnotations();
        System.out.println(annotations.length);
        System.out.println(declaredAnnotations.length);
        System.out.println(childClass.isAnnotation());
    }
    @Anno1
    static class Child extends Parent {
    }

    @Anno2
    static class Parent {

    }
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    @interface Anno1{

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Anno2{

    }
}

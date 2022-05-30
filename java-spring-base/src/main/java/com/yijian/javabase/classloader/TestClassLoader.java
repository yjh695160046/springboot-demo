package com.yijian.javabase.classloader;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/14 15:40
 * @description: classloader测试
 */
public class TestClassLoader {
    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;
        System.out.println(bookClass.getClassLoader());
        System.out.println(bookClass.getClassLoader().getParent());
        System.out.println(bookClass.getClassLoader().getParent().getParent());

        // Class<String> stringClass = String.class;
        //
        // System.out.println(stringClass.getClassLoader());
        // System.out.println(stringClass.getClassLoader().getParent());
        // System.out.println(stringClass.getClassLoader().getParent().getParent());

    }


}

class Book {


}

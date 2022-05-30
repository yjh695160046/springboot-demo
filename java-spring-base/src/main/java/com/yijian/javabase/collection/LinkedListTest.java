package com.yijian.javabase.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/23 17:20
 * @description:
 */
public class LinkedListTest {
    public static void main(String[] args) throws Exception{

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("world");
        linkedList.add("world");
        linkedList.add("world");
        linkedList.add("world");
        linkedList.add(1, "1");
        linkedList.remove("world");
        linkedList.set(1, "update index 1");


        LinkedList<String> clone = (LinkedList<String>) linkedList.clone();
        clone.remove();
        System.out.println(linkedList);
        System.out.println(clone);


        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("linkedList"));
        outputStream.writeObject(linkedList);
        outputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("linkedList"));
        Object o = objectInputStream.readObject();
        System.out.println(o);
        objectInputStream.close();
//        System.out.println(linkedList.get(3));

//        System.out.println(s);
//        System.out.println(linkedList.size());

    }
}

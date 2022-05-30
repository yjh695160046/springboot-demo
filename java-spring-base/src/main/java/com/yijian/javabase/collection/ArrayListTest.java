package com.yijian.javabase.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/21 16:28
 * @description: ArrayList分析
 */
public class ArrayListTest {
    public static void main(String[] args) throws Exception {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hello");
        stringList.add("world");
        stringList.add(null);
        stringList.add(null);
        stringList.add("world");
        stringList.add(":");
//        stringList.remove("world");
        System.out.println(stringList);
        stringList.trimToSize();
        System.out.println(stringList.size());
        stringList.forEach(System.out::println);
//        serialize(stringList);
//        reverseSerialize("serializeList", List.class);

        int modCount = 1;
        System.out.println(modCount++);
        System.out.println(modCount);
        int[] elementData = {1, 2, 3, 4, 5};
        int[] newElementData = Arrays.copyOf(elementData, 10);
        System.out.println(newElementData.length); // [1 2 3 4 5 0 0 0 0 0]
    }

    /**
     * 序列化
     */
    public static void serialize(List<String> sourceList) throws Exception {
        ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream("serializeList"));
        objectInputStream.writeObject(sourceList);
        objectInputStream.close();
    }

    /**
     * 反序列化
     */
    public static Object reverseSerialize(String outPutFile, Class<?> parameterTypes) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(outPutFile));
        String name = parameterTypes.getName();
        Object o1 = parameterTypes.getConstructor().newInstance();
        o1 = objectInputStream.readObject();
        return o1;
    }

}

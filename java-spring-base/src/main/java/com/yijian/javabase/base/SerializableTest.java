package com.yijian.javabase.base;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author: yxyaojinhua
 * @date: 2022/2/14 14:18
 * @description: 序列化测试
 */
public class SerializableTest {
    public static void main(String[] args) throws Exception {

//        Pserson pserson = new Pserson(11);
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user"));
//        outputStream.writeObject(pserson);
//        outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user"));
        Pserson inputPserson = (Pserson) inputStream.readObject();
        System.out.println(inputPserson.getAge());

    }



}
class Pserson implements Serializable {

//    private static final long serialVersionUID = -6642928530718910634L;

    public Pserson(int age) {
        this.age = age;
    }
    public int age;

    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

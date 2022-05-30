package com.yijian.javabase.base;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author: yxyaojinhua
 * @date: 2022/2/14 15:08
 * @description: 对象克隆
 */
public class CloneableTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(11, "test", new Detail("壁纸"));
        Person person1 = person;
        Person clone = (Person) person.clone();
        System.out.println(person == person1);
        System.out.println(person == clone);
        System.out.println("person ==> " + person + ", clone ==> " + clone.getClass() +
                "。equals：" + person.equals(clone));
        System.out.println("person.getClass() ==> " + person.getClass() + ", clone.getClass() ==> " + clone.getClass() +
                "。equals：" + person.getClass().equals(clone.getClass()));
        System.out.println("person.toString() ==> " + person.toString() + ", clone.toString() ==> " + clone.toString());
        person.setAge(22);
        System.out.println(person.getAge().equals(clone.age));

        System.out.println("hashcode:" + person.hashCode());
        System.out.println("hashcode:" + clone.hashCode());


    }
}
@Data
@AllArgsConstructor
class Person implements Cloneable {

    public Integer age;

    public String name;

    public Detail detail;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}

class Detail {

    public Detail(String name) {
        this.name = name;
    }

    public String name;

}
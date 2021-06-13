package com.yijian.javabase.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yaojinhua
 * @date: 2021/5/26 15:44
 * @description:
 */
@Data
public class StudentEntity {

    private Integer age;

    public Integer sex;

    public String name;


    public StudentEntity() {

    }

    public StudentEntity(Integer age, Integer sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    private Object privateMethod(String message){
        System.out.println(name + "的 privateMethod message"+ message);
        return message;
    }

    public Object publicMethod(String message){
        System.out.println(name + "的 publicMethod message"+ message);
        return message;
    }

    void defaultMethod(String message){
        System.out.println(name + "的 defaultMethod message"+ message);
    }

    protected void protectedMethod(String message){
        System.out.println(name + "的 protectedMethod message"+ message);
    }

}

package com.yijian.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * @author: yxyaojinhua
 * @date: 2021/8/17 20:12
 * @description:
 */
@Getter
@Setter
public class User implements Serializable {

   private static final long serialVersionUID = 8246061277544184533L;

   private Long id;

   private String userName;

   private Integer age;
}

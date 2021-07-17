package com.yijian.javabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/15 17:36
 * @description: thymeleaf 整合
 */
@Controller
public class IndexController {

   @RequestMapping("/")
   public String index(){
       return "index";
   }
}

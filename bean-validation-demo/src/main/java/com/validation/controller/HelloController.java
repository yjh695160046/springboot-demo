package com.validation.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONObjectIter;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;
import java.util.List;

/**
 * @author yaojinhua
 */
@Validated({HelloController.Insert.class, Default.class})
@RestController
@RequestMapping("/hello")
public class HelloController {
    /**
     * @valid(javax.validation): 是Bean Validation的标准注解，表示对需要校验的【字段、方法、入参】进行校验标记
     *
     * @Validated (org.springframework.validation.annotation)：是Spring对@Valid扩展后的变体，支持分组校验。
     *
     *
     * post：两种格式请求的数据包格式不同，数据包中的非ASCII字符的编码
     *      application/x-www-form-urlencoded默认的请求格式
     *      multipart/form-data
     *
     *
     */
    @PostMapping("/test1")
    public Object test1(@RequestBody @Valid Person person) {
//        bindingResult.getFieldErrors().forEach(error -> {
//            System.out.println(error.getField() + "-" + error.getDefaultMessage());
//        });
        return person;
    }

    @PostMapping(value = "/test2")
    public Object test2(@Valid Person person) {
//        bindingResult.getFieldErrors().forEach(error -> {
//            System.out.println(error.getField() + "-" + error.getDefaultMessage());
//        });
        return person;
    }

    @PostMapping("test5")
    public ResponseEntity<?> test5(@Valid @RequestBody List<Person> personList) {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("test6")
    public ResponseEntity<?> test6(@Validated @RequestBody List<Person> personList) {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("test7")
    public ResponseEntity<?> test7() {
        return ResponseEntity.ok("ok");
    }




    @Data
    static class Person {
        //名称不能为空
        @NotBlank(groups = Insert.class)
        private String name;
        // 电话号码满足1开头，11位长的数字
        @Pattern(regexp = "1[0-9]{10}")
        private String number;
        //至少有一个地址
        @NotEmpty
        private List<String> address;
    }

    public @interface Insert {

    }

}

package com.yijian.springcommon.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yxyaojinhua
 * @date: 2021/10/11 10:10
 * @description: @InitBinder mvc初始化数据绑定
 *
 *   1).注册属性编辑器
 *     springmvc 参数绑定时能帮我们直接处理基础的数据类型 对于复杂的对象类型时 就无法处理
 *     属性编辑器 自定义属性编辑器则能都帮我们进行处理 源数据为string），过程一般就是String->属性编辑器->目标类型
 *   2).spring 提供了一些默认的属性编辑器 比如org.springframework.beans.propertyeditors.CustomDateEditor
 *     我们也可以自己继承PropertyEditorSuppotr 来根据具体业务来定义自己的属性编辑器
 *   3). 定义controller并使用@InitBinder注册属性编辑器
 */

@RestController()
@RequestMapping("/myInitBinder")
public class MyInitBinderController {

    /**
     * 针对当前controller 一次请求会将信息放入缓存中RequestMappingHandlerAdapter ==> initBinderCache中 下一次就不会去解析@InitBinder了
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        dataBinder.registerCustomEditor(Date.class, dateEditor);
    }

    /**  方法被执行之前先调用 initBinder进行参数的绑定 */
    @GetMapping("/testFormatData")
    public Object testFormatData(Date date){
        Map<String, Object> map = new HashMap<>(16);
        map.put("date", date);
        return map;


    }




}

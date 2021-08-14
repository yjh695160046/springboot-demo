package com.yijian.javabase.controller;

import cn.hutool.core.date.DateUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {


    @Resource
    @Qualifier("testRoundRobin")
    private TestRoundRobin roundRobin;

    @Resource
    @Qualifier("testRoundRobinWeight")
    private TestRoundRobinWeight roundRobinWeight;

    @SneakyThrows
    @RequestMapping("/jrebel")
    public Object test(@RequestBody String date) {
        System.out.println("jrebel dd dddd");
        Map<String, Object> map = new HashMap<>();
        map.put("code" , 200);
        map.put("data" , roundRobinWeight.pollingWeight());
        map.put("msg" , "操作成功");
//        Thread.sleep(60000);
        System.out.println(date);
        System.out.println(DateUtil.now());
        return map;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping("/random")
    public Object random(@RequestParam String filenamepath, @RequestParam String fileName, @RequestParam String uploadToken,
                         HttpServletResponse response){
//        return TestRandom.random();
//       return roundRobin.polling();
        System.out.println(filenamepath);
        System.out.println(fileName);
        System.out.println(uploadToken);
        System.out.println(response);

        return roundRobinWeight.pollingWeight();
    }

    public static void main(String[] args) {
        String password = "1111111a11111";
        String t2 = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$";

        System.out.println(password.matches(t2));

    }


}

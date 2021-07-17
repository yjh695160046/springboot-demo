package com.yijian.javabase.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/test")
public class TestController {


    @Resource
    @Qualifier("testRoundRobin")
    private TestRoundRobin roundRobin;

    @Resource
    @Qualifier("testRoundRobinWeight")
    private TestRoundRobinWeight roundRobinWeight;

    @RequestMapping("/jrebel")
    public Object test() {
        System.out.println("jrebel dd dddd");
        return "jrebelDd";
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



}

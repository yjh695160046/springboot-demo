package com.yijian.springcommon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/28 16:13
 * @description:
 */
@RestController
//@Scope("prototype")
public class TestController {

    private int num = 1;

    private ThreadLocal<Integer> threadLocalNum = ThreadLocal.withInitial(() -> num);

    private AtomicInteger atomicInteger = new AtomicInteger(1);

    @RequestMapping("/addNum")
    public Object addNum(HttpServletRequest request) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()).getBean(TestController.class));
        Integer integer = threadLocalNum.get();
        threadLocalNum.set(++integer);

        return threadLocalNum.get();
    }
    @RequestMapping("/addNum1")
    public Object addNum1(HttpServletRequest request) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()).getBean(TestController.class));
        atomicInteger.compareAndSet(num,2);
        return atomicInteger.get();
    }
    
    // @Resource
    // // @Qualifier("orderServiceImpl1")
    // private OrderService orderServiceImpl1;
    //
    // @RequestMapping("/injection")
    // public void injection(){
    //     System.out.println(orderServiceImpl1);
    // }


}

package com.yijian.springcommon.controller;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/6 11:09
 * @description:
 */
public class MainTest {

    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
        String mobile = "18167118620";
        Integer expire = 1000;
        String mobileExpire = "18167118620,15336580478,15210875839,18317104734,18767105241:300";
        if (StringUtils.isNotBlank(mobileExpire) && mobileExpire.contains(mobile)) {
            expire = Integer.valueOf(mobileExpire.split(":")[1]);
        }

        System.out.println(expire);
    }

}

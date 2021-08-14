package com.yijian.springcommon.controller;

import com.yijian.springcommon.Enum.EnumBaseResponse;
import com.yijian.springcommon.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/23 15:17
 * @description:
 */
@Api(tags = "ddd")
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @PostMapping("/success/logback")
    @ApiOperation("成功日志")
    public BaseResponse successLogback() {
        String a;
        log.error("error hello logback");
        log.info("info hello logback");
        log.warn("warn hello logback");
        return BaseResponse.success().data("logback", "success hello logback");
    }

    @ApiOperation("失败日志")
    @PostMapping("/error/logback")
    public BaseResponse errorLogback(Date date1, String[] strToListArr) throws Exception {
        log.error("error hello logback");
        log.info("info hello logback");
        log.warn("warn hello logback");
        log.warn("date: {}", date1);
        log.warn("date: {}", Arrays.asList(strToListArr).toString());
        try {
            int i =1/0;

        }catch (Exception e){
            log.warn("mobile：{}, account：{}, createBizOpenUser error：{}", "11", "22", e);

        }
        return BaseResponse.fail(EnumBaseResponse.DELETE_ERROR).data("logback", "error hello logback");
    }
}

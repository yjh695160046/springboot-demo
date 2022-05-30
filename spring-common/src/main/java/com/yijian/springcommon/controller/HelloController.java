package com.yijian.springcommon.controller;

import com.yijian.springcommon.enums.EnumBaseResponse;
import com.yijian.springcommon.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

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
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder binder
     */
    @InitBinder
    private void initBinder(ServletRequestDataBinder binder) {

        binder.registerCustomEditor(String[].class, new PropertyEditorSupport() {
            @Override
            public void setAsText(@NonNull String text) throws IllegalArgumentException {
                if (text == null) {
                    throw new NullPointerException("text is not null");
                }
                String[] resultArr = null;
                if (!StringUtils.isEmpty(text)) {
                    resultArr = text.split(",");
                }
                setValue(resultArr);
            }
        });
        // 参数中属性值是 yyyy-MM-dd HH:mm:ss 转换成Date类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));

        log.info("ServletRequestDataBinder: " + binder);
    }

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

    @GetMapping("/error")
    public BaseResponse errorLogback(){
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> iterator = arrayList.iterator();
        System.out.println("值"+iterator.next());
        if (iterator.hasNext()) {
            System.out.println("值"+iterator.next());
        }
        float f1 = 1f;
        double b1 = 1281111111;
        int i1= 1;
        boolean boo1= true;
        char c1 ='a';
        System.out.println(c1);
        long l1 = 1;
        short s1 =32767;
        byte by1 =1;

        return BaseResponse.fail();
    }

}

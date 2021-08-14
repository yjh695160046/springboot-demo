package com.yijian.springcommon.config;

import com.yijian.springcommon.Enum.EnumBaseResponse;
import com.yijian.springcommon.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/23 17:10
 * @description: 全局异常捕获
 */
@RestControllerAdvice
@Slf4j
public class GlobaExceptionAdvice {

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


    @ExceptionHandler(Exception.class)
    private BaseResponse globalExceptionHandler(Exception e) {
        log.error("globalExceptionHandler: ", e);
        return BaseResponse.fail();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private BaseResponse notFoundExceptionHandler(Exception e) {
        log.error("notFoundExceptionHandler: ", e);
        return BaseResponse.fail(EnumBaseResponse.NOT_FOUND);
    }

}

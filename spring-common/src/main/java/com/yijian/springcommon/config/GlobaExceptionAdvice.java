package com.yijian.springcommon.config;

import com.yijian.springcommon.enums.EnumBaseResponse;
import com.yijian.springcommon.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/23 17:10
 * @description: 全局异常捕获
 */
@RestControllerAdvice
@Slf4j
public class GlobaExceptionAdvice {

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

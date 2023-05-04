package com.validation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaojinhua
 * 通用异常拦截处理类（通过切面的方式默认拦截所有的controller异常）
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    /**
     * 对方法参数校验异常处理方法
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerNotValidException(MethodArgumentNotValidException exception) {
        log.debug("begin resolve argument exception");
        BindingResult result = exception.getBindingResult();
        Map<String, Object> maps = null;

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            maps = new HashMap<>(fieldErrors.size());
            for (FieldError error : fieldErrors) {
                maps.put(error.getField(), error.getDefaultMessage());
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(maps);

    }
}

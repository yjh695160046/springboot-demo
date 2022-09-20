package com.yijian.order.pojo.common;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private String code;

    private String message;

    private T data;

    public static <T> BaseResponse<T> success(T data){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode("200");
        baseResponse.setMessage("success");
        baseResponse.setData(data);
        return baseResponse;
    }

    public static <T> BaseResponse<T> fail(T data){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode("500");
        baseResponse.setMessage("fail");
        baseResponse.setData(data);
        return baseResponse;
    }
}


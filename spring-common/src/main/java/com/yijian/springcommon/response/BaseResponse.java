package com.yijian.springcommon.response;

import com.yijian.springcommon.enums.EnumBaseResponse;
import lombok.Data;

import java.util.Map;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/23 15:59
 * @description: 统一返回处理Response
 */
@Data
public class BaseResponse {
    /**
     * 接口返回码
     */
    private Integer code;

    /**
     * 接口请求是否成功 ture/false
     */
    private boolean success;

    /**
     * 接口返回信息
     */
    private String message;

    /**
     * 接口返回数据
     */
    private Map<String, Object> data;

    /**
     * 私有无参构造
     */
    private BaseResponse() {
    }

    /**
     * 不带数据
     *
     * @return BaseResponse
     */
    public static BaseResponse success() {
        BaseResponse response = new BaseResponse();
        response.setCode(EnumBaseResponse.SUCCESS.getCode());
        response.setMessage(EnumBaseResponse.SUCCESS.getMessage());
        response.setSuccess(EnumBaseResponse.SUCCESS.getSuccess());
        return response;
    }

    public static BaseResponse fail() {
        BaseResponse response = new BaseResponse();
        response.setCode(EnumBaseResponse.ERROR.getCode());
        response.setMessage(EnumBaseResponse.ERROR.getMessage());
        response.setSuccess(EnumBaseResponse.ERROR.getSuccess());
        return response;
    }

    public static BaseResponse fail(IBaseResponse baseResponse) {
        BaseResponse response = new BaseResponse();
        response.setCode(baseResponse.getCode());
        response.setMessage(baseResponse.getMessage());
        response.setSuccess(baseResponse.getSuccess());
        return response;
    }

    public BaseResponse data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public BaseResponse data(Map<String, Object> responseDataMap) {
        this.setData(responseDataMap);
        return this;
    }
}

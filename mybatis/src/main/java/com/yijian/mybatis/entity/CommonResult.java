package com.yijian.mybatis.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/4 16:44
 * @description:
 */
@Data
public class CommonResult {

    /**
     * 接口返回码
     */
    private Integer code;

    /**
     * 接口返回信息
     */
    private String message;

    /**
     * 接口返回数据
     */
    private Map<String, Object> data;
    /**
     * 不带数据
     *
     * @return BaseResponse
     */
    public static CommonResult success() {
        CommonResult response = new CommonResult();
        response.setCode(200);
        response.setMessage("成功");
        return response;
    }
}

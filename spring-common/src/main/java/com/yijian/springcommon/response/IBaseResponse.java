package com.yijian.springcommon.response;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/23 16:33
 * @description:
 */
public interface IBaseResponse {

    /**
     * 获取响应码
     * @return 响应码
     */
    Integer getCode();

    /**
     * 获取响应消息
     * @return message
     */
    String getMessage();

    /**
     * 获取响应状态
     * @return true/false
     */
    Boolean getSuccess();
}

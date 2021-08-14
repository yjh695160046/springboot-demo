package com.yijian.springcommon.Enum;

import com.yijian.springcommon.response.IBaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/23 16:06
 * @description: 统一返回code码
 */
@Getter
@AllArgsConstructor
public enum EnumBaseResponse implements IBaseResponse {

    SUCCESS(true, 20000, "操作成功"),
    ERROR(false, 20001, "操作失败"),
    DELETE_ERROR(false, 20012, "删除失败"),
    NOT_FOUND(false,200013, "找不到资源");

    private Boolean success;

    private Integer code;

    private String message;

}

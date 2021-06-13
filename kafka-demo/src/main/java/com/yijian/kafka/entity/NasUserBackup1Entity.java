package com.yijian.kafka.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/16 11:25
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("nas_user_backup_1")
public class NasUserBackup1Entity {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     *
     */
    private String mobile;
    /**
     * 创建时间(开户时间)
     */
    private Long createTime;
    /**
     * 修改时间
     */
    private Long updateTime;
    /**
     * ****
     */
    private Integer bizopen;
    /**
     * 0：未开通未注册  1：已开通未注册 2：未开通已注册  3：已开通已注册
     */
    private Integer status;
    /**
     * 密码
     */
    private String password;
    /**
     * 综合业务id ****
     */
    private String bizId;
    /**
     * 账号
     */
    private String account;
    /**
     * 套餐容量
     */
    private Long capacity;
    /**
     * 省
     */
    private Integer province;
    /**
     * 市，4411
     */
    private String city;
    /**
     * 地区码
     */
    private Integer regionCode;
    /**
     * 开通渠道，1CRM 2线上
     */
    private Integer openChannel;
    /**
     * 激活时间
     */
    private Long activtionTime;
}

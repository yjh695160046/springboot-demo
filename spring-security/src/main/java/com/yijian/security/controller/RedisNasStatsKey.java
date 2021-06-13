package com.yijian.security.controller;

/**
 * @Author: yaojinhua
 * @Date: 2021/3/22 14:11
 * @Description: Nas统计平台redis key
 */
public interface RedisNasStatsKey {

    /**
     * 激活 统计量
     */
    String NAS_ACTIVATE_RECENT_AREA_TOTAL = "nas_activate_recent_area_total";

    /**
     * 注册 统计量
     */
    String NAS_REGISTER_RECENT_AREA_TOTAL = "nas_register_recent_area_total";

    /**
     * 复机/拆机统计量
     */
    String NAS_RESTOREBACK_RECENT_AREA_TOTAL = "nas_restore_back_recent_area_total";

    /**
     * 活跃 每小时
     */
    String ACTIVE_HOUR_SET = "active_hour_set";

    /**
     * 活跃 每天
     */
    String ACTIVE_DAY_SET = "active_day_set";

    /**
     * 留存率
     */
    String RETENTION_RATE = "retention_rate";

    /**
     * 缓存会员信息
     */
    String ALL_USER_INFO_DATA_KEY = "all_user_info_data";

    /**
     * 所有会员已使用的套餐容量总量的key
     */
    String ALL_USER_CAPACITYUSED_TOTAL_KEY = "all_user_capacityused_total";

    /**
     * 用户平均使用量
     */
    String ALL_USER_CAPACITYUSED_TOTAL_AVERAGE_KEY = "all_user_capacityused_average_total";

    /**
     * 统计平台 锁key前缀
     */
    String KAFKA_CONSUMER_APPID = "nas_kafka_consumer_job";

}

package com.yijian.javabase.utils;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpUtil;
import java.util.Map;
import java.util.TreeMap;

public class SignUtils {
    /**
     * 生成签名 - H5App
     *
     * @return 签名
     */
    public static String getH5AppSign(Map<String, Object> dataMap, String appId,
                                      String appSecret, String timestamp) {
        try {
            dataMap.put("X-H5App-Timestamp", timestamp);
            dataMap.put("X-H5App-ID", appId);
            TreeMap<String, Object> paramsMap = MapUtil.sort(dataMap);
            String paramsString = HttpUtil.toParams(paramsMap);
            String signature = HMACSHA1.getSignature(paramsString, appSecret).toUpperCase();
            return signature;

        } catch (Exception e) {
        }
        return "";
    }


}

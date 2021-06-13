//package com.yijian.javabase.config;
//
//import cn.hutool.http.HttpRequest;
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * 小程序获取天翼云盘能力开放 AccessToken（getECloudToken）
// * 文档参考：
// *（一）接入准备：https://miniapp.cloud.189.cn/doc/develop/server/tutorial/intro/usage.html
// *（二）接口详情：https://miniapp.cloud.189.cn/doc/develop/server/api/ecloud/getECloudToken.html
// *（三）调用说明：https://miniapp.cloud.189.cn/doc/develop/server/tutorial/intro/call.html
// *（四）登录流程：https://miniapp.cloud.189.cn/doc/develop/framework/open/user/login.html
// * @author longhp
// * @date 2021/1/27 14:33
// */
//public class GetECloudTokenMain {
//
//    // 接入准备
//    // 小程序账号开通（如小程序账号已开通，开发人员可联系申请小程序的管理员账号获取 appId 和 appSecret）
//    // 文档参考：https://miniapp.cloud.189.cn/doc/develop/server/tutorial/intro/usage.html
//
//    // 小程序 ID：由小程序平台分配产生，作为小程序的唯一标识。如：5e2a6363（该 appId 为官方示例小程序，可用于开发者调试）
//    public static final String APP_ID = "0e0d8b62";
//    // 小程序秘钥：由小程序平台分配产生，用于接口签名算法（注意妥善保管，防止泄露）
//    public static final String APP_SECRET = "0186a6eb20b4a1b101f8c8504e143f9fd296472a";
//
//    // 小程序获取用户信息
//    // 文档参考：https://miniapp.cloud.189.cn/doc/develop/server/api/auth/getUserInfo.html
//    public static String GET_ECLOUD_TOKEN_API_URL = "https://miniapp.cloud.189.cn/platform/auth/api/open/getECloudToken";
//
//    // 运行主函数开启接口调试
//    public static void main(String[] args) {
//
//        // 可以从上一步 Code2SessionMain 的打印信息中获得 h5appSession
//        // String h5appSession = "";
//        String h5appSession = "8853ED06959DA38C3669CD01D7A4755ADD785963CA19808537C345A287161FAE86105E5A26FD625765DD931AF43A52D5BE184D2F52D9E65E7806411CC29803CCF46AE16AAFD4E9BC5F6C29D63103B9B8153C9CC207918BA16B3DDD3DB9FD1CF7FD1FDCEA";
//
//        System.out.println("三、小程序获取天翼云盘能力开放 AccessToken（getECloudToken）");
//        // 调用 getECloudToken 方法获取天翼云盘 AccessToken 信息
//        String accessToken = getECloudToken(h5appSession);
//
//        // 打印天翼云盘 accessToken 的值
//        System.out.println("4.获取 accessToken ===> " + accessToken);
//    }
//
//
//    public static String getECloudToken(String h5appSession) {
//        // 获取当前时间戳
//        String timestamp = String.valueOf(System.currentTimeMillis());
//
//        // 构造 TreeMap
//        Map<String, Object> dataMap = new HashMap<>(3);
//        dataMap.put("h5appSession", h5appSession);
//        System.out.println("1.生成参数对象 paramsMap ===> " + dataMap);
//
//        // 生成签名
//        // 参考文档：https://miniapp.cloud.189.cn/doc/develop/server/tutorial/intro/call.html
//        String signature = SignUtils.getH5AppSign(dataMap, APP_ID, APP_SECRET, timestamp);
//        System.out.println("2.计算生成签名 signature ===> " + signature);
//
//        // 构造请求头参数
//        Map<String, String> headerParams = new HashMap<>(8);
//        headerParams.put("X-H5App-ID", APP_ID);
//        headerParams.put("X-H5App-Timestamp", timestamp);
//        headerParams.put("X-H5App-Signature", signature);
//
//        // 发送 GET 请求
//        String result = HttpRequest.get(GET_ECLOUD_TOKEN_API_URL + "?h5appSession=" + h5appSession)
//                .headerMap(headerParams,true)
//                .execute().body();
//
//        // 打印请求及响应
//        System.out.println("3.发送接口请求 httpRequest ===> " + "GET " + GET_ECLOUD_TOKEN_API_URL);
//        System.out.println("  请求头参数 httpHeaders ===> " + headerParams);
//        System.out.println("  请求体参数 httpParams ===> " + "?h5appSession=" + h5appSession);
//        System.out.println("  响应体数据 httpResponse ===> " + result);
//
//        // 解析 JSON 字符串
//        JSONObject jsonInfo = JSONObject.parseObject(result);
//        if (null != jsonInfo) {
//            JSONObject data = jsonInfo.getJSONObject("data");
//            if (null != data) {
//                String accessToken = data.getString("accessToken");
//                return accessToken;
//            }
//        }
//        return null;
//    }
//}

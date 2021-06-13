package com.yijian.javabase.config;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.yijian.javabase.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 小程序临时登录凭证校验（code2Session）
 * 文档参考：
 *（一）接入准备：https://miniapp.cloud.189.cn/doc/develop/server/tutorial/intro/usage.html
 *（二）接口详情：https://miniapp.cloud.189.cn/doc/develop/server/api/auth/code2Session.html
 *（三）调用说明：https://miniapp.cloud.189.cn/doc/develop/server/tutorial/intro/call.html
 *（四）登录流程：https://miniapp.cloud.189.cn/doc/develop/framework/open/user/login.html
 * @author longhp
 * @date 2021/1/27 14:33
 */
public class Code2SessionMain {

    // 接入准备
    // 小程序账号开通（如小程序账号已开通，开发人员可联系申请小程序的管理员账号获取 appId 和 appSecret）
    // 文档参考：https://miniapp.cloud.189.cn/doc/develop/server/tutorial/intro/usage.html

    // 小程序 ID：由小程序平台分配产生，作为小程序的唯一标识。如：5e2a6363（该 appId 为官方示例小程序，可用于开发者调试）
    public static final String APP_ID = "f144c1b9";
    // 小程序秘钥：由小程序平台分配产生，用于接口签名算法（注意妥善保管，防止泄露）
    public static final String APP_SECRET = "a5c821b7d97f0735f0491cb05d2fc97f0876709a";

    // 小程序登录凭证校验接口地址
    // 文档参考：https://miniapp.cloud.189.cn/doc/develop/server/api/auth/code2Session.html
    public static String CODE2SESSION_API_URL = "https://miniapp.cloud.189.cn/platform/auth/api/open/code2Session";

    // 运行主函数开启接口调试
    public static void main(String[] args) {

        // 调试时可以使用天翼云盘 App 扫描示例小程序的二维码打开，点击底部【接口】-【接口】-【客户端下发小程序唯一 code】获取后赋值给下方 h5appCode
        // 小程序官方示例二维码：https://miniapp.cloud.189.cn/doc/introduction/miniapp/demo.html
        // 注意：h5appCode 的有效期仅为2分钟，失效后可以按以上步骤重新获取（如返回登录凭证已过期，说明清明签名通过了）
        // String h5appCode = "";
        String h5appCode = "F149E37AF6610598B70C19CDFE8D30854C9178F26B0F3736B31905625984E39F7B6CC3283A18B41E6DA854B27A15E80D3B043958D4D5C54943BD99E1494C6AAAE4C8372B6227466B5DC4EAE0E919D9130F0FE98A";

        System.out.println("一、小程序临时登录凭证校验（code2Session）");
        // 调用 getH5appSession 方法获取 h5appSession
        String h5appSession = getH5appSession(h5appCode);

        // 打印 h5appSession 的值
        System.out.println("4.获取 h5appSession ===> " + h5appSession);
    }


    public static String getH5appSession(String h5appCode) {
        // 获取当前时间戳
        String timestamp = String.valueOf(System.currentTimeMillis());

        // 构造 TreeMap
        Map<String, Object> dataMap = new HashMap<>(3);
        dataMap.put("h5appCode", h5appCode);
        System.out.println("1.生成参数对象 paramsMap ===> " + dataMap);

        // 生成签名
        // 参考文档：https://miniapp.cloud.189.cn/doc/develop/server/tutorial/intro/call.html
        String signature = SignUtils.getH5AppSign(dataMap, APP_ID, APP_SECRET, timestamp);
        System.out.println("2.计算生成签名 signature ===> " + signature);

        // 构造请求头参数
        Map<String, String> headerParams = new HashMap<>(8);
        headerParams.put("X-H5App-ID", APP_ID);
        headerParams.put("X-H5App-Timestamp", timestamp);
        headerParams.put("X-H5App-Signature", signature);

        // 构造请求体参数
        Map<String, Object> formMap = new HashMap<>(8);
        formMap.put("h5appCode", h5appCode);

        // 发送 POST 请求
        String result = HttpRequest.post(CODE2SESSION_API_URL)
                .headerMap(headerParams,true)
                .form(formMap)
                .execute().body();

        // 打印请求及响应
        System.out.println("3.发送接口请求 httpRequest ===> " + "POST " + CODE2SESSION_API_URL);
        System.out.println("  请求头参数 httpHeaders ===> " + headerParams);
        System.out.println("  请求体体参数 httpParams ===> " + formMap);
        System.out.println("  响应体数据 httpResponse ===> " + result);

        // 解析 JSON 字符串
        JSONObject jsonInfo = JSONObject.parseObject(result);
        if (null != jsonInfo) {

            // 接口响应格式参考文档：https://miniapp.cloud.189.cn/doc/develop/server/api/auth/code2Session.html
            JSONObject data = jsonInfo.getJSONObject("data");
            if (null != data) {

                // 获取到 h5appSession 后可参考后续处理可以参考小程序登录过程
                // 参考文档：https://miniapp.cloud.189.cn/doc/develop/framework/open/user/login.html
                return data.getString("h5appSession");
            }
        }
        return null;
    }
}

//package com.yijian.security.util;
//
//import com.alibaba.fastjson.JSON;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//
///**
// * @Author: yaojinhua
// * @Date: 2021/4/13 16:53
// * @Description:
// */
//public class JWTTokenUtil {
//    /**
//     * 生成Token
//     * @Param  selfUserEntity 用户安全实体
//     * @Return Token
//     */
//    public static String createAccessToken(SelfUserEntity selfUserEntity){
//        // 登陆成功生成JWT
//        String token = Jwts.builder()
//                // 放入用户名和用户ID
//                .setId(selfUserEntity.getUserId()+"")
//                // 主题
//                .setSubject(selfUserEntity.getUsername())
//                // 签发时间
//                .setIssuedAt(new Date())
//                // 签发者
//                .setIssuer("sans")
//                // 自定义属性 放入用户拥有权限
//                .claim("authorities", JSON.toJSONString(selfUserEntity.getAuthorities()))
//                // 失效时间
//                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
//                // 签名算法和密钥
//                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
//                .compact();
//        return token;
//    }
//}

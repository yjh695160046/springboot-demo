package com.yijian.springcommon.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/28 9:40
 * @description: 生成Jwt
 *       JWT包含了三部分：
 *          Header 头部(标题包含了令牌的元数据，并且包含签名和/或加密算法的类型)
 *          Payload 负载 (类似于飞机上承载的物品) 有效数据
 *          Signature 签名/签证
 */
public class JwtUtils {

    // 生成三部分 header头 有效载荷 验证签名

    public static String genJwt() {

        JwtBuilder builder = Jwts.builder();

        // header头 主要两部分 ALGORITHM & TOKEN TYPE
        builder.setHeaderParam("tpy", "JWT"); //token类型
        builder.setHeaderParam("alg", "SHA256"); // 采用的加密算法


        // 有效载荷 有效信息 PAYLOAD:DATA
        // 默认字段
        builder.setId("1"); // 唯一身份标识
        builder.setSubject("yijian-user-info"); // 令牌主题
        builder.setIssuedAt(new Date()); // 令牌颁发时间
        builder.setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000));// 令牌有效时间 30分钟
        // 私有字段 存放基本用户信息 但不能是敏感信息
        Map<String, Object> claims = new HashMap<>(16);
        claims.put("id", 1);
        claims.put("nickName", "zhangsan");
        claims.put("age", 23);
        builder.setClaims(claims);

        // 第三部分 签名哈希 VERIFY SIGNATURE
        builder.signWith(SignatureAlgorithm.HS256, "123456");
        return builder.compact();
    }

    /**
     * 解析jwtToken 返回私有信息
     *
     * @param jwtToken
     * @return
     */
    public static Claims checkJwt(String jwtToken) {

        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey("123456").parseClaimsJws(jwtToken);
        System.out.println(claimsJws.getBody());
        System.out.println(claimsJws.getHeader());
        return claimsJws.getBody();
    }

    private static void test1() {
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                .setSubject("guli-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))

                .claim("id", 1)  //设置token主体部分 ，存储用户信息
                .claim("nickname", 1)

                .signWith(SignatureAlgorithm.HS256, "123456")
                .compact();

    }
}

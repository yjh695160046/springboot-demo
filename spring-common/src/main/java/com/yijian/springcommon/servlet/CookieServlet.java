package com.yijian.springcommon.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/8 14:02
 * @description:
 */
@WebServlet("/cookie")
@Slf4j
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 7412660694228426577L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");
        log.info("收到请求：{}，方法：{}， Origin头：{}", requestURI, method, originHeader);
        // 读取Cookie
        List<Cookie> myCookies = new ArrayList<>();
        if (req.getCookies() != null) {
            myCookies = Arrays.stream(req.getCookies()).filter(c -> "name".equals(c.getName()) || "age".equals(c.getName())).collect(Collectors.toList());
        }
        if (myCookies.isEmpty()) {
            // 种植Cookie
            Cookie cookie = new Cookie("name", "张三");
            cookie.setDomain("baidu.com");
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
            cookie = new Cookie("age", "18");
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
        } else {
            myCookies.forEach(c -> {
                log.info("name:{} value:{} domain:{} path:{} maxAge:{} secure:{}", c.getName(), c.getValue(), c.getDomain(), c.getPath(), c.getMaxAge(), c.getSecure());
            });
        }
       resp.getWriter().write("hello cookie...");
    }

}
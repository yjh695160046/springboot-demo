package com.yijian.springcommon.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *
 *
 * Referer:一般用于统计或防盗链
 * Origin：cors请求
 *
 */

/**
 * @author: yxyaojinhua
 * @date: 2022/4/8 10:48
 * @description:
 */
@Slf4j
@WebServlet(urlPatterns = "/cors")
@Configuration
@ServletComponentScan("com.yijian.springcommon")
public class CorsServlet extends HttpServlet {

    private static final long serialVersionUID = 7952360441176076281L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");

        log.info("收到请求：{}，方法：{}， Origin头：{}", requestURI, method, originHeader);
        resp.getWriter().write("hello cors...");
    }
}

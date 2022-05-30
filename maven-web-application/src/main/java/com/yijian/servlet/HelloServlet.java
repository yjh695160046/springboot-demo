package com.yijian.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/18 10:50
 * @description:
 */
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 7730473665390521427L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet doGet.....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet doPost.....");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("HelloServlet service.....");
        System.out.println("req....." + req.getClass());
        System.out.println("resp....." + resp.getClass());
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("HelloServlet service.....");
        System.out.println("req....." + req.getClass());
        System.out.println("res....." + res.getClass());
    }
}

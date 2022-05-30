package com.yijian.springcommon.servlet;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/8 17:32
 * @description:
 */
@WebFilter(filterName = "firstFilter", urlPatterns = "/cookie")
public class FirstFilter extends GenericFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(" first filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("enter first filter");
        CustomHttpServletRequestWrapper custom = new CustomHttpServletRequestWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(custom, servletResponse);
        System.out.println("leave first filter");
    }

    @Override
    public void destroy() {
        System.out.println(" first filter destroy");
    }
}

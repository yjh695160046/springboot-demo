package com.yijian.springcommon.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yxyaojinhua
 * @date: 2022/4/8 17:45
 * @description:
 */
public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public CustomHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        this.params.putAll(request.getParameterMap());
    }

    private Map<String, String> headerMap = new HashMap<>();
    private Map<String , String[]> params = new HashMap<>();

    public void addHeader(String name, String value) {
        headerMap.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        String headerValue = super.getHeader(name);
        if (headerMap.containsKey(name)) {
            headerValue = headerMap.get(name);
        }
        return headerValue;
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        List<String> names = Collections.list(super.getHeaderNames());
        for (String name : headerMap.keySet()) {
            names.add(name);
        }
        return Collections.enumeration(names);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        List<String> values = Collections.list(super.getHeaders(name));
        if (headerMap.containsKey(name)) {
            values.add(headerMap.get(name));
        }
        return Collections.enumeration(values);
    }

    @Override

    public String getParameter(String name) {//重写getParameter，代表参数从当前类中的map获取

        String[]values = params.get(name);

        if(values == null || values.length == 0) {

            return null;

        }

        return values[0];

    }



    @Override
    public String[] getParameterValues(String name) {//同上

        return params.get(name);

    }
}

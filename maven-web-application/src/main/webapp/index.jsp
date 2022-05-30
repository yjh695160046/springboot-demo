<%@ page import="com.yijian.juc.ObjectHeader" %>
<%@ page import="org.openjdk.jol.info.ClassLayout" %>
<%@ page import="com.yijian.juc.A" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<%
    Object obj = new Object();
    System.out.println("上:" + ClassLayout.parseInstance(obj).toPrintable());
    synchronized (obj){
        System.out.println("中:" + ClassLayout.parseInstance(obj).toPrintable());
    }

    System.out.println("下:" + ClassLayout.parseInstance(obj).toPrintable());
%>
<h2>Hello World!1</h2>
</body>
</html>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: chengjingqiang
  Date: 2020/6/5
  Time: 10:11 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.equals("lastTime1")) {
                flag = true;
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
                String lastTime = format.format(date);
                String encode = URLEncoder.encode(lastTime, "utf-8");
                cookie.setValue(encode);
                cookie.setMaxAge(60 * 60 * 60 * 24 * 30);
                response.addCookie(cookie);

                String value = cookie.getValue();
                String decode = URLDecoder.decode(value, "utf-8");
%>
<h1>
    欢迎回来，您上次访问的时间为：<%= decode%>
</h1>
<%

                break;
            }
        }
    }
    if (cookies == null || cookies.length <= 0 || !flag) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String lastTime = format.format(date);
        String encode = URLEncoder.encode(lastTime, "utf-8");
        Cookie cookie = new Cookie("lastTime1", encode);
        cookie.setMaxAge(60 * 60 * 60 * 24 * 30);
        response.addCookie(cookie);
%>
<h1>欢迎你首次访问</h1>
<%
    }
%>
</body>
</html>

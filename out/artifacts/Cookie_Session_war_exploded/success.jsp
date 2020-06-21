<%--
  Created by IntelliJ IDEA.
  User: chengjingqiang
  Date: 2020/6/5
  Time: 5:35 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login success</title>
</head>
<body>
    <h1>欢迎<%= request.getSession().getAttribute("user")%>进入xx页面</h1>
</body>
</html>

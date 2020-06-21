<%--
  Created by IntelliJ IDEA.
  User: chengjingqiang
  Date: 2020/6/5
  Time: 4:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/day16/checkCodeServlet?lastTime=" + new Date().getTime();
            }
        }

    </script>
    <style type="text/css">
        div{
            color: red;
        }
    </style>

</head>
<body>
<form method="post" action="/day16/loginServlet">
    <table>
        <tr>
            <td>
                用户名
            </td>
            <td><input type="text" name="username" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>
                密码
            </td>
            <td><input type="text" name="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td>
                验证码
            </td>
            <td><input type="text" name="checkCode" placeholder="请输入验证码"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/day16/checkCodeServlet"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>

<div>
    <%= request.getSession().getAttribute("error_username") == null ? "" : request.getSession().getAttribute("error_username")%>
</div>

<div>
    <%= request.getSession().getAttribute("error_checkCode") == null ? "" : request.getSession().getAttribute("error_checkCode")%>
</div>
</body>
</html>

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
<div>

    <form method="post" action="/day16/loginServlet">
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入用户名" name="username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">密码</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="password">
        </div>
        <div class="form-group">
            <label for="exampleInputFile">验证码</label>
            <input type="file" id="exampleInputFile" name="checkCode" placeholder="请输入验证码">
            <p class="help-block"><img id="img" src="/day16/checkCodeServlet"></p>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> Check me out
            </label>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

<div>
    <%= request.getSession().getAttribute("error_username") == null ? "" : request.getSession().getAttribute("error_username")%>
</div>

<div>
    <%= request.getSession().getAttribute("error_checkCode") == null ? "" : request.getSession().getAttribute("error_checkCode")%>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: chengjingqiang
  Date: 2020/6/10
  Time: 11:23 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <title>登录</title>
    <script>
        function refreshCode() {
            var elementById = document.getElementById(checkCode);
            elementById.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime()
        }
    </script>
</head>
<body>
   <div class="container" style="width: 40%">
       <div class="panel-body" align="center">
           <p style="font-size: 25px">管理员登录</p>
       </div>
       <form>
           <div class="form-group">
               <label for="exampleInputEmail1">用户名</label>
               <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入用户名">
           </div>
           <div class="form-group">
               <label for="exampleInputPassword1">密码</label>
               <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
           </div>
       </form>
       <form class="form-inline">
           <div class="form-group">
               <label for="exampleInputName2">验证码</label>
               <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
           </div>

           <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCodeServlet" id="checkCode" title="看不清点击刷新"></a>
       </form>
       <div align="center"><button type="button" class="btn btn-primary">登录</button></div>

       <div style="background-color: #f5e79e;width: 100%;height:50px;border-radius: 8px;margin-top: 40px" >
           <span style="align-content: center">登录失败</span>
       </div>
   </div>
</body>
</html>

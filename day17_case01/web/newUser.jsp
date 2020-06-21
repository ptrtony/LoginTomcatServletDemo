<%--
  Created by IntelliJ IDEA.
  User: chengjingqiang
  Date: 2020/6/7
  Time: 3:49 下午
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
    <title>添加联系人</title>
</head>
<body>
<div class="container">
    <div align="center"><h3>添加联系人页面</h3></div>
    <form method="post" action="${pageContext.request.contextPath}/newUserServlet">
        <div class="form-group">
            <label for="exampleInputEmail1">姓名:</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入姓名" name="name">
        </div>

        <div class="form-group">
            <label>性别:</label>

            <input type="radio" name="gender" value="男"> 男
            <input type="radio" name="gender" value="女"> 女
        </div>
        <div class="form-group">
            <label for="exampleInputAge">年龄:</label>
            <input type="text" class="form-control" id="exampleInputAge" placeholder="请输入年龄" name="age">
        </div>
        <div class="form-group">
            <label for="address">籍贯:</label>
            <select name="address" id="address" class="form-control">
                <option value="陕西">陕西</option>
                <option value="成都">成都</option>
                <option value="上海">上海</option>
                <option value="天津">天津</option>
            </select>
        </div>

        <div class="form-group">
            <label for="exampleqq">qq:</label>
            <input type="text"  class="form-control" id="exampleqq" name="qq" placeholder="请输入qq">
        </div>

        <div class="form-group">
            <label for="exampleEmail">邮箱:</label>
            <input type="text"  class="form-control" id="exampleEmail" name="email" placeholder="请输入邮箱">
        </div>

        <div align="center">
            <button type="submit" class="btn btn-primary">提交</button>
            <button type="button" class="btn btn-default" name="">重置</button>
            <button type="button" class="btn btn-default" name="">返回</button>
        </div>

    </form>
</div>
</body>
</html>

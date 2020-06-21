<%--
  Created by IntelliJ IDEA.
  User: chengjingqiang
  Date: 2020/6/7
  Time: 11:55 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>所有用户信息</title>
    <style>
        .panel-body {
            font-size: 32px;
            color: #2aabd2;
        }

        th{
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            if (confirm("你确定删除吗？")){
                location.href = "${pageContext.request.contextPath}/deleteUserServlet?id="+id
            }
        }
    </script>
</head>
<body>
<div class="container">
    <!-- Default panel contents -->
    <div class="panel-body" align="center">
        <p>用户管理列表</p>
    </div>

    <form class="form-inline" style="float: left">
        <div class="form-group">
            <label for="exampleInputName2">姓名</label>
            <input type="text" class="form-control" id="exampleInputName2">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail2">籍贯</label>
            <input type="email" class="form-control" id="exampleInputEmail2">
        </div>

        <div class="form-group">
            <label for="exampleInputEmail2">邮箱</label>
            <input type="email" class="form-control" id="exampleInputEmail3">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>
    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" type="button" href="${pageContext.request.contextPath}/newUser.jsp" role="button">添加联系人</a>
        <a class="btn btn-primary" type="button" href="${pageContext.request.contextPath}/newUser.jsp">删除选中</a>
    </div>
    <!-- Table -->
    <table class="table table-hover" width="100%" border="1" style="border-color: #ebebeb">
        <tr class="success">
            <th><input type="checkbox"></th>
            <th style="align: center">编号</th>
            <th style="align: center">姓名</th>
            <th style="align: center">性别</th>
            <th style="align: center">年龄</th>
            <th style="align: center">籍贯</th>
            <th style="align: center">qq</th>
            <th style="align: center">邮箱</th>
            <th style="align: center">操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="s">
            <tr align="center">
                <td><input type="checkbox"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/updateUserServlet?id=${user.id}">修改</a>
                    <a class="btn btn-default btn-sm"
                       href="javascript:deleteUser(${user.id});">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px">共16条记录，共4页</span>
            </ul>
        </nav>

    </div>

</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: chengjingqiang
  Date: 2020/6/7
  Time: 3:49 下午
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
    <title>添加联系人</title>
</head>
<body>
<div class="container">
    <div align="center"><h3>修改联系人页面</h3></div>
    <form method="post" action="${pageContext.request.contextPath}/setUserServlet">
        <input type="text" value="${user.id}" hidden name="id">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" id="name" value="${user.name}" placeholder="请输入姓名"
                   name="name" readonly>
        </div>

        <div class="form-group">
            <label>性别:</label>
<%--            <c:if test="${user.gender == '男'}">--%>
                <input type="radio" name="gender" value="男"> 男
                <input type="radio" name="gender" value="女"> 女
<%--            </c:if>--%>
<%--            <c:if test="${user.gender == '女'}">--%>
<%--                <input type="radio" name="gender" value="男"> 男--%>
<%--                <input type="radio" name="gender" value="女" checked> 女--%>
<%--            </c:if>--%>
        </div>
        <div class="form-group">
            <label for="age">年龄:</label>
            <input type="text" class="form-control" id="age" placeholder="请输入年龄" value="${user.age}" name="age">
        </div>
        <div class="form-group">
            <label for="address1">籍贯:</label>
            <select name="address" id="address1" class="form-control">
<%--                <c:if test="${user.address == '陕西'}">--%>
<%--                    <option value="陕西" selected>陕西</option>--%>
<%--                    <option value="成都">成都</option>--%>
<%--                    <option value="上海">上海</option>--%>
<%--                    <option value="天津">天津</option>--%>
<%--                </c:if>--%>


<%--                <c:if test="${user.address == '成都'}">--%>
<%--                    <option value="陕西">陕西</option>--%>
<%--                    <option value="成都" selected>成都</option>--%>
<%--                    <option value="上海">上海</option>--%>
<%--                    <option value="天津">天津</option>--%>
<%--                </c:if>--%>

<%--                <c:if test="${user.address == '上海'}">--%>
<%--                    <option value="陕西">陕西</option>--%>
<%--                    <option value="成都">成都</option>--%>
<%--                    <option value="上海" selected>上海</option>--%>
<%--                    <option value="天津">天津</option>--%>
<%--                </c:if>--%>

<%--                <c:if test="${user.address == '天津'}">--%>
                    <option value="陕西">陕西</option>
                    <option value="成都">成都</option>
                    <option value="上海">上海</option>
                    <option value="天津">天津</option>
<%--                </c:if>--%>

            </select>


        </div>

        <div class="form-group">
            <label for="qq">qq:</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入qq"
                   value="${user.qq}">
        </div>

        <div class="form-group">
            <label for="email">邮箱:</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱"
                   value="${user.email}">
        </div>

        <div align="center">
            <input type="submit" class="btn btn-primary" value="提交"></input>
            <input type="button" class="btn btn-default" value="重置"></input>
            <input type="button" class="btn btn-default" value="返回"></input>
        </div>

    </form>
</div>
</body>
</html>

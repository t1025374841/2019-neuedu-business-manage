<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2019/8/7
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<p>首页</p>
欢迎，${userinfo.username}登录 &nbsp&nbsp<a href="/user/outLogin">退出登录</a>
<br/>
<br/>
<a href="/user/userlist">用户列表</a>
<br/>
<a href="/user/category/find">类别列表</a>
<br/>
<a href="/user/product/find">商品列表</a>
<br/>
</body>
</html>

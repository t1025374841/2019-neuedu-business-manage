<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2019/8/6
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分类列表</title>
</head>
<body>
<h1>类别列表</h1>
<a href="/user/home">返回</a>
<br/>
<a href="add">添加类别</a>
<table border="1">
    <thead>
      <th>类别Id</th>
      <th>类别名称</th>
      <th>所属父类</th>
      <th>类别状态</th>
      <th>创建时间</th>
      <th>修改时间</th>
      <th>操作</th>
    </thead>
    <c:forEach items="${categorylist}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.parentCategory.name}</td>
            <td>${category.status}</td>
            <td>${category.createTime}</td>
            <td>${category.updateTime}</td>
            <td><a href="update/${category.id}">修改</a>/<a href="delete/${category.id}">删除</a></td>
        </tr>

    </c:forEach>
</table>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.pojo.UserInfo" %>
<%@ page import="com.neuedu.consts.Const" %><%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/7/26
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <script>
        function updateUser(e) {
            var id=e.id;
            console.info(id);
            location.href='http://localhost:8080/update?'+'user_id=' + encodeURI(id);
        }
        function deleteUser(e) {
            var id=e.id;
//            var a=document.getElementsByName("delete");
//            var id=a.id;
            console.info(id);
            location.href='http://localhost:8080/delete?'+'user_id=' + encodeURI(id);
        }

    </script>
</head>
<body>

<p>首页</p>

欢迎，${userinfo.username}登录 &nbsp&nbsp<a href="/user/outLogin">退出登录</a>

<br/>
<table border="1">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>email</th>
        <th>phone</th>
        <th>question</th>
        <th>answer</th>
        <th>role</th>
        <th>creat_time</th>
        <th>update_time</th>
        <th>ip</th>
        <th>controller</th>
    </tr>
    <c:forEach var="user" items="${all_userinfo}">
        <c:if test="${user.id==userinfo.id}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.question}</td>
                <td>${user.answer}</td>
                <td>${user.role}</td>
                <td>${user.createTime}</td>
                <td>${user.updateTime}</td>
                <td>${user.ip}</td>
                <td><a href="update/${user.id}">修改</a></td>
            </tr>
        </c:if>
        <c:if test="${user.id!=userinfo.id&&user.role!=0}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.question}</td>
            <td>${user.answer}</td>
            <td>${user.role}</td>
            <td>${user.createTime}</td>
            <td>${user.updateTime}</td>
            <td>${user.ip}</td>
            <td><a href="update/${user.id}">修改</a>/<a href="delete/${user.id}">删除</a></td>
        </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>

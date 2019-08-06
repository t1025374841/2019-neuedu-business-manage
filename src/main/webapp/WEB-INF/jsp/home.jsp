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
        function outLogin() {
            location.href='http://localhost:8080/outLogin';
        }
    </script>
</head>
<body>

<p>首页</p>

欢迎，${userinfo.username}登录 &nbsp&nbsp<a href="#" onclick="outLogin()">退出登录</a>

<br/>
<table border="1">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>password</th>
        <th>question</th>
        <th>answer</th>
        <th>email</th>
        <th>status</th>
        <th>controller</th>
    </tr>
    <c:forEach var="user" items="${all_userinfo}">
        <c:if test="${user.id==userinfo.id}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.question}</td>
                <td>${user.answer}</td>
                <td>${user.email}</td>
                <td>${user.status}</td>
                <td><a href="#"  id="${user.id}"  onclick="updateUser(this)">修改</td>
            </tr>
        </c:if>
        <c:if test="${user.id!=userinfo.id&&user.status!='admin'}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.question}</td>
            <td>${user.answer}</td>
            <td>${user.email}</td>
            <td>${user.status}</td>
            <td><a href="#"  id="${user.id}"  onclick="updateUser(this)">修改</a>/<a href="#" id="${user.id}"   onclick="deleteUser(this)">删除</a></td>
        </tr>
        </c:if>
    </c:forEach>
    <%--<%--%>
        <%--HttpSession session1=request.getSession();--%>
        <%--List<UserInfo> userList= (List<UserInfo>) session1.getAttribute(Const.ALL_USER);--%>
        <%--for(UserInfo userInfo:userList){--%>
            <%--response.getWriter().print("<tr>");--%>
            <%--response.getWriter().print("<td>");--%>
            <%--response.getWriter().print(userInfo.getId());--%>
            <%--response.getWriter().print("</td>");--%>
            <%--response.getWriter().print("<td>");--%>
            <%--response.getWriter().print(userInfo.getUsername());--%>
            <%--response.getWriter().print("</td>");--%>
            <%--response.getWriter().print("<td>");--%>
            <%--response.getWriter().print(userInfo.getPassword());--%>
            <%--response.getWriter().print("</td>");--%>
            <%--response.getWriter().print("<td>");--%>
            <%--response.getWriter().print(userInfo.getQuestion());--%>
            <%--response.getWriter().print("</td>");--%>
            <%--response.getWriter().print("<td>");--%>
            <%--response.getWriter().print(userInfo.getAnswer());--%>
            <%--response.getWriter().print("</td>");--%>
            <%--response.getWriter().print("<td>");--%>
            <%--response.getWriter().print(userInfo.getEmail());--%>
            <%--response.getWriter().print("</td>");--%>
            <%--response.getWriter().print("</tr>");--%>
        <%--}--%>
    <%--%>--%>
</table>

</body>
</html>

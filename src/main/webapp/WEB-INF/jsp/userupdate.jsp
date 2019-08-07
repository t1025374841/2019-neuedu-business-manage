<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2019/8/3
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <script>
        function back() {
            location.href='http://localhost:8080/user/home';
        }
    </script>
</head>
<body>

<form action="" method="post">

    <span>id:</span>
    <input type="hidden" name="id" value="${update_userinfo.id}"/>
    <br/>
    <span>用户名:</span>
    <input type="text" name="username" value="${update_userinfo.username}"/>
    <br/>
    <span>密码:</span>
    <input type="text" name="password" value="${update_userinfo.password}"/>
    <br/>
    <span>邮箱:</span>
    <input type="text" name="email" value="${update_userinfo.email}"/>
    <br/>
    <span>手机:</span>
    <input type="text" name="phone" value="${update_userinfo.phone}"/>
    <br/>
    <span>密保问题:</span>
    <input type="text" name="question" value="${update_userinfo.question}"/>
    <br/>
    <span>密保答案:</span>
    <input type="text" name="answer" value="${update_userinfo.answer}"/>
    <br/>
    <span>权限:</span>
    <input type="text" name="role" value="${update_userinfo.role}"/>
    <br/>
    <span>ip:</span>
    <input type="text" name="ip" value="${update_userinfo.ip}"/>
    <br/>
    <input type="submit" value="修改"/>
    <input type="button" value="返回" onclick="back()"/>
</form>
</body>
</html>

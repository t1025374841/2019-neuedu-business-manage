<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function register() {
            location.href='http://localhost:8080/register';
        }
        function login() {
            location.href='http://localhost:8080/login';
        }
    </script>
</head>
<body>
<input type="button" value="注册" onclick="register()"/>
<input type="button" value="登录" onclick="login()"/>
</body>
</html>

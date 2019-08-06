<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/7/26
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
      <script>
          function register() {
              location.href='http://localhost:8080/register';
          }
      </script>
  </head>
  <body>


 <form action="http://localhost:8080/login" method="post">

   <span>用户名:</span>
   <input type="text" name="username"/>
   <br/>
   <span>密码:</span>
   <input type="password" name="password"/>
   <br/>
   <input type="submit" value="登录"/>
     <input type="button" value="注册" onclick="register()"/>

 </form>

  </body>
</html>

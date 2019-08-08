<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2019/8/7
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加类别</title>
    <script>
        function back() {
            location.href='/user/category/find';
        }
    </script>
</head>
<body>
<h1>添加类别</h1>


<form action="" method="post">
    名称<input type="text" name="name"><br/>
    <%--父类id<input type="text" name="parentId" value="${category.parentId}"><br/>--%>
    所属类别<select name="parentId">
                <option value="0">无</option>
                <c:forEach items="${allcategory}" var="parentcategory">
                    <option value="${parentcategory.id}">${parentcategory.name}</option>
                </c:forEach>
            </select><br/>
    <input type="submit" value="添加">
    <input type="button" value="返回" onclick="back()"/>

</form>


</body>
</html>

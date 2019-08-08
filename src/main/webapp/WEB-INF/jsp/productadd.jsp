<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2019/8/7
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品添加</title>
</head>
<body>

<form action="" method="post" enctype="multipart/form-data" >

    商品名称：<input type="text"  name="name"/><br>
    所属类别 ： <select name="categoryId">
    <c:forEach items="${allcategory}" var="category">
        <option value="${category.id}" > ${category.name} </option>
    </c:forEach>
</select><br>
    子标题：<input type="text"  name="subtitle"/><br>
    商品详情：<input type="text"  name="detail"/><br>
    商品主图：<input type="file"  name="mainImage_file"/><br>
    商品子图：<input type="file"  name="subImages_files" multiple="multiple" /><br>
    商品价格：<input type="text"  name="price"/><br>
    商品库存：<input type="text"  name="stock"/><br>
    商品状态：<input type="text"  name="status"/><br>

    <input type="submit" value="提交"><br>
</form>
</body>
</html>

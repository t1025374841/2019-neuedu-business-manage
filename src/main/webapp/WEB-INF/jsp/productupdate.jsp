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
    <title>商品更新</title>
    <script>
        function back() {
            location.href='/user/product/find';
        }
    </script>
</head>
<body>

<h1>修改类别</h1>


<form action="" method="post" enctype="multipart/form-data">

    <input type="hidden" value="${product.id}" name="id">
    商品名称：<input type="text" value="${product.name}" name="name"/><br>
    所属类别 ： <select name="categoryId">
    <c:forEach items="${allcategory}" var="category">
        <c:if test="${category.id==product.categoryId}">
            <option value="${category.id}" selected="selected"> ${category.name} </option>
        </c:if>
        <c:if test="${category.id!=product.categoryId}">
            <option value="${category.id}" > ${category.name} </option>
        </c:if>
    </c:forEach>
</select><br>
    子标题：<input type="text"  value="${product.subtitle}"  name="subtitle"/><br>
    商品详情：<input type="text"  value="${product.detail}"  name="detail"/><br>
    商品主图：<input type="file"  name="mainImage_file" /><br>
    商品子图：<input type="file"  name="subImages_files" multiple="multiple" /><br>
    商品价格：<input type="text"  value="${product.price}"  name="price"/><br>
    商品库存：<input type="text"  value="${product.stock}"  name="stock"/><br>
    商品状态：<input type="text"  value="${product.status}"  name="status"/><br>

    <input type="submit" value="提交">
    <input type="button" value="返回" onclick="back()"/>
</form>


</body>
</html>

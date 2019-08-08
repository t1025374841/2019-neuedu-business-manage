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
    <title>商品列表</title>

</head>
<body>
<h1>商品列表</h1>
<a href="/user/home">返回</a>
<br/>
<a href="add">添加商品</a>
<table  border="1">

    <thead>
    <th>商品编号</th>
    <th>商品名称</th>
    <th>所属类别</th>
    <th>子标题</th>
    <th>商品详情</th>
    <th>商品价格</th>
    <th>商品库存</th>
    <th>商品主图</th>
    <th>商品子图</th>
    <th>状态</th>
    <th>创建时间</th>
    <th>修改时间</th>
    <th>操作</th>
    </thead>
    <c:forEach items="${productlist}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.category.name}</td>
            <td>${product.subtitle}</td>
            <td>${product.detail}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td><a href="/user/product/mainImage/${product.mainImage}"><img src="/user/product/mainImage/${product.mainImage}" height="100" width="100"></a></td>
            <td id="Url${product.id}">
            </td>

                <script>
                    var text=${product.subImages};
                    var j;
                    for(j=0; j < text.subImages.length; j++){

                        var file=document.createElement("a");
                        var href="/user/product/subImages/"+text.subImages[j].url;
                        file.setAttribute("href",href);
                        var id=""+j+"subImagesUrl${product.id}";
                        file.setAttribute("id",id);
                        document.getElementById("Url${product.id}").appendChild(file);
                        var img=document.createElement("img");
                        img.setAttribute("src",href);
                        img.setAttribute("width",100);
                        img.setAttribute("height",100)
                        document.getElementById(id).appendChild(img);
                        var br=document.createElement("br");//换行
                        document.getElementById("Url${product.id}").appendChild(br);
                        //document.getElementById(""+j+"subImagesUrl${product.id}").innerHTML=text.subImages[j].url
                    }

                </script>


            <td>${product.status}</td>
            <td>${product.createTime}</td>
            <td>${product.updateTime}</td>
            <td><a href="update/${product.id}" >修改/</a>
                <a href="delete/${product.id}" >删除</a>
            </td>
        </tr>

    </c:forEach>

</table>



</body>
</html>

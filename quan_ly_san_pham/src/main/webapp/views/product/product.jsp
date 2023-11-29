<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SOC XINH
  Date: 28/11/2023
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sản phẩm</h3>
<a href="product?action=create"> ADD</a>
<a href="category">Danh Mục</a>
<a href="product">Sản Phẩm</a>
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>CATAGORY</th>

        <td colspan="2">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.productId}</td>
            <td>${item.productName}</td>
            <td>${item.price}</td>
            <td>${item.category.categoryName}</td>
            <td>
                <a href="?action=update&id=${item.productId}">Edit</a>
                <a onclick="return confirm('ban co chac chan muon xoa khong?')"
                   href="?action=delete&id=${item.productId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>

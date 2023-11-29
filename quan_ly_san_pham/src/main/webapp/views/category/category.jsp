<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SOC XINH
  Date: 28/11/2023
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Danh mục</h3>
<a href="category?action=create"> ADD</a>
<a href="category">Danh Mục</a>
<a href="product">Sản Phẩm</a>
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>NAME</th>
        <th>STATUS</th>
        <th>QUANTITY</th>

        <td colspan="2">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categoryList}" var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.categoryId}</td>
            <td>${item.categoryName}</td>
            <td>${item.status?"Action":"Block"}</td>
            <td>${item.quantity_product}</td>
            <td>
                <a href="?action=update&id=${item.categoryId}">Edit</a>
                <a onclick="return confirm('ban co chac chan muon xoa khong?')"
                   href="?action=delete&id=${item.categoryId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>

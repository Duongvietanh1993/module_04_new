<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SOC XINH
  Date: 27/11/2023
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh Sách Học Sinh</h1>
<a href="student?action=create"> ADD</a>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>BIRTHDAY</th>
        <th>ADDRESS</th>
        <td>STATUS</td>

        <td colspan="2">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.userId}</td>
            <td>${item.userName}</td>
            <td>${item.userEmail}</td>
            <td>${item.userBirthday}</td>
            <td>${item.userAddress}</td>
            <td>
                <a href="student?action=update&id=${item.userId}">Edit</a>
                <a onclick="return confirm('ban co chac chan muon xoa khong?')"
                   href="student?action=delete&id=${item.userId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>

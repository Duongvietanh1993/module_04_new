<%--
  Created by IntelliJ IDEA.
  User: SOC XINH
  Date: 27/11/2023
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center text-danger">Sửa Thông tin học sinh </h1>
            <form action="<%=request.getContextPath()%>/student?action=update&id=${update.userId}" method="post">
                <input type="hidden" name="id" value="${update.userId}">
                <div class="form-group">
                    <label >Họ và Tên: </label>
                    <input type="text" class="form-control"  name="name" value="${update.userName}">
                </div>
                <div class="form-group">
                    <label >Email: </label>
                    <input type="text" class="form-control"  name="email" value="${update.userEmail}">
                </div>
                <div class="form-group">
                    <label >Birthday: </label>
                    <input type="date" class="form-control"  name="birthday" value="${update.userBirthday}">
                </div>
                <div class="form-group">
                    <label >Địa chỉ: </label>
                    <input type="text" class="form-control"  name="address" value="${update.userAddress}">
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

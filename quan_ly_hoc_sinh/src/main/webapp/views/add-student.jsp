<%--
  Created by IntelliJ IDEA.
  User: SOC XINH
  Date: 27/11/2023
  Time: 16:58
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
            <h1 class="text-center text-danger">Thêm mới học sinh </h1>
            <form action="<%=request.getContextPath()%>/student" method="post">
                <div class="form-group">
                    <label >Họ và Tên: </label>
                    <input type="text" class="form-control"  name="name">
                </div>
                <div class="form-group">
                    <label >Email: </label>
                    <input type="text" class="form-control"  name="email">
                </div>
                <div class="form-group">
                    <label >Birthday: </label>
                    <input type="date" class="form-control"  name="birthday">
                </div>
                <div class="form-group">
                    <label >Địa chỉ: </label>
                    <input type="text" class="form-control"  name="address">
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: SOC XINH
  Date: 30/11/2023
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center text-danger">LOGIN </h1>
            <form:form action="/post-login" method="post" modelAttribute="account">
                <div class="form-group">
                    <label>Email: </label>
                    <form:input type="text" class="form-control" name="email" path="email" />
                </div>
                <div class="form-group">
                    <label>Password: </label>
                    <form:input type="text" class="form-control" name="password" path="password"/>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

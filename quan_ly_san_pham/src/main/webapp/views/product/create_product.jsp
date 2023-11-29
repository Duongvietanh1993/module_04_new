<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SOC XINH
  Date: 28/11/2023
  Time: 17:07
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
            <h1 class="text-center text-danger">Thêm mới sản phẩm </h1>
            <form action="<%=request.getContextPath()%>/product" method="post">
                <div class="form-group">
                    <label >Tên sản phẩm: </label>
                    <input type="text" class="form-control"  name="productName">
                </div>
                <div class="form-group">
                    <label >Giá: </label>
                    <input type="text" class="form-control"  name="price">
                </div>
                <div class="form-group">
                    <label >danh mục: </label>
                    <select name="category">
                        <c:forEach items="${categoryList}" var="item">
                            <option value="${item.categoryId}">${item.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">

                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 31/07/2022
  Time: 10:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link rel="icon" href="assets/img/favicon.png"/>
    <link rel="stylesheet" href="assets/style/cart.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
          crossorigin="anonymous"/>
</head>
<body>
<div class="cart">
    <h1 class="cart-header">Your Cart</h1>
<c:if test="${petsListCart != null}">
<table border="1" width="800px" style="text-align:center">
    <tr>

        <th>Name</th>
        <th>AGE</th>
        <th>PRICE</th>
        <th>SPECIAL</th>
        <th>IMAGE</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${petsListCart}" var="p">
        <tr>

            <td>${p.getName()}</td>
            <td>${p.getAge()}</td>
            <td>${p.getPriceString()}</td>
            <td>${p.getSpecial().getName()}</td>
            <td><img style="width: 100px; height: 100px" src="${p.getImage()}" alt="${p.getImage()}"></td>
            <td><button><a style="text-decoration: none" href="/OrderServlet?action=deleteCart&id=${p.getId()}"> <i class="fa fa-trash" aria-hidden="true"></i></a></button></td>
        </tr>
    </c:forEach>
    <tr>
        <td>Total:</td>
        <td colspan="4">${totalPriceTemp}</td>
        <td><button><a style="text-decoration: none" href="/OrderServlet?action=order"><i class="fas fa-receipt"></i></a></button></td>
    </tr>
</table>
    <br>
<a class="cart-btn" style="text-decoration: none" href="/OrderServlet?action=deleteAllCart">Delete All Cart</a>
    <br>
</c:if>
<c:if test="${petsListCart == null}">
    <h3>Bạn chưa mua sản phẩm nào!</h3>
</c:if>
<br>
<a class="cart-btn"style="text-decoration: none" href="/homeCustomer.jsp">Continue Shopping</a>
</div>
</body>
</html>

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
    <title>ORDER HISTORY</title>
    <link rel="icon" href="assets/img/favicon.png"/>
    <link rel="stylesheet" href="assets/style/cart.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
          crossorigin="anonymous"/>
</head>
<body>
<div class="cart">
    <h1 class="cart-header">All Order</h1>
    <c:if test="${orders != null}">
        <table border="1" width="800px" style="text-align:center">
            <tr>
                <th>CODE</th>
                <th>CUSTOMER</th>
                <th>DATE CREATE</th>
                <th>STATUS</th>
                <th>TOTAL</th>
                <th>ACTION</th>
            </tr>
            <c:forEach items="${orders}" var="o">
                <tr>

                    <td>${o.getId()}</td>
                    <td>${o.getCustomer().getUsername()}</td>
                    <td>${o.getDateCreateOrder()}</td>
                    <td>${o.getStatus()}</td>
                    <td>${o.getTotalString()}</td>
                    <td><button><a style="text-decoration: none" href="/OrderServlet?action=deleteCart&id=${p.getId()}"> <i class="fa fa-trash" aria-hidden="true"></i></a></button></td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </c:if>
    <c:if test="${orders == null}">
        <h3>Không có đơn hàng nào!</h3>
    </c:if>
    <br>
</div>
</body>
</html>

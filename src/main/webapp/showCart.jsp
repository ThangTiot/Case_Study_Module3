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
</head>
<body>
<table border="1" width="800px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>AGE</th>
        <th>PRICE</th>
        <th>SPECIAL</th>
        <th>IMAGE</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${petsListCart}" var="p">
        <tr>
            <td>${p.getId()}</td>
            <td>${p.getName()}</td>
            <td>${p.getAge()}</td>
            <td>${p.getPriceString()}</td>
            <td>${p.getSpecial().getName()}</td>
            <td><img style="width: 100px; height: 100px" src="${p.getImage()}" alt="${p.getImage()}"></td>
            <td><button><a style="text-decoration: none" href="/OrderServlet?action=deleteCart&id=${p.getId()}">Delete</a></button></td>
        </tr>
    </c:forEach>
    <tr>
        <td>Total:</td>
        <td colspan="4">${totalPriceTemp}</td>
        <td><button><a style="text-decoration: none" href="/OrderServlet?action=order">Order</a></button></td>
        <td><button><a style="text-decoration: none" href="/OrderServlet?action=pay">Pay</a></button></td>
    </tr>
</table>
<a style="text-decoration: none" href="/OrderServlet?action=deleteAllCart">Delete All Cart</a>
<br>
<a style="text-decoration: none" href="/homeCustomer.jsp">Continue Shopping</a>
</body>
</html>

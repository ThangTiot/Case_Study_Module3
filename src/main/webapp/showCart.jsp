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
        <th>STATUS</th>
        <th colspan="3">Action</th>
    </tr>
    <c:forEach items="${petsListCart}" var="p">
        <tr>
            <td>${p.getId()}</td>
            <td>${p.getName()}</td>
            <td>${p.getAge()}</td>
            <td>${p.getPrice()}</td>
            <td>${p.getSpecial().getName()}</td>
            <td><img style="width: 100px; height: 100px" src="${p.getImage()}" alt="${p.getImage()}"></td>
            <td><button><a style="text-decoration: none" href="/OrderServlet?action=addToCart&id=${p.getId()}">AddToCart</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

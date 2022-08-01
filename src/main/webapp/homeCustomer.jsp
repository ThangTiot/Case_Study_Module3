<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 27/07/2022
  Time: 9:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home Customer</title>
</head>
<body>
<h1>Welcome Home Customer</h1>
<h1>List Product</h1>
<button style="margin-bottom: 10px"><a style="text-decoration: none" href="/OrderServlet?action=showCart">Show cart</a></button>
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
    <c:forEach items="${pets}" var="p">
        <tr style="display: ">
            <td>${p.getId()}</td>
            <td>${p.getName()}</td>
            <td>${p.getAge()}</td>
            <td>${p.getPriceString()}</td>
            <td>${p.getSpecial().getName()}</td>
            <td><img style="width: 100px; height: 100px" src="${p.getImage()}" alt="${p.getImage()}"></td>
            <td>${p.getStatus()}</td>
            <c:if test="${p.getStatus() eq 'Sold'}">
            <td><button disabled>AddToCart</button></td>
            </c:if>
            <c:if test="${p.getStatus() eq 'Available'}">
                <td><button><a style="text-decoration: none" href="/OrderServlet?action=addToCart&id=${p.getId()}">AddToCart</a></button></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>

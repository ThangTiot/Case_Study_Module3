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
    <title>Home</title>
</head>
<body>
<h1>Welcome Home</h1>
<h1>List Product</h1>
<button style="margin-bottom: 10px"><a style="text-decoration: none" href="/PetServlet?action=createPetGet">Create new product</a></button>
<button style="margin-bottom: 10px"><a style="text-decoration: none" href="/LoginServlet?action=logOut">LogOut</a></button>
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
        <tr>
            <td>${p.getId()}</td>
            <td>${p.getName()}</td>
            <td>${p.getAge()}</td>
            <td>${p.getPriceString()}</td>
            <td>${p.getSpecial().getName()}</td>
            <td><img style="width: 100px; height: 100px" src="${p.getImage()}" alt="${p.getImage()}"></td>
            <td>${p.getStatus()}</td>
            <td><button><a style="text-decoration: none" href="/PetServlet?action=updatePetGet&id=${p.getId()}">Update</a></button></td>
            <td><button><a style="text-decoration: none" href="/PetServlet?action=deletePetGet&id=${p.getId()}">Delete</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

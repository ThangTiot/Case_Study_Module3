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
    <title>Species</title>
</head>
<body>
<h1>List Species</h1>
<button style="margin-bottom: 10px"><a style="text-decoration: none" href="/PetServlet?action=creatPetSpecialGet">Create new species</a></button>
<button style="margin-bottom: 10px"><a style="text-decoration: none" href="/home.jsp">Back to CRUD Pet</a></button>
<c:if test="${createSpeciesMessage != null}">
<form action="/PetServlet?action=creatPetSpecialPost" class="form" method="post">
    <div class="form-group">
        <label class="control-label">Pet Species Name</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <input name="special" placeholder="Enter Pet Species Name" class="form-control" type="text" value="${petSpecialNameFailValue}">
            </div>
            <p style="color: red; margin: 0">${petSpecialNameFailMessage}</p>
        </div>
    </div>
    <div class="form-group">
        <label class=" control-label"></label>
        <div class="bnt">
            <button type="submit" class="btn"  style="width: 150px;height: 30px">Send
            </button>
        </div>
    </div>
</form>
</c:if>
<table border="1" width="400px">
    <tr>
        <th>ID</th>
        <th>Special Name</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${petSpecials}" var="sp">
        <tr>
            <td>${sp.getId()}</td>
            <td>${sp.getName()}</td>
            <td><button><a style="text-decoration: none" href="/PetServlet?action=deletePetSpecialGet&id=${sp.getId()}">Delete</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

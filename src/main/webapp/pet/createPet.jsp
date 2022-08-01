<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 28/07/2022
  Time: 9:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Pet</title>
</head>
<body>
<form action="/PetServlet?action=createPetPost" class="form" method="post">
    <h1> Add Pet </h1>
    <div class="form-group">
        <label class="control-label">Pet Name</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <input name="petName" placeholder="Enter Pet name" class="form-control" type="text" value="${p.getName()}">
            </div>
            <p style="color: red; margin: 0">${petNameFailMessage}</p>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label">Pet Age</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <input name="age" placeholder="Enter Pet age" class="form-control" type="text" value="${p.getAge()}">
            </div>
            <p style="color: red; margin: 0">${ageFailMessage}</p>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label">Pet Price (VND)</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <input name="price" placeholder="Enter Pet price" class="form-control" type="text">
            </div>
            <p style="color: red; margin: 0">${priceFailMessage}</p>
        </div>
    </div>
    <div class="form-group">
        <label class=" control-label">Species</label>
        <div class=" selectContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <select name="specialId" class="form-control">
                    <option value=" ">Please select your Pet Species</option>
                    <c:forEach items="${petSpecials}" var="s">
                    <option value="${s.getId()}">${s.getName()}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label">Pet Image</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <input name="image" class="form-control" type="file">
            </div>
        </div>
    </div>
    <br>
    <div class="form-group">
        <label class=" control-label"></label>
        <div class="bnt">
            <button type="submit" class="btn"  style="width: 150px;height: 30px">Send
            </button>
        </div>
    </div>
</form>
</body>
</html>

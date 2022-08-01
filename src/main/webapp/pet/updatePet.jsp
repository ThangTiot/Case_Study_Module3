<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 29/07/2022
  Time: 8:41 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Pet</title>
</head>
<body>
<form action="/PetServlet?action=updatePetPost" class="form" method="post">
    <h1> Edit Form </h1>
    <div>
        <input name="id" type="text" value="${pet.getId()}" hidden>
    </div>
    <div class="form-group">
        <label class="control-label">Pet Name</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <input name="petName" placeholder="Enter Pet name" class="form-control" type="text"
                       value="${pet.getName()}">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label">Pet Age</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <input name="age" placeholder="Enter Pet age" class="form-control" type="text" value="${pet.getAge()}">
            </div>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label">Pet Price (VND)</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <input name="price" placeholder="Enter Pet price" class="form-control" type="text"
                       value="${pet.getPrice()}">
            </div>
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
        <label class="control-label">Status</label>
        <div class="inputGroupContainer">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-paw" aria-hidden="true"></i></span>
                <select name="status" class="form-control">
                    <option value="Available">Available</option>
                    <option value="Sold">Sold</option>
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
            <button type="submit" class="btn" style="width: 150px;height: 30px">Send
            </button>
        </div>
    </div>
</form>
</body>
</html>

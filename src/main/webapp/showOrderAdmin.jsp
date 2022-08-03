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
    <link rel="stylesheet" href="assets/style/hero.css">
    <link rel="stylesheet" href="assets/style/style.css">
    <link rel="stylesheet" href="assets/style/cart.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
          crossorigin="anonymous"/>
</head>
<body>
<section class="hero_shop">
    <div class="header">
        <header class="header_header">
            <div class="header_logo">
                <a href="#">
        <span>
            <img src="assets/img/logo.png" alt="">
        </span>
                </a>
            </div>
            <div class="header_info">
                <nav class="header_nav">
                    <a class="header_nav_link" href="homePage.jsp">
                        <span>
                            <i class="fa fa-home" aria-hidden="true"></i>
                        </span>
                        Home
                    </a>
                    <a class="header_nav_link" href="#">
                        <span>
                              <i class="fas fa-clinic-medical"></i>
                        </span>
                        Services
                    </a>
                    <a class="header_nav_link" href="/PetServlet?action=default">
                        <span>
                             <i class='fas fa-shopping-bag'></i>
                        </span>
                        Shop
                    </a>
                </nav>
                <div class="user-account">
                    <div class="user-info">
                        <a id="user-name" class="user-name" style="padding-right: 10px;" href="/OrderServlet?action=showOrderHistoryAdmin">
                            <i class="fa fa-user-circle" aria-hidden="true" style="font-size: 30px"></i>
                            ADMIN</a>
                        <a href="/LoginServlet?action=logOut" class="user-name">
                            <i class="fas fa-sign-out-alt" style="font-size: 25px; padding-right: 5px;"></i>
                            Log Out
                        </a>
                    </div>
                </div>
            </div>
        </header>
<%--        <div class="hero__body__shop">--%>
<%--            <h1 class="hero__heading__shop">Online Store</h1>--%>
<%--        </div>--%>
    </div>
</section>
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
                    <c:if test="${o.getStatus() eq 'Unpaid'}">
                    <td><button><a style="text-decoration: none" href="/OrderServlet?action=deleteCart&id=${o.getId()}"> <i class="fa fa-trash" aria-hidden="true"></i></a></button></td>
                    </c:if>
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

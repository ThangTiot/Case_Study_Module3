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
    <link rel="stylesheet" href="assets/style/hero.css">
    <link rel="stylesheet" href="assets/style/style.css">
    <link rel="stylesheet" href="assets/style/test.css">
    <link rel="stylesheet" href="assets/style/footerOrder.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

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
                        <a id="user-name" class="user-name" style="padding-right: 10px;">
                            <i class="fa fa-user-circle" aria-hidden="true" style="font-size: 30px"></i>
                            ${customer.getUsername().toUpperCase()}</a>
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
    <h1 class="cart-header">Your Cart</h1>
<c:if test="${petsListCart != null}">
<table border="1" width="800px" style="text-align:center">
    <tr>

        <th>NAME</th>
        <th>AGE</th>
        <th>PRICE</th>
        <th>SPECIAL</th>
        <th>IMAGE</th>
        <th>ACTION</th>
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
        <td style="padding: 10px;">Total:</td>
        <td colspan="4">${totalPriceTemp}</td>
        <td><button><a style="text-decoration: none" href="/OrderServlet?action=order"><i class="fas fa-receipt"></i> Order Now</a></button></td>
    </tr>
</table>
    <br>
    <button>
<a class="cart-btn" style="text-decoration: none" href="/OrderServlet?action=deleteAllCart">Delete All Cart</a>
    </button>
    <br>
</c:if>
<c:if test="${petsListCart == null}">
    <h3>Bạn chưa mua sản phẩm nào!</h3>
</c:if>
<br>
    <button>
<a class="cart-btn"style="text-decoration: none" href="/homeCustomer.jsp">Continue Shopping</a></button>
</div>
<%--<footer class="footer">--%>
<%--    <div class="container container--footer">--%>

<%--        <h3 class="footer--header">Project done by Boom </h3>--%>
<%--        <!--            <img-->--%>
<%--        <!--                    src="assets/img/logo.png"-->--%>
<%--        <!--                    alt="Monticello logo"-->--%>
<%--        <!--                    class="logo__img"-->--%>
<%--        <!--            />-->--%>
<%--        <nav class="social social--footer">--%>
<%--            <ul class="social__list">--%>
<%--                <li class="social__item">--%>
<%--                    <a href="#" class="social__link"--%>
<%--                    ><i class="fab fa-facebook-f"></i--%>
<%--                    ></a>--%>
<%--                </li>--%>
<%--                <li class="social__item">--%>
<%--                    <a href="#" class="social__link"--%>
<%--                    ><i class="fab fa-twitter"></i--%>
<%--                    ></a>--%>
<%--                </li>--%>
<%--                <li class="social__item">--%>
<%--                    <a href="#" class="social__link"--%>
<%--                    ><i class="fab fa-instagram"></i--%>
<%--                    ></a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </nav>--%>

<%--    </div>--%>
<%--</footer>--%>

</body>
</html>

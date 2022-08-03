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
    <meta charset="UTF-8">
    <title>Shop</title>
    <link rel="icon" href="assets/img/favicon.png"/>
    <link rel="stylesheet" href="assets/style/hero.css">
    <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
          crossorigin="anonymous"/>
    <link rel="stylesheet" href="assets/style/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">

    <title>Shop Customer</title>
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
                    <div class="user-cart">
                        <a class="user-name" href="/OrderServlet?action=showCart">
                            <i class="fa fa-shopping-cart" aria-hidden="true" style="font-size: 30px;"></i>
                            YOUR CART</a>
                    </div>
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
        <div class="hero__body__shop">
            <h1 class="hero__heading__shop">Online Store</h1>
        </div>
    </div>
</section>
<div class="shop_container">
    <div class="categories">
        <div class="list">
            <h2 class="heading">Category List</h2>
            <form class="pet_species" method="post" action="/PetServlet?action=findPetBySpeciesPost">
                <c:forEach items="${petSpecials}" var="sp">
                    <label><input type="radio" class="choose" name="checkbox" value="${sp.getId()}">
                            ${sp.getName()}</label><br>
                </c:forEach>
                <br>
                <input type="submit" value="Search">
            </form>
        </div>
    </div>
    <div class="shopping-list">

        <c:forEach items="${pets}" var="p">
            <div class="column column-1-6" style="width: 250px; height: 425px">
                <img src="${p.getImage()}" alt="${p.getImage()}" style="width: 200px; height: 200px">
                <p class="pet_info">${p.getName()} (${p.getAge()} tuổi)</p>
                <p class="pet_info">${p.getSpecial().getName()}</p>
                <p class="pet_info">${p.getPriceString()}</p>
                <p class="pet_info">${p.getStatus()}</p>
                <br>
                <c:if test="${p.getStatus() eq 'Sold'}">
                    <button disabled style="height: 30px">Add To Cart <i class="fas fa-cart-plus"></i></button>
                </c:if>
                <c:if test="${p.getStatus() eq 'Available'}">
                    <a class="product-cart" style="text-decoration: none" href="/OrderServlet?action=addToCart&id=${p.getId()}"> Add To Cart
                        <i class="fas fa-cart-plus"></i>
                    </a>
                </c:if>
            </div>
        </c:forEach>

    </div>
</div>
</body>
</html>
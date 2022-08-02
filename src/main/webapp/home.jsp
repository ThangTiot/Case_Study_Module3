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

    <title>Shop Admin</title>
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
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </span>
                        Services
                    </a>
                    <a class="header_nav_link" href="#">
                        <span>
                            <i class="fa fa-bell" aria-hidden="true"></i>
                        </span>
                        Shop
                    </a>
                </nav>
                <div class="user-account">
                    <div class="user-info">
                        <a id="user-name" class="user-name" href="#" style="padding-right: 10px;">
                            <i class="fa fa-user-circle" aria-hidden="true" style="font-size: 30px"></i>
                            ADMIN</a>
                        <a href="#" class="user-name">
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
            <a href="/PetServlet?action=createPetGet" class="species_add"> Add new Pet </a>
            <h2 class="heading">Category List</h2>
            <a href="/PetServlet?action=creatPetSpecialGet" class="species_add"> Add new Species </a>
            <c:if test="${createSpeciesMessage != null}">
                <form action="/PetServlet?action=creatPetSpecialPost" class="form_create" method="post">
                    <label class="form-name">Pet Species Name</label>
                    <input name="special" placeholder="Enter Pet Species Name" class="form-control" type="text"
                           value="${petSpecialNameFailValue}">
                    <p style="color: red; margin: 0">${petSpecialNameFailMessage}</p>
                    <button type="submit" class="form-btn" style="width: 50px;height: 30px">Add</button>
                </form>
            </c:if>
            <form class="pet_species" method="post" action="#">
                <c:forEach items="${petSpecials}" var="sp">
                    <label><input type="checkbox" class="choose" name="checkbox" value="${sp.getId()}">
                            ${sp.getName()}</label>
                    <button><a style="text-decoration: none" href="/PetServlet?action=deletePetSpecialGet&id=${sp.getId()}">Delete</a></button><br>
                </c:forEach>
                <br>
                <input type="submit">
            </form>
        </div>
    </div>
    <div class="shopping-list">

        <div class="column column-1-6">
            <img src="https://via.placeholder.com/200x195/588CC7/E6EEF6" alt="">
            <p>Pet name</p>
            <p> price</p>
            <a href="#" class="product-cart">Add to cart</a>
            <br>
            <span class="admin_icon">
                <a href="#" class="product-edit">
         <i class="fas fa-edit"></i>
       </a>
                <a href="#" class="product-delete">
        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
        </span>
        </div>
        <div class="column column-1-6">
            <img src="https://via.placeholder.com/200x195/588CC7/E6EEF6" alt="">
            <p>Pet name</p>
            <p> price</p>
            <a href="#" class="product-cart">Add to cart</a>
            <br>
            <span class="admin_icon">
                <a href="#" class="product-edit">
         <i class="fas fa-edit"></i>
       </a>
                <a href="#" class="product-delete">
        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
        </span>
        </div>
        <div class="column column-1-6">
            <img src="https://via.placeholder.com/200x195/588CC7/E6EEF6" alt="">
            <p>Pet name</p>
            <p> price</p>
            <a href="#" class="product-cart">Add to cart</a>
            <br>
            <span class="admin_icon">
                <a href="#" class="product-edit">
         <i class="fas fa-edit"></i>
       </a>
                <a href="#" class="product-delete">
        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
        </span>
        </div>
        <div class="column column-1-6">
            <img src="https://via.placeholder.com/200x195/588CC7/E6EEF6" alt="">
            <p>Pet name</p>
            <p> price</p>
            <a href="#" class="product-cart">Add to cart</a>
            <br>
            <span class="admin_icon">
                <a href="#" class="product-edit">
         <i class="fas fa-edit"></i>
       </a>
                <a href="#" class="product-delete">
        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
        </span>
        </div>
        <div class="column column-1-6">
            <img src="https://via.placeholder.com/200x195/588CC7/E6EEF6" alt="">
            <p>Pet name</p>
            <p> price</p>
            <a href="#" class="product-cart">Add to cart</a>
            <br>
            <span class="admin_icon">
                <a href="#" class="product-edit">
         <i class="fas fa-edit"></i>
       </a>
                <a href="#" class="product-delete">
        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
        </span>
        </div>
        <div class="column column-1-6">
            <img src="https://via.placeholder.com/200x195/588CC7/E6EEF6" alt="">
            <p>Pet name</p>
            <p> price</p>
            <a href="#" class="product-cart">Add to cart</a>
            <br>
            <span class="admin_icon">
                <a href="#" class="product-edit">
         <i class="fas fa-edit"></i>
       </a>
                <a href="#" class="product-delete">
        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
        </span>
        </div>

    </div>
</div>
</body>
</html>

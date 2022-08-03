<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doraemon Phan Dien</title>
    <link rel="icon" href="assets/img/favicon.png"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <link rel="stylesheet" href="assets/style/style.css">
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">--%>
    <link rel="stylesheet" href="assets/style/hero.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
          crossorigin="anonymous"/>
    <link rel="stylesheet" href="assets/style/services.css">
    <link rel="stylesheet" href="assets/style/member.css">
    <link rel="stylesheet" href="assets/style/product.css">
    <link rel="stylesheet" href="assets/style/contact.scss">
    <link rel="stylesheet" href="assets/style/footer.css">
    <!-- Add the slick-theme.css if you want default styling -->
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <!-- Add the slick-theme.css if you want default styling -->
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>
</head>
<body>
<!-- Menu -->
<section class="hero">
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
                    <a class="header_nav_link" href="#">
                        <span>
                            <i class="fa fa-home" aria-hidden="true"></i>
                        </span>
                        Home
                    </a>
                    <a class="header_nav_link" href="#service">
                        <span>
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </span>
                        Services
                    </a>
                    <c:if test="${admin != null}">
                        <a class="header_nav_link" href="home.jsp">
                        <span>
                            <i class="fa fa-bell" aria-hidden="true"></i>
                        </span>
                            Shop
                        </a>
                    </c:if>
                    <c:if test="${customer != null}">
                        <a class="header_nav_link" href="homeCustomer.jsp">
                        <span>
                            <i class="fa fa-bell" aria-hidden="true"></i>
                        </span>
                            Shop
                        </a>
                    </c:if>
<%--                    <a class="header_nav_link" href="home.jsp">--%>
<%--                        <span>--%>
<%--                            <i class="fa fa-bell" aria-hidden="true"></i>--%>
<%--                        </span>--%>
<%--                        Shop--%>
<%--                    </a>--%>
                    <a class="header_nav_link" href="#contact"><span>
                <i class="fa fa-venus-mars" aria-hidden="true"></i>
            </span>
                        Contacts</a>

                </nav>
                <div class="user-account">
                    <div class="user-info">
                        <c:if test="${admin != null}">
                        <a id="user-name" class="user-name" style="padding-right: 10px;">
                            <i class="fa fa-user-circle" aria-hidden="true" style="font-size: 30px"></i>
                            ADMIN</a>
                        </c:if>
                        <c:if test="${customer != null}">
                            <a id="user-name" class="user-name" style="padding-right: 10px;">
                                <i class="fa fa-user-circle" aria-hidden="true" style="font-size: 30px"></i>
                                ${customer.getUsername().toUpperCase()}</a>
                        </c:if>
                        <a href="/LoginServlet?action=logOut" class="user-name" >
                            <i class="fas fa-sign-out-alt" style="font-size: 25px; padding-right: 5px;"></i>
                            Log Out
                        </a>
                    </div>
                </div>

            </div>
        </header>
        <div class="hero__body">
            <h1 class="hero__heading">We care about your pets</h1>
            <p class="hero__subheading">
                We make the world's beautiful every day
            </p>
        </div>
        <a href="#" class="scroll-down"></a>
    </div>
</section>
<!--Main content -->
<section class="we-offer-area text-center bg-gray" id="service">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="site-heading text-center">
                    <h2>What we <span>Offer</span></h2>
                    <h4>Lorem Ipsum is simply dummy text</h4>
                </div>
            </div>
        </div>
        <div class="row our-offer-items less-carousel">
            <!-- Single Item -->
            <div class="col-md-4 col-sm-6 equal-height">
                <div class="item">
                    <i class="fas fa-dog"></i>
                    <h4>Dog Grooming</h4>
                    <p>
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                    </p>
                </div>
            </div>
            <!-- End Single Item -->

            <!-- Single Item -->
            <div class="col-md-4 col-sm-6 equal-height">
                <div class="item">
                    <i class="fas fa-paw"></i>
                    <h4>Dog Training</h4>
                    <p>
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                    </p>
                </div>
            </div>
            <!-- End Single Item -->

            <!-- Single Item -->
            <div class="col-md-4 col-sm-6 equal-height">
                <div class="item">
                    <i class="fas fa-bone"></i>
                    <h4>Vet Service</h4>
                    <p>
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                    </p>
                </div>
            </div>
            <!-- End Single Item -->



        </div>
    </div>
</section>
<!--Product Preview-->
<section id="product" class="product-area">
    <div class="product-button">
        <h2 style="font-size: 40px">Online Store</h2>
        <p>Discover our online pet shop and find interesting stuff for pet!</p>
<%--        <c:if test="${admin != null}">--%>
<%--            <a class="btn btn-success" href="home.jsp">--%>
<%--              Visit our Shop--%>
<%--            </a>--%>
<%--        </c:if>--%>
<%--        <c:if test="${customer != null}">--%>
<%--            <a class="btn btn-success" href="homeCustomer.jsp">Visit our Shop--%>
<%--            </a>--%>
<%--        </c:if>--%>
        <a href="#" class="btn btn-success">Visit our Shop</a>
    </div>
    <div class="listing-section">
        <div class="product">
            <div class="image-box" >
                <!--                <div class="images" id="image-1"></div>-->
                <img class="image-pet" src="image/husky1.jpg" alt="">
            </div>
            <div class="text-box">
                <h2 class="item">dog</h2>
                <h3 class="price">$4.99</h3>
                <p class="description">Lorem ipsum dolor sit.!</p>
            </div>
        </div>
        <div class="product">
            <div class="image-box">
                <!--                <div class="images" id="image-4"></div>-->
                <img class="image-pet"src="image/alaska1.jpg" alt="">

            </div>
            <div class="text-box">
                <h2 class="item">Lorem.</h2>
                <h3 class="price">$4.99</h3>
                <p class="description">Lorem ipsum dolor sit.</p>
            </div>
        </div>
        <div class="product">
            <div class="image-box">
                <!--                <div class="images" id="image-5"></div>-->
                <img class="image-pet"src="image/alaska2.jpg" alt="">

            </div>
            <div class="text-box">
                <h2 class="item">Husky</h2>
                <h3 class="price">$4.99</h3>
                <p class="description">Lorem ipsum dolor sit.!</p>
            </div>
        </div>
        <div class="product">
            <div class="image-box">
                <!--                <div class="images" id="image-2">-->
                <!--                    -->
                <!--                </div>-->
                <img class="image-pet" src="image/bulldog1.jpg" alt="">
            </div>
            <div class="text-box">
                <h2 class="item">dog</h2>
                <h3 class="price">$4.99</h3>
                <p class="description">Lorem ipsum dolor sit.!</p>
            </div>
        </div>
        <div class="product">
            <div class="image-box">
                <!--                <div class="images" id="image-3"></div>-->
                <img  class="image-pet"src="image/bulldog2.jpg" alt="">

            </div>
            <div class="text-box">
                <h2 class="item">cat</h2>
                <h3 class="price">$4.99</h3>
                <p class="description">Lorem ipsum dolor sit amet.</p>
            </div>
        </div>
    </div>


</section>
<!--Members-->
<section id="team" class="team-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="site-heading text-center">
                    <h2>Our <span>Team</span></h2>
                    <h4>Meet our awesome and expert team members</h4>
                </div>
            </div>
        </div>
        <div class="row team-items">
            <div class="col-md-4 single-item">
                <div class="item">
                    <div class="thumb">
                        <img class="img-fluid" src="assets/img/member/thang.jpeg" alt="Thumb">
                        <div class="overlay">
                            <h4>Lorem Ipsum</h4>
                            <p>
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                            </p>
                            <div class="social">
                                <ul>
                                    <li class="twitter">
                                        <a href="#"><i class="fab fa-twitter"></i></a>
                                    </li>
                                    <li class="pinterest">
                                        <a href="#"><i class="fab fa-pinterest"></i></a>
                                    </li>
                                    <li class="instagram">
                                        <a href="#"><i class="fab fa-instagram"></i></a>
                                    </li>
                                    <li class="vimeo">
                                        <a href="#"><i class="fab fa-vimeo-v"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="info">
                                <span class="message">
                                    <a href="#"><i class="fas fa-envelope-open"></i></a>
                                </span>
                        <h4>Thắng Tiot</h4>
                        <span>Project Manager</span>
                    </div>
                </div>
            </div>
            <div class="col-md-4 single-item">
                <div class="item">
                    <div class="thumb">
                        <img class="img-fluid" src="assets/img/member/anhlv.png" alt="Thumb">
                        <div class="overlay">
                            <h4>Lorem Ipsum</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing.
                            </p>
                            <div class="social">
                                <ul>
                                    <li class="twitter">
                                        <a href="#"><i class="fab fa-twitter"></i></a>
                                    </li>
                                    <li class="pinterest">
                                        <a href="#"><i class="fab fa-pinterest"></i></a>
                                    </li>
                                    <li class="instagram">
                                        <a href="#"><i class="fab fa-instagram"></i></a>
                                    </li>
                                    <li class="vimeo">
                                        <a href="#"><i class="fab fa-vimeo-v"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="info">
                                <span class="message">
                                    <a href="#"><i class="fas fa-envelope-open"></i></a>
                                </span>
                        <h4>Anh LV</h4>
                        <span>Cục Tạ №1</span>
                    </div>
                </div>
            </div>
            <div class="col-md-4 single-item">
                <div class="item">
                    <div class="thumb">
                        <img class="img-fluid" src="assets/img/member/phuong.jpeg" alt="Thumb">
                        <div class="overlay">
                            <h4>Lorem Ipsum</h4>
                            <p>
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                            </p>
                            <div class="social">
                                <ul>
                                    <li class="twitter">
                                        <a href="#"><i class="fab fa-twitter"></i></a>
                                    </li>
                                    <li class="pinterest">
                                        <a href="#"><i class="fab fa-pinterest"></i></a>
                                    </li>
                                    <li class="instagram">
                                        <a href="#"><i class="fab fa-instagram"></i></a>
                                    </li>
                                    <li class="vimeo">
                                        <a href="#"><i class="fab fa-vimeo-v"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="info">
                                <span class="message">
                                    <a href="#"><i class="fas fa-envelope-open"></i></a>
                                </span>
                        <h4>Phương Tạ</h4>
                        <span>Cục Tạ №2</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="contact" id="contact">
    <div class="map_container"></div>
</section>
<footer class="footer">
    <div class="container container--footer">

            <h3 class="footer--header">Project done by Boom </h3>
            <!--            <img-->
            <!--                    src="assets/img/logo.png"-->
            <!--                    alt="Monticello logo"-->
            <!--                    class="logo__img"-->
            <!--            />-->
        <nav class="social social--footer">
            <ul class="social__list">
                <li class="social__item">
                    <a href="#" class="social__link"
                    ><i class="fab fa-facebook-f"></i
                    ></a>
                </li>
                <li class="social__item">
                    <a href="#" class="social__link"
                    ><i class="fab fa-twitter"></i
                    ></a>
                </li>
                <li class="social__item">
                    <a href="#" class="social__link"
                    ><i class="fab fa-instagram"></i
                    ></a>
                </li>
            </ul>
        </nav>

    </div>
</footer>
<script src="assets/libs/jquery/jquery-3.3.1.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDAjHnCoxW-v8nLxS40ktg3RaCLuAXEGUg"></script>
<!-- jQuery Plugins -->
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="assets/js/slicker.js"></script>
<script src="assets/js/maps.js"></script>



</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 27/07/2022
  Time: 10:01 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/SignIn_SignUp.css">
    <title>LogIn</title>
</head>
<body>
<c:if test="${messageSignUp != null}">
<form action="/LoginServlet?action=signIn" method="post" style="display: none">
    </c:if>
    <form action="/LoginServlet?action=signIn" method="post">
        <div class="popup" id="popup-1">
            <div class="content" id="signIn">
                <h1 style="padding-bottom: 35px">Sign In</h1>
                <div class="input-field"><input type="text" id="usrName" name="usrName" placeholder="Email"
                                                class="validate" value="${userName}">
                </div>
                <div class="input-field"><input type="password" id="psw" name="psw" placeholder="Password"
                                                class="validate" value="${password}">
                </div>
                <p style="color: red; margin: 0">${failMassage}</p>
                <div class="button">
                    <button class="first-button" id="firstBtn" type="submit">Sign In</button>
                    <button id="sndBtn" class="first-button"><a style="text-decoration: none; font-weight: normal"
                                                                href="/LoginServlet?action=signUp">Sign Up</a></button>
                </div>
            </div>
        </div>
    </form>
    <c:if test="${messageSignUp != null}">
    <form action="/LoginServlet?action=signUp" method="post">
        </c:if>
        <form action="/LoginServlet?action=signUp" method="post" style="display: none">
            <div id="signUp" class="modal">
                <div class="popup-container">
                    <div class="popup-text">
                        <h1 style="margin-bottom: -10px">Sign Up</h1>
                        <p style="font-size: 15px; padding: 10px 0 0 0;">Please fill in this form to create an
                            account.</p>
                    </div>
                    <label class="popup-label"><b>Username</b>
                        <input class="label-input" type="text" placeholder="Enter Username" name="username"
                               id="userName" required value="${c.getUsername()}">
                    </label>
                    <p class="message" style="color: red; margin: -6px 0 8px 6px">${userNameMessage}</p>
                    <label class="popup-label"><b>Password</b>
                        <input class="label-input" type="password" placeholder="Enter Password" id="psw-create"
                               name="psw" required value="${c.getPass()}">
                    </label>
                    <p class="message" style="color: red; margin: -6px 0 8px 6px">${passwordMessage}</p>
                    <label class="popup-label"><b>Repeat Password</b>
                        <input class="label-input" type="password" placeholder="Repeat Password" id="repeat-psw"
                               name="psw-repeat" required value="${passwordRepeat}">
                    </label>
                    <p class="message" style="color: red; margin: -6px 0 8px 6px">${passwordRepeatMessage}</p>
                    <label class="popup-label"><b>Phone Number</b>
                        <input class="label-input" type="text" placeholder="0987xxx" id="phone"
                               name="phone" required value="${c.getPhone()}">
                    </label>
                    <p class="message" style="color: red; margin: -6px 0 8px 6px">${phoneMessage}</p>
                    <label class="popup-label"><b>Email</b>
                        <input class="label-input" type="text" placeholder="example@gmail.com" id="email"
                               name="email" required value="${c.getMail()}">
                    </label>
                    <p class="message" style="color: red; margin: -6px 0 8px 6px">${emailMessage}</p>
                    <label class="popup-label"><b>Address</b>
                        <input class="label-input" type="text" id="address"
                               name="address" required value="${c.getAddress()}">
                    </label>
                    <div class="clearfix">
                        <button class="signupBtn" type="submit">Sign Up</button>
                    </div>
                </div>
            </div>
        </form>
</body>
</html>

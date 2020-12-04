<%-- 
    Document   : updateActor
    Created on : Jul 5, 2020, 3:37:14 PM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Actor</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body style="background-image: url(images/background.png);background-size: cover">
        <h1>Update Actor's Profile</h1>
        <form action="MainController" method="POST">
            ID:<input type="text" name="txtId" value="${requestScope.DTO.id}" readonly="true"/>
            <font color="red">
            ${requestScope.INVALID.idError}
            </font><br/>
            Password:<input type="password" name="txtPassword"/>
            <font color="red">
            ${requestScope.INVALID.passwordError}
            </font><br/>
            Confirm:<input type="password" name="txtConfirm"/>
            <font color="red">
            ${requestScope.INVALID.confirmError}
            </font><br/>
            Fullname:<input type="text" name="txtFullname" value="${requestScope.DTO.fullname}"/>
            <font color="red">
            ${requestScope.INVALID.fullnameError}
            </font><br/>
            Image:<input type="text" name="txtImage" value="${requestScope.DTO.image}"/>
            <font color="red">
            ${requestScope.INVALID.imageError}
            </font><br/>
            Description:<input type="text" name="txtDescription" value="${requestScope.DTO.description}"/>
            <font color="red">
            ${requestScope.INVALID.descriptionError}
            </font><br/>
            Phone:<input type="text" name="txtPhone" value="${requestScope.DTO.phone}"/>
            <font color="red">
            ${requestScope.INVALID.phoneError}
            </font><br/>
            Email:<input type="text" name="txtEmail" value="${requestScope.DTO.email}"/>
            <font color="red">
            ${requestScope.INVALID.emailError}
            </font><br/>
            <input type="submit" name="action" value="Update Actor"/>
            <input type="hidden" name="txtSearch" value=""/>
            <input type="hidden" name="txtRole" value="${sessionScope.ROLE}"/>
        </form>
        <c:url var="viewActorLink" value="MainController">
            <c:param name="txtSearch" value=""/>
            <c:param name="action" value="Search Actor"/>
        </c:url>
            <a href="${viewActorLink}" style="background-color: white">Return</a>
    </body>
</html>

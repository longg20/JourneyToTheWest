<%-- 
    Document   : admin
    Created on : Jul 3, 2020, 11:31:15 AM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
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
        <h1>Welcome, ${sessionScope.FULLNAME}</h1>
        <table border="0">
            <tbody>
                <tr>
                    <td>ID:</td>
                    <td>${sessionScope.ID}</td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td>${sessionScope.FULLNAME}</td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td>${sessionScope.DESCRIPTION}</td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td>${sessionScope.PHONE}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${sessionScope.EMAIL}</td>
                </tr>
                <tr>
                    <td>Role:</td>
                    <td>${sessionScope.ROLE}</td>
                </tr>
                <tr>
                    <td>Image:</td>
                    <td><img src="${sessionScope.IMAGE}" height="200" width="150"></td>
                </tr>
            </tbody>
        </table><br/>
        <br/>
        
        <c:url var="viewCalamityLink" value="/MainController">
            <c:param name="txtSearch" value=""/>
            <c:param name="action" value="Search Calamity"/>
        </c:url>
        <a href="${viewCalamityLink}" style="background-color: white">View all Calamities</a><br/>
        
        <c:url var="viewPropLink" value="/MainController">
            <c:param name="action" value="Search Prop"/>
            <c:param name="txtSearch" value=""/>
        </c:url>
        <a href="${viewPropLink}" style="background-color: white">View all Props</a><br/>
        
        <c:url var="viewActorLink" value="/MainController">
            <c:param name="action" value="Search Actor"/>
            <c:param name="txtSearch" value=""/>
        </c:url>
        <a href="${viewActorLink}" style="background-color: white">View all Actors</a><br/><br/>
        
        <c:url var="logoutLink" value="/MainController">
            <c:param name="action" value="Log Out"/>
        </c:url>
        <a href="${logoutLink}" style="background-color: white">Log Out</a><br/>
    </body>
</html>

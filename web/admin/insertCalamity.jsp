<%-- 
    Document   : insertCalamity
    Created on : Jul 3, 2020, 4:32:50 PM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert new Calamity</title>
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
        <h1>Insert new Calamity</h1>
        <form action="MainController" method="POST">
            ID:<input type="text" name="txtId" value="${param.txtId}"/>
            <font color="red">
            ${requestScope.INVALID.idError}
            </font><br/>
            Name:<input type="text" name="txtName" value="${param.txtName}"/>
            <font color="red">
            ${requestScope.INVALID.nameError}
            </font><br/>
            Description:<input type="text" name="txtDescription" value="${param.txtDescription}"/>
            <font color="red">
            ${requestScope.INVALID.descriptionError}
            </font><br/>
            Location:<input type="text" name="txtLocation" value="${param.txtLocation}"/>
            <font color="red">
            ${requestScope.INVALID.locationError}
            </font><br/>
            Start Time:<input type="datetime-local" name="txtStartTime"/>
            <font color="red">
            ${requestScope.INVALID.startTimeError}
            </font><br/>
            End Time:<input type="datetime-local" name="txtEndTime"/>
            <font color="red">
            ${requestScope.INVALID.endTimeError}
            </font><br/>
            Time Shooting:<input type="number" name="txtTimeShooting" value="0"/>
            <font color="red">
            ${requestScope.INVALID.timeShootingError}
            </font><br/>
            <input type="hidden" name="txtSearch" value=""/>
            <input type="submit" name="action" value="Insert Calamity"/><br/>
        </form>
            
            <c:url var="viewCalamityLink" value="MainController">
                <c:param name="txtSearch" value=""/>
                <c:param name="action" value="Search Calamity"/>
            </c:url>
            <a href="${viewCalamityLink}" style="background-color: white">Return</a><br/>
    </body>
</html>

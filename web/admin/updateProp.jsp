<%-- 
    Document   : updateProp
    Created on : Jul 5, 2020, 5:31:52 PM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Prop</title>
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
        <h1>Update Prop</h1>
        <form action="MainController" method="POST">
            ID:<input type="text" name="txtId" value="${requestScope.PROP.id}" readonly="true"/>
            <font color="red">
            ${requestScope.INVALID.idError}
            </font><br/>
            Name:<input type="text" name="txtName" value="${requestScope.PROP.name}"/>
            <font color="red">
            ${requestScope.INVALID.nameError}
            </font><br/>
            Description:<input type="text" name="txtDescription" value="${requestScope.PROP.description}"/>
            <font color="red">
            ${requestScope.INVALID.descriptionError}
            </font><br/>
            Image:<input type="text" name="txtImage" value="${requestScope.PROP.image}"/>
            <font color="red">
            ${requestScope.INVALID.imageError}
            </font><br/>
            Amount:<input type="number" name="txtAmount" value="${requestScope.PROP.amount}"/>
            <font color="red">
            ${requestScope.INVALID.amountError}
            </font><br/>
            Status:<input type="text" name="txtStatus" value="${requestScope.PROP.status}"/>
            <font color="red">
            ${requestScope.INVALID.statusError}
            </font><br/>
            <input type="submit" name="action" value="Update Prop"/>
            <input type="hidden" name="txtSearch" value=""/>
        </form>
            
        <c:url var="viewPropLink" value="MainController">
            <c:param name="txtSearch" value=""/>
            <c:param name="action" value="Search Prop"/>
        </c:url>
            <a href="${viewPropLink}" style="background-color: white">Return</a>
    </body>
</html>

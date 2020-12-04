<%-- 
    Document   : actor
    Created on : Jul 3, 2020, 11:31:26 AM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actor Page</title>
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

        <c:url var="viewCalamityLink" value="/MainController">
            <c:param name="view" value="all"/>
            <c:param name="action" value="View Calamity"/>
        </c:url>
        <a href="${viewCalamityLink}" style="background-color: white">View all Calamities</a><br/>
        
        <c:url var="logoutLink" value="MainController">
            <c:param name="action" value="Log Out"/>
        </c:url>
        <a href="${logoutLink}" style="background-color: white">Log Out</a><br/><br/>
        
        <c:if test="${sessionScope.EDIT != null}">
            <c:if test="${not empty sessionScope.EDIT}">
                <font color="red">
                    Notification:
                </font> 
                <table border="1" style="background-color: white">
                    <thead>
                        <tr>
                            <th>Your Info was Updated by Admin at:</th>
                            <th>Confirm</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.EDIT}" var="edit">
                        <tr>
                            <td>${edit.time}</td>
                            <td>
                                <c:url var="confirmLink" value="MainController">
                                    <c:param name="id" value="${sessionScope.ID}"/>
                                    <c:param name="date" value="${edit.time}"/>
                                    <c:param name="action" value="Confirm Edit"/>
                                </c:url>
                                <a href="${confirmLink}">OK</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>
    </body>
</html>

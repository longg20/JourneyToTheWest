<%-- 
    Document   : viewCalamityDetail
    Created on : Jul 15, 2020, 9:41:47 AM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Calamity Detail</title>
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
        <h1>${requestScope.ID}'s Detail</h1>
        <table border="1" style="background-color: white">
            <tbody>
                <tr>
                    <td>ID</td>
                    <td>${requestScope.ID}</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>${requestScope.NAME}</td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td>${requestScope.DESCRIPTION}</td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td>${requestScope.LOCATION}</td>
                </tr>
                <tr>
                    <td>Start Time</td>
                    <td>${requestScope.STARTTIME}</td>
                </tr>
                <tr>
                    <td>End Time</td>
                    <td>${requestScope.ENDTIME}</td>
                </tr>
                <tr>
                    <td>Time Shooting</td>
                    <td>${requestScope.TIMESHOOTING}</td>
                </tr>
                <tr>
                    <td>Props Used</td>
                    <td>
                        <c:forEach items="${requestScope.PROPS}" var="prop">
                            ${prop.quantity} ${prop.name}<br/>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>Actor's Role</td>
                    <td>
                        <c:forEach items="${requestScope.ROLES}" var="role">
                            ${role.fullname} - ${role.roleName}<br/>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>File</td>
                    <td>
                        <c:url var="downloadLink" value="MainController">
                            <c:param name="id" value="${requestScope.ID}"/>
                            <c:param name="filepath" value="${requestScope.FILE}"/>
                            <c:param name="action" value="Download"/>
                        </c:url>
                        <a href="${downloadLink}">Click here to Download</a>
                    </td>
                </tr>
            </tbody>
        </table><br/>
        
        <c:url var="viewCalamityLink" value="MainController">
            <c:param name="view" value="all"/>
            <c:param name="action" value="View Calamity"/>
        </c:url>
        <a href="${viewCalamityLink}" style="background-color: white">Return</a><br/>
    </body>
</html>

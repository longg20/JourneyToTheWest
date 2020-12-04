<%-- 
    Document   : addActor
    Created on : Jul 9, 2020, 9:49:08 AM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Actor</title>
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
        <h1>
            ${requestScope.ID}'s Actor Cart
        </h1>
        <table border="1" style="background-color: white">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Actor</th>
                    <th>Role</th>
                    <th>Role Description</th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach items="${sessionScope.actorCart.getCart().values()}" var="actor">
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${actor.id}</td>
                            <td>${actor.fullname}</td>
                            <td>${actor.roleName}</td>
                            <td><input type="text" name="txtRoleDescriptionNew" value="${actor.roleDescription}"/></td>
                            <td>
                                <input type="hidden" name="cid" value="${requestScope.ID}"/>
                                <input type="hidden" name="aid" value="${actor.id}"/>
                                <input type="hidden" name="txtRoleName" value="${actor.roleName}"/>
                                <input type="hidden" name="txtRoleDescription" value="${actor.roleDescription}"/>
                                <input type="submit" name="action" value="Update Description"/>
                                <input type="submit" name="action" value="Delete Role"/>
                            </td>
                        </tr>
                    </form>
                    </c:forEach>
            </tbody>
        </table>
        <font color="red">
            ${requestScope.INVALID.duplicateError}
        </font><br/>
        
        <form action="MainController" method="POST">
            Choose Actor to add:
            <select name="actorList">
                <c:if test="${not empty sessionScope.INFO}" var="checkList">
                    <c:forEach var="actor" items="${sessionScope.INFO}">
                        <option value="${actor.id}">${actor.fullname}</option>
                    </c:forEach>
                </c:if>
                <c:if test="${!checkList}">
                    <font color="red">
                        No actors found.
                    </font>
                </c:if>
            </select><br/>
            Role Name:<input type="text" name="txtRoleName"/>
            <font color="red">
                ${requestScope.INVALID.roleNameError}
            </font><br/>
            Role Description:<input type="text" name="txtRoleDescription"/>
            <font color="red">
                ${requestScope.INVALID.roleDescriptionError}
            </font><br/>
            <input type="hidden" name="id" value="${requestScope.ID}"/>
            <input type="submit" name="action" value="Add to Actor Cart"/>
        </form>
       
        <form action="MainController" method="POST">
            <input type="hidden" name="id" value="${requestScope.ID}"/>
            <input type="submit" name="action" value="Confirm Add Role to Calamity"/>
        </form>
        <c:url var="viewCalamityDetailLink" value="MainController">
            <c:param name="id" value="${requestScope.ID}"/>
            <c:param name="action" value="View Calamity Detail"/>
       </c:url>
        <a href="${viewCalamityDetailLink}" style="background-color: white">Return</a>
    </body>
</html>

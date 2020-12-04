<%-- 
    Document   : addProp
    Created on : Jul 9, 2020, 9:49:08 AM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Props</title>
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
            ${requestScope.ID}'s Prop Cart
        </h1>
        <table border="1" style="background-color: white">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Amount in Warehouse</th>
                    <th>Amount in Use</th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach items="${sessionScope.propCart.getCart().values()}" var="prop">
                    <form action="MainController" method="POST">
                        <tr>
                            <td>${prop.id}</td>
                            <td>${prop.name}</td>
                            <td>${prop.amount}</td>
                            <td><input type="number" name="txtQuantity" value="${prop.quantity}"</td>
                            <td>
                                <input type="hidden" name="cid" value="${requestScope.ID}"/>
                                <input type="hidden" name="pid" value="${prop.id}"/>
                                <input type="submit" name="action" value="Update"/>
                                <input type="submit" name="action" value="Delete"/>
                            </td>
                        </tr>
                    </form>
                    </c:forEach>
            </tbody>
        </table><br/>
        
        <form action="MainController" method="POST">
            Choose Prop to add:
            <select name="propList">
                <c:if test="${not empty sessionScope.INFO}" var="checkList">
                    <c:forEach var="prop" items="${sessionScope.INFO}">
                        <option value="${prop.id}">${prop.name}</option>
                    </c:forEach>
                </c:if>
                <c:if test="${!checkList}">
                    <font color="red">
                        No props found.
                    </font>
                </c:if>
            </select><br/>
            Quantity:<input type="number" name="txtQuantity" value="1"/><br/>
            <font color="red">
                ${requestScope.INVALID.quantityError}
                ${requestScope.INVALID.exceedError}
            </font>
            <input type="hidden" name="id" value="${requestScope.ID}"/>
            <input type="submit" name="action" value="Add to Prop Cart"/>
        </form>
       
        <form action="MainController" method="POST">
            <input type="hidden" name="id" value="${requestScope.ID}"/>
            <input type="submit" name="action" value="Confirm Add to Calamity"/>
        </form>
        <c:url var="viewCalamityDetailLink" value="MainController">
            <c:param name="id" value="${requestScope.ID}"/>
            <c:param name="action" value="View Calamity Detail"/>
       </c:url>
        <a href="${viewCalamityDetailLink}" style="background-color: white">Return</a>
    </body>
</html>

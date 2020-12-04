<%-- 
    Document   : viewCalamity
    Created on : Jul 15, 2020, 8:47:18 AM
    Author     : Long
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Calamity</title>
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
        <h1>Calamities List</h1>
        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <br/>
                        <c:url var="viewFinishedLink" value="MainController">
                            <c:param name="action" value="View Finished Calamities"/>
                            <c:param name="view" value="finished"/>
                        </c:url>
                        <a href="${viewFinishedLink}" style="background-color: white">View Finished Calamities</a><br/><br/>

                        <c:url var="viewOngoingLink" value="MainController">
                            <c:param name="action" value="View Ongoing Calamities"/>
                            <c:param name="view" value="ongoing"/>
                        </c:url>
                        <a href="${viewOngoingLink}" style="background-color: white">View Ongoing Calamities</a><br/><br/>

                        <c:url var="viewUpcomingLink" value="MainController">
                            <c:param name="action" value="View Upcoming Calamities"/>
                            <c:param name="view" value="upcoming"/>
                        </c:url>
                        <a href="${viewUpcomingLink}" style="background-color: white">View Upcoming Calamities</a><br/><br/>

                        <c:url var="viewCalamityLink" value="/MainController">
                            <c:param name="view" value="all"/>
                            <c:param name="action" value="View Calamity"/>
                        </c:url>
                        <a href="${viewCalamityLink}" style="background-color: white">View all Calamities</a><br/><br/>

                        <c:if test="${not empty requestScope.INFO}" var="checkList">
                            <table border="1" style="background-color: white">
                                <thead>
                                    <tr class="table100-head">
                                        <th class="column1">No.</th>
                                        <th class="column2">ID</th>
                                        <th class="column3">Name</th>
                                        <th class="column4">Description</th>
                                        <th class="column5">Location</th>
                                        <th class="column6">Start Time</th>
                                        <th class="column1">End Time</th>
                                        <th class="column2">Times Shooting</th>
                                        <th class="column3">View Detail</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="calamity" items="${requestScope.INFO}" varStatus="counter">
                                        <tr class="table100-head">
                                            <td class="column1">${counter.count}</td>
                                            <td class="column2">${calamity.id}</td>
                                            <td class="column3">${calamity.name}</td>
                                            <td class="column4">${calamity.description}</td>
                                            <td class="column5">${calamity.location}</td>
                                            <td class="column6">${calamity.startTime}</td>
                                            <td class="column1">${calamity.endTime}</td>
                                            <td class="column2">${calamity.timeShooting}</td>
                                            <td class="column3">
                                                <c:url var="viewCalamityDetailLink" value="MainController">
                                                    <c:param name="id" value="${calamity.id}"/>
                                                    <c:param name="action" value="View Calamity Detail By User"/>
                                                </c:url>
                                                <a href="${viewCalamityDetailLink}">View Detail</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${!checkList}">
            <font color="red">
            No records found.
            </font>
        </c:if>

        <br/>
        <c:url var="returnLink" value="MainController">
            <c:param name="action" value="Return"/>
        </c:url>
        <a href="${returnLink}" style="background-color: white">Return</a>
        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>

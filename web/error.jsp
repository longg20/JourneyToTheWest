<%-- 
    Document   : error
    Created on : Jul 3, 2020, 11:31:31 AM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body style="background-image: url(images/background.png);background-size: cover">
        <h1>Error Page</h1>
        <h2>
            <font color="red">
            ${requestScope.ERROR}
            </font>
            <br/>
            <a href="index.jsp">Back to Login Page</a>
        </h2>
    </body>
</html>

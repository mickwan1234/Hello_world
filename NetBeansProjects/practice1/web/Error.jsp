<%-- 
    Document   : Error
    Created on : Feb 11, 2019, 11:09:12 AM
    Author     : mickw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR PAGE</h1>
        </br>
        <% String error =  request.getParameter("ERROR");%>
        <h1 style="color: red"><%= error%></h1>
        <a href='index.jsp'>Return to Login Page</a>
    </body>
</html>

<%-- 
    Document   : index
    Created on : Jan 17, 2019, 12:36:14 PM
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
        <h1>Login Page</h1>
        <form action="MainController" method ="POST">
            Username: <input type="text" name="txtUsername"/>
            <br/>
            Password: <input type="password" name="txtPassword"/>
            <br/>
            <input type="submit" name="action" value="Login"/>
        </form>
        <a href="insert.jsp">Create new account</a>
    </body>
</html>

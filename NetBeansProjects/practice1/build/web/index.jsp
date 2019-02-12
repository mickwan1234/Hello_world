<%-- 
    Document   : index
    Created on : Feb 6, 2019, 3:01:18 PM
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
        <h1>Login Pane</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername">
            </br>
            Password: <input type="password" name="txtPassword">
            </br>
            <input type="submit" name="action" value="Login"/>
            </br>
            <a href ="RegistrationInterface.jsp">Create new account</a>
        </form>
    </body>
</html>

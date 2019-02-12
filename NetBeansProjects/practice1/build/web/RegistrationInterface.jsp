<%-- 
    Document   : RegistrationInterface
    Created on : Feb 8, 2019, 3:40:58 PM
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
        <h1>Registration Page</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername"/>
            </br>
            Password: <input type="password" name ="txtPassword"/>
            </br>
            Full name: <input type="text" name ="txtFullname"/>
            </br>
            Role: <select name="cboRole">
                <option>User</option>
                <option>Admin</option>
            </select>
            <input type="submit" name="action" value="Registry"/>
        </form>
    </body>
</html>

<%-- 
    Document   : insert
    Created on : Jan 22, 2019, 1:29:29 PM
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
        <h1>Register</h1>
        <form action="MainController" method="POST">
            Username: <input type="text" name="txtUsername"/>
            <br/>
            Password: <input type="password" name ="txtPassword"/>
            <br/>
            Fullname: <input type="text" name="txtFullname"/>
            <br/>
            Role: <select name="cboRole">
                <option>admin</option>
                <option>user</option>
            </select>
            <br/>
            <input type="submit" name="action" value="Register"/>
        </form>
    </body>
</html>

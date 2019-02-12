<%-- 
    Document   : index
    Created on : Jan 22, 2019, 3:00:37 PM
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
        <h1 style="color: red; align-content: center">RAM's Store</h1>
        <form action="MainController" method="POST">
            Please choose your ram:
            <select name="ListRam">
                <option value="R001-2gb-200">RAM 2GB</option>
                <option value="R002-4gb-400">RAM 4GB</option>
                <option value="R003-8gb-800">RAM 8GB</option>
            </select>
            <br/>
            <input type="submit" name="action" value="Add to cart"/>
            <a href="view.jsp">View Cart</a>
        </form>
    </body>
</html>

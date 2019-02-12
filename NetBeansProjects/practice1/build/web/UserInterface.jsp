<%-- 
    Document   : UserInterface
    Created on : Feb 6, 2019, 3:02:04 PM
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
        <h1 style="color: red;font: Aria;align-content: center">RAM'S Shop</h1>
        <form action="CartMainController" method="POST">
            please choose your product: <select name="cboRAM">
                <option value="R100-2GB-200">RAM 2GB</option>
                <option value="R200-6GB-600">RAM 6GB</option>
                <option value="R800-8GB-800">RAM 8GB</option>
                <input type="submit" name="action" value="Add to cart"/>
                <a href ="view.jsp">View Cart</a>
            </select>
        </form>
    </body>
</html>

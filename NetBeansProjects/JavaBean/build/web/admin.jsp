
<%-- 
    Document   : admin
    Created on : Feb 12, 2019, 1:27:22 PM
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
        <jsp:useBean id="TestBean" class="nghia.model.BeanNghia" scope="session"/>
        <h1>Hello <jsp:getProperty name="TestBean" property="username"/>!</h1>
        <h1>Hello ${TestBean.username}</h1>
        <h1>Hello ${sessionScope.TestBean.username}</h1>
    </body>
</html>

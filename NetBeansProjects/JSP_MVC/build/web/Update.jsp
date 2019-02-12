<%-- 
    Document   : Update
    Created on : Jan 22, 2019, 1:02:40 PM
    Author     : mickw
--%>

<%@page import="nghia.dto.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update page</h1>
        <% 
            RegistrationDTO dto = (RegistrationDTO) request.getAttribute("DTO");
        %>
        <form action="MainController" method="POST">
            Username: <input type="text" name ="txtUsername"
                             value="<%= dto.getUsername() %>"
                             readonly="true"/>
            <br/>
            Password: <input type="password" name="txtPassword"/>
            <br/>
            Fullname: <input type="text" name="txtFullname" value="<%= dto.getFullname() %>"/>
            <br/>
            Role: <input type="text" name="txtRole" value="<%= dto.getRole() %>"/>
            <br/>
            <input type="hidden" name="txtSearch" value="<%= request.getParameter("txtSearch") %>"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>

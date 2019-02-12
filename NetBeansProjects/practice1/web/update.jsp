<%-- 
    Document   : update
    Created on : Feb 11, 2019, 7:58:43 AM
    Author     : mickw
--%>

<%@page import="nghia.dto.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update Page</h1>
        <form action="MainController" method="Post">
            <%
                RegistrationDTO dto = (RegistrationDTO) request.getAttribute("DTO");
            %>
            Username: <input type="text" name="txtUsername" value="<%= dto.getUsername()%>" readonly="true"/>
            </br>
            Password: <input type="password" name ="txtPassword"/>
            </br>
            Full Name: <input type="text" name="txtFullname" value="<%= dto.getFullname()%>"/>
            </br>
            <select name="cboRole">
                <% if (dto.getRole().equalsIgnoreCase("Admin")) {  %>
                <option selected="selected">Admin</option>
                <option>User</option>
                <%  } else { %>
                <option >Admin</option>
                <option selected="selected">User</option>
                <% }%>
            </select>
            </br>
            <input type="hidden" name="txtSearch" value="<%= request.getParameter("txtSearch")%>"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>

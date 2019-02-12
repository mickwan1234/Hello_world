<%-- 
    Document   : LoginController
    Created on : Feb 12, 2019, 1:23:03 PM
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
        <jsp:setProperty name="TestBean" property="*"/>
        <% 
            String role = TestBean.checkLogin();
            if(role.equalsIgnoreCase("Admin")){
                response.sendRedirect("admin.jsp");
            }else if(role.equalsIgnoreCase("User")){
                response.sendRedirect("user.jsp");
            }else{
                response.sendRedirect("error.jsp");
            }
        %>
    </body>
</html>

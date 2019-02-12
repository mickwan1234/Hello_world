<%-- 
    Document   : AdminInterface
    Created on : Feb 8, 2019, 2:07:10 PM
    Author     : mickw
--%>

<%@page import="nghia.dto.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin</h1>
        </br>
        <form action ="MainController" method="POST">
            Username: <input type="text" name="txtSearch"/>
            </br>
            <input type="submit" name="action" value="Search"/> 
        </form>
        <form action="MainController" method="POST">
            <%
                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("INFO");
                if (result != null) {
                    if (result.size() > 0) {

            %>
            <table border="1">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Fullname</th>
                        <th>Role</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>

                <tbody>
                    <%                for (RegistrationDTO dto : result) {
                    %>
                    <tr>
                        <td><%= dto.getUsername()%></td>
                        <td><%= dto.getFullname()%></td>
                        <td><%= dto.getRole()%></td>

                        </form>

                        <td>
                            <form action="MainController" method="POST">
                                <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>"/>
                                <input type="hidden" name="txtSearch" value="<%=request.getParameter("txtSearch")%>"/>
                                <input type="submit" name="action" value="Edit">
                            </form>
                        </td>
                        <td><a href="MainController?action=Delete&username=<%= dto.getUsername()%>&txtSearch=<%= request.getParameter("txtSearch")%>">Delete</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </form>
        <%
        } else {
        %>
        Nothing Found
        <% }
                }%>
</html>

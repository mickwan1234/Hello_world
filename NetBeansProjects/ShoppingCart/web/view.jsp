<%-- 
    Document   : view
    Created on : Jan 22, 2019, 3:34:32 PM
    Author     : mickw
--%>

<%@page import="nghia.dtos.RamDTO"%>
<%@page import="nghia.dtos.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your cart</h1>
        <%
            CartObj cart = (CartObj) session.getAttribute("shoppingCart");
        %>
        <h1><%= cart.getCustomerName()%>'s cart</h1>
        <form action="MainController" method="POST">
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>

                <%
                    int count = 0;
                    for (RamDTO dto : cart.getCart().values()) {
                        count++;

                %>
                <tr>
                    <td><%=count%></td>
                    <td><%= dto.getName()%></td>
                    <td><%= dto.getPrice()%></td>
                    <td>
                        <input type="text" name="txtQuantity" value="<%= dto.getQuantitiy()%>"/>
                        <input type="hidden" name="txtId" value="<%= dto.getId()%>"/>
                        <%= dto.getQuantitiy()%>
                    </td>
                    <td>
                        <input type="checkbox" name="rmv" value="<%= dto.getId()%>"/>
                    </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td><a href="index.jsp">Continue shopping</a></td>
                    <td><input type="submit" name="action" value="Update"/></td>
                    <td><input type="submit" name="action" value="Remove"/></td>
                    <td>Total JSTL: ${sessionScope.shoppingCart.total}</td>
                    <td>Total: <%= cart.getTotal()%></td>
                </tr>
            </tbody>
        </table>
        </form>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" >
        <title>Insert Title here</title>
    </head>

    <body>

    <%
        String datoReq = "Variable Request";
        request.getSession().setAttribute("varReq", datoReq); //Envío de Dato Java a Servlet.
    %>
    <p>Este es mi parrafo en JSP</p>
    <p>La fecha es: <%= new Date() %> </p>
    <table>
        <%
            for(int i=0; i<10; i++){%>
                <tr>
                    <td>Celda <%= i %></td>
                </tr>
            <%}
        %>
    </table>

    <a href="<%= request.getContextPath() %>/test?nombre=Kevin">Link a mi servlet</a>
    </body>
</html>
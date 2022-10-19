<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar datos.</title>
    </head>
    <body>
        <div class="container">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Nombres:</td>
                        <td><%
                            HttpServletRequest r;
                            r.getSession().getParameter("nombres");
                        %></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><%
                            HttpServletRequest r;
                            r.getSession().getParameter("apellidos");
                        %></td>
                    </tr>
                    <tr>
                        <td>Edad:</td>
                        <td><%
                            HttpServletRequest r;
                            r.getSession().getParameter("edad");
                        %></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>

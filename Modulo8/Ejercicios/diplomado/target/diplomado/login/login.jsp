<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>        
        <form name="login" action="<c:url value="/login"/>" method="post">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Usario:</td>
                        <td><input type="text" name="usuario" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" 
                                   value="Aceptar" />
                            &nbsp;
                            <input type="reset" 
                                   value="Reset" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>

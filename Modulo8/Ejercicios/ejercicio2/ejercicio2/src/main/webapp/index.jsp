<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="diplomadojava" var="llaves" scope="application"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message bundle="${applicationScope.llaves}" key="etiqueta.titulo.aplicacion"/></title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="<c:url value="/login"/>">Ingresar a Aplicaci&oacute;n</a>
    </body>
</html>
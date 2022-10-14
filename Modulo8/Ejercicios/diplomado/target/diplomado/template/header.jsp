<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<div style="text-align: left">
    <img src="<c:url value="/images/logo_dgtic.png"/>" width="30px" height="50px"/>
    <fmt:message bundle="${applicationScope.llaves}" key="etiqueta.titulo.aplicacion"/>
</div>
<p style="text-align: right">
    <c:if test="${not empty nombre}">
        <fmt:message bundle="${applicationScope.llaves}" key="etiqueta.usuario" />&nbsp;
        <c:out value="${sessionScope.nombre}" /> 
    </c:if>
</p>
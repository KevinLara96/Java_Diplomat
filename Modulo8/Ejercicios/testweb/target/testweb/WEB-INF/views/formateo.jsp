<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Formateo de datos</title>
</head>
<body>

	<p>Ejemplo de formateo de datos</p>
	<fmt:formatDate value="${formato.fecha}" pattern="dd/MM/YYYY" var="fechaFormateada" />
	<c:out value="${fechaFormateada}"/>
	<br/>
	<fmt:formatNumber value="${formato.salario}" type="CURRENCY" />
</body>
</html>
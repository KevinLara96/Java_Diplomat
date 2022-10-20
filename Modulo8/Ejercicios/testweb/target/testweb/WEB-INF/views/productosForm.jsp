<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Productos Form</title>
</head>
<body>

	<h1>Listado de Productos</h1>
	<table border="1">
		<tr>
			<th style="width: 50px;">Id</th>
			<th style="width: 250px;">Nombre</th>
		</tr>
		<c:forEach var="producto" items="${sessionScope.productos}">
			<tr>
				<td><c:out value="${producto.id}" /></td>
				<td><c:out value="${producto.nombre}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<spring:url value="/productoForm/inicio"/>">
		Regresar
	</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Usuario Creado</title>
</head>
<body>

	<h2>Usuario creado correctamente:</h2>
	<p>${usuario.nombre}</p>
	<a href="<spring:url value="/validaForm/inicio"/>">
		<spring:message code="etiqueta.label.regresar" />
	</a>

</body>
</html>
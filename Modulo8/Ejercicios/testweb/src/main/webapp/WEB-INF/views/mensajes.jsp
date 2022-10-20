<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Mensajes spring</title>
</head>
<body>

<p><spring:message code="etiqueta.label.nombre" /><input type="text" /></p>
<p><spring:message code="etiqueta.label.apellidos" /><input type="text" /></p>
</body>
</html>
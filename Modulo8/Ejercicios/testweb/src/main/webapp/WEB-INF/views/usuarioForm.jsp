<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Usuario Form</title>
<style type="text/css">
.formFieldError {
	background-color: #FFC;
}
</style>
</head>
<body>
	<h2>Registrar Usuario:</h2>
	<form:form modelAttribute="usuario" action="crear">
		<table>
			<tr>
				<td><spring:message code="etiqueta.label.nombre" /></td>
				<td><form:input path="nombre" cssErrorClass="formFieldError" /></td>
				<td><form:errors path="nombre" /></td>
			</tr>
			<tr>
				<td><spring:message code="etiqueta.label.password" /></td>
				<td><form:input path="password" cssErrorClass="formFieldError" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value='<spring:message code="etiqueta.label.enviar" />'>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
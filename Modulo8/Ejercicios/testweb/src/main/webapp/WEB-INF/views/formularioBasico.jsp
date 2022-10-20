<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulario Basico</title>
</head>
<body>

	<form:form modelAttribute="producto" action="guardaProducto" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value='Enviar'>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>
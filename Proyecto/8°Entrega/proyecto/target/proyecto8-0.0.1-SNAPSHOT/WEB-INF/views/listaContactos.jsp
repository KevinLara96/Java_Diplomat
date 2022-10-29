<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/formatos/pdf" var="pdfLink" />
<spring:url value="/formatos/xls" var="xlsLink" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.titulo.empleados" /></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">
				<spring:message code="label.titulo.aplicacion" />
			</h3>
			<hr />

			<input type="button"
				value='<spring:message code="label.empleado.agregar" />'
				onclick="window.location.href='empleadoForm'; return false;"
				class="btn btn-primary" /> <br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="label.titulo.empleados" />
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th><spring:message code="label.empleado.id" /></th>
							<th><spring:message code="label.empleado.nombre" /></th>
							<th><spring:message code="label.empleado.correo" /></th>
							<th><spring:message code="label.empleado.rfc" /></th>
							<th><spring:message code="label.empleado.salario" /></th>
							<th><spring:message code="label.empleado.agencia" /></th>
							<th><spring:message code="label.empleado.puesto" /></th>
							<th><spring:message code="label.empleado.accion" /></th>
						</tr>

						<c:forEach var="contacto" items="${contactos}">

							<c:url var="updateLink"
								value="/empleados/actualizar/${contacto.id}" />

							<c:url var="deleteLink" value="/empleados/eliminar">
								<c:param name="contactoId" value="${contacto.id}" />
							</c:url>

							<tr>
								<td>${contacto.nombre}</td>
								<td>${contacto.apellidos}</td>
								<td>${contacto.edad}</td>
								<td>${contacto.edad}</td>
								<td>${contacto.edad}</td>
								<td>${contacto.edad}</td>
								<td>${contacto.tipoContacto.nombre}</td>
								<td><a href="${updateLink}" class="btn btn-primary"
									role="button"><spring:message code="label.empleado.editar" />
								</a>&nbsp; <a href="${deleteLink}" class="btn btn-danger"
									role="button"
									onclick="if (!(confirm('<spring:message code="label.empleado.eliminar.pregunta" />'))) return false">
										<spring:message code="label.empleado.eliminar" />
								</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="text-center">
					<a class="btn btn-info" href="${pdfLink}" role="button"
						target="_blank"> <spring:message code="label.reportes.pdf" />
					</a> &nbsp; <a class="btn btn-info" href="${xlsLink}" role="button"
						target="_blank"> <spring:message code="label.reportes.xls" />
					</a>
				</div>
				<br />
			</div>
		</div>
	</div>
	<div class="footer"></div>
</body>

</html>
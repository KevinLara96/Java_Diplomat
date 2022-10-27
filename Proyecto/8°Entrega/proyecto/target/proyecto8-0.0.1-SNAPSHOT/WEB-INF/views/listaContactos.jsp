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
<title><spring:message code="label.titulo.contactos" /></title>
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
				value='<spring:message code="label.contacto.agregar" />'
				onclick="window.location.href='contactoForm'; return false;"
				class="btn btn-primary" /> <br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="label.titulo.contactos" />
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th><spring:message code="label.contacto.nombre" /></th>
							<th><spring:message code="label.contacto.apellidos" /></th>
							<th><spring:message code="label.contacto.edad" /></th>
							<th><spring:message code="label.contacto.tipo.contacto" /></th>
							<th><spring:message code="label.contacto.medio.contacto" /></th>
							<th><spring:message code="label.contacto.accion" /></th>
						</tr>

						<c:forEach var="contacto" items="${contactos}">

							<c:url var="updateLink"
								value="/contactos/actualizar/${contacto.id}" />

							<c:url var="deleteLink" value="/contactos/eliminar">
								<c:param name="contactoId" value="${contacto.id}" />
							</c:url>

							<tr>
								<td>${contacto.nombre}</td>
								<td>${contacto.apellidos}</td>
								<td>${contacto.edad}</td>
								<td>${contacto.tipoContacto.nombre}</td>
								<td>
									<ul>
										<c:forEach items="${contacto.contactosMedios}" var="contactoMedio">
											<li>${contactoMedio.medioContacto.nombre} &nbsp;${contactoMedio.valor}</li>
										</c:forEach>
									</ul>
								</td>
								<td><a href="${updateLink}" class="btn btn-primary"
									role="button"><spring:message code="label.contacto.editar" />
								</a>&nbsp; <a href="${deleteLink}" class="btn btn-danger"
									role="button"
									onclick="if (!(confirm('<spring:message code="label.contacto.eliminar.pregunta" />'))) return false">
										<spring:message code="label.contacto.eliminar" />
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.titulo.contactos" /></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h3 class="text-center">
				<spring:message code="label.titulo.aplicacion" />
			</h3>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="label.contacto.agregar" />
					</div>
				</div>
				<div class="panel-body">

					<spring:url value="/contactos/guardaContacto" var="urlGuardar" />
					<spring:url value="/contactos/listar" var="urlRegresar" />
					<form:form action="${urlGuardar}" cssClass="form-horizontal"
						method="post" modelAttribute="contacto">
						
						<form:hidden path="id" />

						<div class="form-group">
							<form:label path="nombre" class="col-md-3 control-label">
								<spring:message code="label.contacto.nombre" />
							</form:label>
							<div class="col-md-9">
								<form:input path="nombre" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="nombre" />
							</div>
						</div>
						<div class="form-group">
							<label for="apellidos" class="col-md-3 control-label"> <spring:message
									code="label.contacto.apellidos" />
							</label>
							<div class="col-md-9">
								<form:input path="apellidos" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="apellidos" />
							</div>
						</div>

						<div class="form-group">
							<label for="edad" class="col-md-3 control-label"> <spring:message
									code="label.contacto.edad" />
							</label>
							<div class="col-md-3">
								<form:input path="edad" cssClass="form-control" />
							</div>
							<div class="col-md-3">
								<form:errors path="edad" />
							</div>
						</div>

						<div class="form-group">
							<label for="tipoContacto" class="col-md-3 control-label">
								<spring:message code="label.contacto.tipo.contacto" />
							</label>
							<div class="col-md-6">
								<form:select path="tipoContacto" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.tipoContactoList}"></form:options>
								</form:select>
							</div>
							<div class="col-md-6">
								<form:errors path="tipoContacto" />
							</div>
						</div>

						<div class="form-group">
							<label for="direccion" class="col-md-3 control-label"> <spring:message
									code="label.contacto.direccion" />
							</label>
							<div class="col-md-9">
								<form:input path="direccion" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="direccion" />
							</div>
						</div>

						<div class="form-group">
							<label for="medioContacto" class="col-md-3 control-label">
								<spring:message code="label.contacto.medio.contacto" />
							</label>
							<div class="col-md-6">
								<form:select path="medioContacto" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.medioContactoList}"></form:options>
								</form:select>
							</div>
							<div class="col-md-6">
								<form:errors path="medioContacto" />
							</div>
						</div>

						<div class="form-group">
							<label for="medio" class="col-md-3 control-label"> <spring:message
									code="label.contacto.medio" />
							</label>
							<div class="col-md-9">
								<form:input path="medio" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="medio" />
							</div>
						</div>



						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<input class="btn btn-primary" type="submit"
									value='<spring:message code="label.contacto.enviar" />' />
								&nbsp; <a href="${urlRegresar}" class="btn btn-primary"
									role="button"> <spring:message
										code="label.contacto.cancelar" />
								</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
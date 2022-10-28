<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.titulo.empleados" /></title>
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
						<spring:message code="label.empleado.agregar" />
					</div>
				</div>
				<div class="panel-body">

					<spring:url value="/tmp/guardaContacto" var="urlGuardar" />
					<spring:url value="/tmp/listar" var="urlRegresar" />
					<form:form action="${urlGuardar}" cssClass="form-horizontal"
						method="post" modelAttribute="contacto">
						
						<form:hidden path="id" />

						<div class="form-group">
							<form:label path="idEmpleado" class="col-md-3 control-label">
								<spring:message code="label.empleado.id" />
							</form:label>
							<div class="col-md-3">
								<form:input path="idEmpleado" cssClass="form-control" />
							</div>
							<div class="col-md-3">
								<form:errors path="idEmpleado" />
							</div>
						</div>

						<div class="form-group">
							<form:label for="nombre" class="col-md-3 control-label"> 
                                <spring:message	code="label.empleado.nombre" />
							</form:label>
							<div class="col-md-9">
								<form:input path="nombre" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="nombre" />
							</div>
						</div>

						<div class="form-group">
							<form:label for="correo" class="col-md-3 control-label"> 
                                <spring:message	code="label.empleado.correo" />
							</form:label>
							<div class="col-md-9">
								<form:input path="correo" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="correo" />
							</div>
						</div>

						<div class="form-group">
							<form:label for="rfc" class="col-md-3 control-label"> 
                                <spring:message	code="label.empleado.rfc" />
							</form:label>
							<div class="col-md-9">
								<form:input path="rfc" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="rfc" />
							</div>
						</div>

						<div class="form-group">
							<form:label for="salario" class="col-md-3 control-label"> 
                                <spring:message	code="label.empleado.salario" />
							</form:label>
							<div class="col-md-3">
								<form:input path="salario" cssClass="form-control" />
							</div>
							<div class="col-md-3">
								<form:errors path="salario" />
							</div>
						</div>

						<div class="form-group">
							<form:label for="agencia" class="col-md-3 control-label">
								<spring:message code="label.empleado.agencia" />
							</form:label>
							<div class="col-md-6">
								<form:select path="agencia" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.agenciaList}"></form:options>
								</form:select>
							</div>
							<div class="col-md-6">
								<form:errors path="agencia" />
							</div>
						</div>


						<div class="form-group">
							<form:label for="puesto" class="col-md-3 control-label">
								<spring:message code="label.empleado.puesto" />
							</form:label>
							<div class="col-md-6">
								<form:select path="puesto" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.puestoList}"></form:options>
								</form:select>
							</div>
							<div class="col-md-6">
								<form:errors path="puesto" />
							</div>
						</div>


						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<input class="btn btn-primary" type="submit"
									value='<spring:message code="label.empleado.enviar" />' />
								&nbsp; <a href="${urlRegresar}" class="btn btn-primary"
									role="button"> <spring:message
										code="label.empleado.cancelar" />
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
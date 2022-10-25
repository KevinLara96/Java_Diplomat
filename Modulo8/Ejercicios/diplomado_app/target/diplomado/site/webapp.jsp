<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/css/template.css" />">
        <title><fmt:message bundle="${applicationScope.llaves}" key="etiqueta.titulo.aplicacion"/></title>
    </head>
    <body>
        <div class="container">
            <div class="box header">
                <%-- se agrega el header del template  --%>
                <jsp:include page="/template/header.jsp" />
            </div>
            <div class="box left_menu">
                <%-- se agrega el menu del template --%>
                <jsp:include page="/template/menu.jsp" />
            </div>
            <div class="box main">
                <%-- se agrega el body del template --%>
                <jsp:include page="/template/body.jsp" />
            </div>
            <div class="box footer">
                <%-- se agrega el footer del template --%>
                <jsp:include page="/template/footer.jsp" />
            </div>
        </div>
    </body>
</html>

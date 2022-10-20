<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <h1>Listado de Productos</h1>  
        <table border="1">
            <tr>
                <th style="width:  50px;">No</th>
                <th style="width: 250px;">Nombre</th>
                <th style="width: 200px;"></th>
            </tr>
            <c:forEach var="product" 
                       items="${productList}"
                       varStatus="status">
                <tr>
                    <td><b>${status.index + 1} * <c:out value="${product.id}" /></b></td>
                    <td><c:out value="${product.nombre}" /></td>
                    <td>
                    	<a href="<c:url value="/productos/parametro/editar/${product.id}" />">Editar</a>
                    	&nbsp;
                    	<a href="<c:url value="/productos/parametro/eliminar/${product.id}" />">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
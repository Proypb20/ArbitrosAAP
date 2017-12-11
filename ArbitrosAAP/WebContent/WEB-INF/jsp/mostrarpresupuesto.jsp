<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1px">
		<thead>
			<tr>
				<td>Apellido y Nombre</td>
				<td>Categoria</td>
				<td>Honorarios</td>
				<td>Viaticos</td>
				<td>Firma</td>
			</tr>
		</thead>
		
			<c:forEach items="${PresupuestoList}" var="presupuesto">
				
				<tr>
				<td>${presupuesto.arbitro.usuario.apellido}, ${presupuesto.arbitro.usuario.nombre}</td>
				<td>${presupuesto.arbitro.categoria.nombre}</td>
				<td>${presupuesto.arbitro.categoria.honorarios}</td>
				<td>...............</td>
				<td>...............</td>
				
				</tr>
				
			</c:forEach>
	</table>
	<input type="button" value="Volver"  onclick="javascript:history.go(-1)">
</body>
</html>
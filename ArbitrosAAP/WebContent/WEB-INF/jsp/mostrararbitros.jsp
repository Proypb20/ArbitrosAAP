<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociación Argentina de Paintball | Sitio Oficial de AAP | Listar Arbitros</title>
</head>
<body>
Arbitros:

	<table border="1px">
		<thead>
			<tr>
				<th>Apellido y Nombre</th>
				<th>Nro Arbitro</th>
				<th>Localidad</th>
				<th>Provincia</th>
				<th>Categoria</th>
			</tr>
		</thead>
		
			<c:forEach items="${arbitrolist}" var="arbitro">
				
				<tr>
				
				<td>${arbitro.apellido}, ${arbitro.nombre}</td>
				<td>${arbitro.arbitro.nroArbitro}</td>
				<td>${arbitro.localidad}</td>
				<td>${arbitro.provincia}</td>
				<c:if test="${empty arbitro.arbitro.categoria.nombre}">
				<td>No Categorizado</td>
				</c:if>
				<c:if test="${not empty arbitro.arbitro.categoria.nombre}">
				<td>${arbitro.arbitro.categoria.nombre}</td>
				</c:if>
				</tr>
				
			</c:forEach>
    </table>
	<input type="button" value="Volver"  onclick="javascript:history.go(-1)"> 
</body>
</html>
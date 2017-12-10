<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
				<td>Usuario</td>
				<td>Apellido y Nombre</td>
				<td>Tipo de Usuario</td>
				<td>Tipo y Nro Documento</td>
				<td>Direccion</td>
				<td>Localidad</td>
				<td>Provincia</td>
				<td>Telefono</td>
				<td>Email</td>
			</tr>
		</thead>
		
			<c:forEach items="${usuariolist}" var="usuarios">
				
				<tr>
				<td>${usuarios.usuario}</td>
				<td>${usuarios.apellido}, ${usuarios.nombre}</td>
				<td>${usuarios.tipousuario.nombre}</td>
				<td>${usuarios.tipoDocumento}: ${usuarios.nroDocumento}</td>
				<td>${usuarios.direccion}</td>
				<td>${usuarios.localidad}</td>
				<td>${usuarios.provincia}</td>
				<td>${usuarios.telefono}</td>
				<td>${usuarios.email}</td>
				
				</tr>
				
			</c:forEach>
			<tr>
	<td> </td>
	<td><input type="button" value="Volver"  onclick="javascript:history.go(-1)"> </td>
	</tr>
	</table>
</body>
</html>
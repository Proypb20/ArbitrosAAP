<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" commandName="usuariom" action="ActualizarUsuario.html">
	<c:if test="${!empty usuariom.arbitro.idArbitro}">
	    <form:hidden path="arbitro.idArbitro" value="${usuariom.arbitro.idArbitro}"/>
	</c:if>
	
	<form:hidden path="tipousuario.idTipoUsuario" value="${usuariom.tipousuario.idTipoUsuario}"/>
		<table>
			<tr>
				<td align="left">Nombre de usuario:</td>
				<td><form:input name="user" id="user" class="input"
						value="${usuariom.usuario}" size="25" type="text" path="usuario" /></td>
			</tr>
			<tr>
				<td align="left">Contraseña</td>
				<td><form:input name="password" id="contrasena" class="input"
						value="${usuariom.contrasena}" size="25" type="password"
						path="contrasena" /></td>
			</tr>
			<tr>
				<td align="left">Apellido</td>
				<td><form:input name="lastname" id="lastname" class="input"
						value="${usuariom.apellido}" size="25" type="text" path="apellido" /></td>
			</tr>
			<tr>
				<td align="left">Nombres</td>
				<td><form:input name="name" id="name" class="input"
						value="${usuariom.nombre}" size="25" type="text" path="nombre" /></td>
			</tr>
			<tr>
				<td align="left">Numero de Documento</td>
				<td><form:input name="nrodoc" id="nrodoc" class="input"
						value="${usuariom.nroDocumento}" size="25" type="text"
						onkeypress='return event.charCode >= 48 && event.charCode <= 57'
						path="nroDocumento" /></td>
			</tr>
			<tr>
				<td align="left">Direccion</td>
				<td><form:input name="address" id="address" class="input"
						value="${usuariom.direccion}" size="25" type="text"
						path="direccion" /></td>
			</tr>
			<tr>
				<td align="left">Localidad</td>
				<td><form:input name="localidad" id="localidad" class="input"
						value="${usuariom.localidad}" size="25" type="text"
						path="localidad" /></td>
			</tr>
			<tr>
				<td align="left">Pais</td>
				<td><form:input name="pais" id="pais" class="input"
						value="${usuariom.pais}" size="25" type="text" path="pais" /></td>
			</tr>
			<tr>
				<td align="left">Telefono</td>
				<td><form:input name="telefono" id="telefono" class="input"
						value="${usuariom.telefono}" size="25" type="text" path="telefono" /></td>
			</tr>
			<tr>
				<td align="left">Email</td>
				<td><form:input name="email" id="email" class="input" value=""
						size="25" type="email" path="email" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" name="btnguardar">
				</td>
				<td><input type="reset" value="Limpiar"></td>
				<td><input type="button" value="Cancelar"
					onclick="javascript:history.go(-1)"></td>
			</tr>

		</table>
			    ${Mensaje}
			    </form:form>
</body>
</html>
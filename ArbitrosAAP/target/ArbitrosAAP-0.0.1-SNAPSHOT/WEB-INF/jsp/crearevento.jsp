<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociacion Argentina de Paintball | Sitio Oficial de AAP | Crear Evento</title>
</head>
<body>
<h2>Bienvenido ${IdName}</h2>
<c:if test="${empty idTu}">
       <c:set var = "idTu" scope = "session" value = "${idTypeUser}"/>
      <c:set var = "idU" scope = "session" value = "${idUser}"/>
</c:if>      
<c:choose>
    <c:when test="${idTu=='1'}">
        <jsp:include page="admMenu.jsp"></jsp:include>
        <br />
    </c:when>    
    <c:when test="${idTu=='2'}">
        <jsp:include page="encMenu.jsp"></jsp:include>
        <br />
    </c:when> 
    <c:otherwise>
        <jsp:include page="arbMenu.jsp"></jsp:include>
        <br />
    </c:otherwise>
</c:choose>
	<frm:form action="GuardarEvento.html" method="post" >
		<table>
			<tr>
				<td align="left">Torneo</td>
				<td><frm:select path="torneo.idTorneo">
						<frm:options items="${TorneoList}" itemLabel="nombre" itemValue="idTorneo"/>
					</frm:select></td>
			</tr>
			<tr>
				<td align="left">Nombre de Evento</td>
				<td><frm:input name="nombre" id="nombre" class="input" value=""
						size="25" type="text" path="nombre" /></td>
			</tr>
			<tr>
				<td align="left">Año</td>
				<td><frm:input name="anio" id="anio" class="input" value=""
						size="25" type="text" path="anio" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" name="btnguardar">
				</td>
				<td><input type="reset" value="Limpiar"></td>
				<td><input type="button" value="Cancelar"
					onclick="javascript:history.go(-1)"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>
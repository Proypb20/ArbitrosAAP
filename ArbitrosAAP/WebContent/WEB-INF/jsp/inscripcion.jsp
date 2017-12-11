<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<frm:form action="Inscribir.html" method="post">
<form:hidden path="arbitro.idArbitro" value="${idArbitro}"/>
<table>
				 <tr>
					<td align="left">Torneo</td>
					<td><frm:select path="evento.torneo.idTorneo">
						<frm:options items="${TorneoList}" itemLabel="nombre" itemValue="idTorneo"/>
						</frm:select>
					</td>
				</tr>
				<tr>
					<td align="left">Evento</td>
					<td><frm:select path="evento.idEvento">
						<frm:options items="${EventoList}"  itemLabel="nombre" itemValue="idEvento"/>
						</frm:select>
					</td>
				</tr>
				<tr>
					<td align="left">Vehiculo</td>
					<td><frm:select name="viatico" class="form-control" style="width: 175px;" path="viatico">
						<option selected="selected" value="N">Necesito Transporte</option>
						<option value="Y">Poseo Vehiculo-Puedo llevar gente</option>
						<option value="N">Viajo por mis propios medios</option>
					</frm:select></td>
			    <tr>
			    	<td> <input type="submit" value="Aceptar"> </td>
			        <td> <input type="reset" value="Limpiar"> </td>
			        <td> <input type="button" value="Cancelar"  onclick="javascript:history.go(-1)"> </td>
			    </tr>
			    </table>
			    </frm:form>
</body>
</html>
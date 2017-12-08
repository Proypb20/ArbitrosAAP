<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
				<table>
                 <tr>
					<td align="left">Torneo</td>
					<td><frm:select path="torneo">
						<frm:options items="${TorneoList}"/>
						</frm:select>
					</td>
				</tr>
				<frm:form action="GuardarEvento.html" method="post">
				<tr>
					<td align="left">Nombre de Evento</td>
					<td><frm:input name="nombre" id="nombre" class="input" value="" size="25" type="text" path="nombre"/></td>
				</tr>
				<tr>
					<td align="left">Año</td>
					<td><frm:input name="anio" id="anio" class="input" value="" size="25" type="text" path="anio"/></td>
				</tr>
			    <tr>
			    	<td> <input type="submit" value="Guardar" name="btnguardar"> </td>
			        <td> <input type="reset" value="Limpiar"> </td>
			        <td> <input type="button" value="Cancelar"  onclick="javascript:history.go(-1)"> </td>
			    </tr>
			    </frm:form>
			    </table>
</body>
</html>
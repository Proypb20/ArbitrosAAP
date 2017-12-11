<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociación Argentina de Paintball | Sitio Oficial de AAP | Presupuesto</title>
</head>
<body>
<frm:form action="ListarPres.html" method="post" >
<table>
			<tr>
				<td align="left">Evento</td>
				<td><frm:select path="idEvento">
						<frm:options items="${EventoList}" itemLabel="nombre" itemValue="idEvento"/>
					</frm:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Buscar" name="btnguardar">
				</td>
				<td><input type="reset" value="Limpiar"></td>
				<td><input type="button" value="Cancelar"
					onclick="javascript:history.go(-1)"></td>
			</tr>
		</table>
</frm:form>
</body>
</html>
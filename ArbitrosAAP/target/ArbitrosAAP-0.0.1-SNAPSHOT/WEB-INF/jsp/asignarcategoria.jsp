<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar categoria</title>
</head>
<body>
<frm:form action="AsignaCategUsuario.html" method="post">
<table>
                 <tr>
					<td align="left">Usuario</td>
					<td><frm:select path="idUsuario">
						<frm:options items="${UsuarioList}" itemLabel="usuario" itemValue="idUsuario"/>
						</frm:select>
					</td>
				</tr>
				<tr>
					<td align="left">Nueva Categoria</td>
					<td><frm:select path="arbitro.categoria.idCategoria">
						<frm:options items="${CategoriaList}"  itemLabel="nombre" itemValue="idCategoria"/>
						</frm:select>
					</td>
				</tr>
			    <tr>
			    	<td> <input type="submit" value="Guardar" name="btnguardar"> </td>
			        <td> <input type="reset" value="Limpiar"> </td>
			        <td> <input type="button" value="Cancelar"  onclick="javascript:history.go(-1)"> </td>
			    </tr>
			    </table>
</frm:form>
</body>
</html>
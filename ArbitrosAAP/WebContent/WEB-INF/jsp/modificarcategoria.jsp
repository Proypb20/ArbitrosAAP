<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociacion Argentina de Paintball | Sitio Oficial de AAP | Modificar Categorias</title>
</head>
<script>
function getId()
{
	document.getElementById("nombre").value =document.getElementById('idCategoria')[document.getElementById('idCategoria').selectedIndex].innerHTML;
}
function validId()
{
	var x = document.forms["modifyuser"]["idCategoria"].value;
    if (x == null || x == "") {
        alert("Debe seleccionar una categoria");
        return false;
    }
    else
    	return true;
}
</script> 
<body>
<header id="headermc">
				<div class="logo">
         			<a href="http://www.aapaintball.com.ar/" id="logo"><img src="http://www.aapaintball.com.ar/wp-content/uploads/2011/07/logo-aap-paintball-2016-1.png" alt="Asociacion Argentina de Paintball" title="Sitio Oficial de AAP"></a>
                </div>
				<div class="clear"></div>
				<div id="widget-header">
				</div><!--#widget-header-->
				<div class="clear"></div>
				<div class="row-top">
			    <div class="clear"></div>
				</div>
</header>
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
	<frm:form name="modifyuser"  action="ModificarCategoria.html" method="post" onsubmit="return validId()" >
		<table>
			<tr>
				<td align="left">Categoria</td>
				<td><frm:select path="idCategoria" onchange="getId()">
						<frm:options items="${CategoriaList}" itemLabel="nombre" itemValue="idCategoria"/>
					</frm:select></td>
			</tr>
			<tr>
				<td align="left">Nombre</td>
				<td><frm:input name="nombre" id="nombre" class="input" value=""
						size="25" type="text" path="nombre" /></td>
			</tr>
			<tr>
				<td align="left">Nuevo Honorario</td>
				<td><frm:input name="honorarios" id="honorarios" class="input"
						size="25" type="text" path="honorarios" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" name="btnguardar">
				</td>
				<td><input type="reset" value="Limpiar"></td>
<!-- 				<td><input type="button" value="Cancelar" -->
<!-- 					onclick="javascript:history.go(-1)"></td> -->
			</tr>
		</table>
	</frm:form>
</body>
</html>
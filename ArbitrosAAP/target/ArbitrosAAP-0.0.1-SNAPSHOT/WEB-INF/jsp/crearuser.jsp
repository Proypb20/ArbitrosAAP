<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function validation() {
   var x = document.forms["createusers"]["username"].value;
    if (x == null || x == "") {
        alert("El Usuario no puede ser nulo");
        return false;
    }
    x = document.forms["createusers"]["lastname"].value;
    if (x == null || x == "") {
        alert("El Apellido no puede ser nulo");
        return false;
    }
    x = document.forms["createusers"]["name"].value;
    if (x == null || x == "") {
        alert("El Nombre no puede ser nulo");
        return false;
    }
    x = document.forms["createusers"]["tipodoc"].value;
    if (x == null || x == "") {
        alert("El Tipo de Documento no puede ser nulo");
        return false;
    }
    x = document.forms["createusers"]["nrodoc"].value;
    if (x == null || x == "") {
        alert("El Numero Documento no puede ser nulo");
        return false;
    }
    x = document.forms["createusers"]["address"].value;
    if (x == null || x == "") {
        alert("La direccion no puede ser nula");
        return false;
    }
    x = document.forms["createusers"]["localidad"].value;
    if (x == null || x == "") {
        alert("La Localidad no puede ser nula");
        return false;
    }
    x = document.forms["createusers"]["provincia"].value;
    if (x == null || x == "") {
        alert("La Provincia no puede ser nula");
        return false;
    }
    x = document.forms["createusers"]["pais"].value;
    if (x == null || x == "") {
        alert("El Pais no puede estar vacio");
        return false;
    }
    x = document.forms["createusers"]["tipou"].value;
    if (x == 0) {
        alert("Debe seleccionar un tipo de usuario");
        return false;
    }
    return true;
}
function mostrararb()
{
	 if (document.forms["createusers"]["tipou"].value == 3) {
	        document.getElementById('nroarb').style.visibility = 'visible';
	    } else {
	        document.getElementById('nroarb').style.visibility = 'hidden';
	        document.getElementById('nroarb').value = "";
	    }
}
function onloadarb()
{
	document.getElementById('nroarb').style.visibility = 'hidden';
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociacion Argentina de Paintball | Sitio Oficial de AAP | Crear Usuario</title>
<spring:url value="/resources/css/main.css" var="mainCss" />
	<spring:url value="/resources/js/jquery.1.10.2.min.js" var="jqueryJs" />
	<spring:url value="/resources/js/main.js" var="mainJs" />

	<link href="${mainCss}" rel="stylesheet"  type="text/css"/>
    <script src="${jqueryJs}"></script>
    <script src="${mainJs}"></script>
</head>
<body>
<div class="cont">
<div id="main">
<header id="header">
				<div class="logo">
         			<a href="http://www.aapaintball.com.ar/" id="logo"><img src="http://www.aapaintball.com.ar/wp-content/uploads/2011/07/logo-aap-paintball-2016-1.png" alt="Asociaci�n Argentina de Paintball" title="Sitio Oficial de AAP"></a>
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
<frm:form name="createusers" action="GuardarUsuario.html" method="post" onsubmit="return validation()">
<table>
				<tr>
					<td align="left">Nombre de usuario</td>
					<td><frm:input name="username" id="username" class="input" value="" size="25" type="text" path="usuario"/></td>
				</tr>
				<tr>
					<td align="left">Contraseña</td>
					<td><frm:input name="password" id="contrasena" class="input" value="" size="25" type="password" path="contrasena"/></td>
			    </tr>
			    <tr>
					<td align="left">Apellido</td>
					<td><frm:input name="lastname" id="lastname" class="input" value="" size="25" type="text" path="apellido"/></td>
				</tr>
				<tr>
					<td align="left">Nombres</td>
					<td><frm:input name="name" id="name" class="input" value="" size="25" type="text" path="nombre"/></td>
				</tr>
				<tr>
					<td align="left">Tipo de Documento</td>
					<td><frm:select name="tipodoc" class="form-control" style="width: 180px;" type="option" path="tipoDocumento">
						<option selected="selected" value="">Seleccione una opcion</option>
						<option value="DNI">DNI</option>
						<option value="PASAPORTE">PASAPORTE</option>
						<option value="CDI">CDI</option>
						<option value="CUIT/L">CUIT/L</option>
						<option value="OTROS">OTROS</option>
					</frm:select></td>
				</tr>
				<tr>
					<td align="left">Numero de Documento</td>
					<td><frm:input name="nrodoc" id="nrodoc" class="input" value="" size="25" type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' path="nroDocumento"/></td>
				</tr>
				<tr>
					<td align="left">Direccion</td>
					<td><frm:input name="address" id="address" class="input" value="" size="25" type="text" path="direccion"/></td>
				</tr>
				<tr>
					<td align="left">Localidad</td>
					<td><frm:input name="localidad" id="localidad" class="input" value="" size="25" type="text" path="localidad"/></td>
				</tr>
				<tr>
					<td align="left">Provincia</td>
					<td><frm:select name="provincia" class="form-control" style="width: 180px;" path="provincia">
					    <option selected="selected" value="">Seleccione una opcion</option>
						<option>Buenos Aires</option>
						<option>Capital Federal</option>
						<option>Catamarca</option>
						<option>Chaco</option>
						<option>Chubut</option>
						<option>Cordoba</option>
						<option>Corrientes</option>
						<option>Entre Rios</option>
						<option>Formosa</option>
						<option>Jujuy</option>
						<option>La Pampa</option>
						<option>La Rioja</option>
						<option>Mendoza</option>
						<option>Misiones</option>
						<option>Neuquen</option>
						<option>Rio Negro</option>
						<option>Salta</option>
						<option>San Juan</option>
						<option>San Luis</option>
						<option>Santa Cruz</option>
						<option>Santa Fe</option>
						<option>Santiago del Estero</option>
						<option>Tierra del Fuego</option>
						<option>Tucuman</option>
						<option>Otros</option>
					</frm:select></td>
				</tr>
				<tr>
					<td align="left">Pais</td>
					<td><frm:input name="pais" id="pais" class="input" value="" size="25" type="text" path="pais"/></td>
				</tr>
				<tr>
					<td align="left">Telefono</td>
					<td><frm:input name="telefono" id="telefono" class="input" value="" size="25" type="text" path="telefono"/></td>
				</tr>
				<tr>
					<td align="left">Email</td>
					<td><frm:input name="email" id="email" class="input" value="" size="25" type="email" path="email"/></td>
				</tr>
				<tr>
				<tr>
					<td align="left">Tipo Usuario</td>
					<td><frm:select id="tipou" path="tipousuario.idTipoUsuario" class="form-control" style="width: 180px;" onchange="mostrararb()">
							<frm:options items="${TipoUsuarioList}" itemLabel="nombre" itemValue="idTipoUsuario"/>
						</frm:select></td>
			         <td><frm:input name="nroarb" id="nroarb" class="input" type="text" size="25" path="arbitro.nroArbitro" style="visibility:hidden;" value="Ingrese Nro Arbitro" onblur="if(this.value==''){ this.value='Ingrese Nro Arbitro';}"
  onfocus="if(this.value=='Ingrese Nro Arbitro'){ this.value='';}"/>
				</tr>
				</table>
				<table>
			    <tr>
			    	<td> <input type="submit" value="Guardar" name="btnguardar"> </td>
			        <td> <input type="reset" value="Limpiar"> </td>
<!-- 			        <td> <input type="button" value="Cancelar"  onclick="javascript:history.go(-1)"> </td> -->
			    </tr>
			    </table>
			    ${Mensaje}
			    </frm:form>
			    </div></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociacion Argentina de Paintball | Sitio Oficial de AAP | Mi Perfil</title>
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
	<frm:form method="post" commandName="usuariom" action="ActualizarUsuario.html">
	<c:if test="${!empty usuariom.arbitro.idArbitro}">
	    <frm:hidden path="arbitro.idArbitro" value="${usuariom.arbitro.idArbitro}"/>
	</c:if>
	
	<frm:hidden path="tipousuario.idTipoUsuario" value="${usuariom.tipousuario.idTipoUsuario}"/>
		<table>
			<tr>
				<td align="left">Nombre de usuario:</td>
				<td><frm:input name="user" id="user" class="input"
						value="${usuariom.usuario}" size="25" type="text" path="usuario" /></td>
			</tr>
			<tr>
				<td align="left">Contraseña</td>
				<td><frm:input name="password" id="contrasena" class="input"
						value="${usuariom.contrasena}" size="25" type="password"
						path="contrasena" /></td>
			</tr>
			<tr>
				<td align="left">Apellido</td>
				<td><frm:input name="lastname" id="lastname" class="input"
						value="${usuariom.apellido}" size="25" type="text" path="apellido" /></td>
			</tr>
			<tr>
				<td align="left">Nombres</td>
				<td><frm:input name="name" id="name" class="input"
						value="${usuariom.nombre}" size="25" type="text" path="nombre" /></td>
			</tr>
			<tr>
					<td align="left">Tipo de Documento</td>
					<td><frm:select name="tipodoc" class="form-control" style="width: 175px;" path="tipoDocumento">
						<c:choose>
						    <c:when test="${empty usuariom.tipoDocumento}">
						        <option selected="selected" value="">Seleccione una opcion</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option value="">Seleccione una opcion</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.tipoDocumento == 'DNI'}">
						        <option selected="selected" value="DNI">DNI</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option value="DNI">DNI</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.tipoDocumento == 'PASAPORTE'}">
						        <option selected="selected" value="PASAPORTE">PASAPORTE</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option value="PASAPORTE">PASAPORTE</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.tipoDocumento == 'CDI'}">
						        <option selected="selected" value="CDI">CDI</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option value="CDI">CDI</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.tipoDocumento == 'CUIT/L'}">
						        <option selected="selected" value="CUIT/L">CUIT/L</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option value="CUIT/L">CUIT/L</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.tipoDocumento == 'OTROS'}">
						        <option selected="selected" value="OTROS">OTROS</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option value="OTROS">OTROS</option>
						        <br />
						    </c:otherwise>
						</c:choose>
					</frm:select></td>
				</tr>
			<tr>
				<td align="left">Numero de Documento</td>
				<td><frm:input name="nrodoc" id="nrodoc" class="input"
						value="${usuariom.nroDocumento}" size="25" type="text"
						onkeypress='return event.charCode >= 48 && event.charCode <= 57'
						path="nroDocumento" /></td>
			</tr>
			<tr>
				<td align="left">Direccion</td>
				<td><frm:input name="address" id="address" class="input"
						value="${usuariom.direccion}" size="25" type="text"
						path="direccion" /></td>
			</tr>
			<tr>
				<td align="left">Localidad</td>
				<td><frm:input name="localidad" id="localidad" class="input"
						value="${usuariom.localidad}" size="25" type="text"
						path="localidad" /></td>
			</tr>
			<tr>
					<td align="left">Provincia</td>
					<td>
					<frm:select name="provincia" class="form-control" style="width: 175px;" path="provincia">
					    <c:choose>
						    <c:when test="${empty usuariom.provincia}">
						        <option selected="selected" value="">Seleccione una opcion</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option value="">Seleccione una opcion</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Buenos Aires'}">
						        <option selected="selected" >Buenos Aires</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Buenos Aires</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Capital Federal'}">
						        <option selected="selected" >Capital Federal</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Capital Federal</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Catamarca'}">
						        <option selected="selected" >Catamarca</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Catamarca</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Chaco'}">
						        <option selected="selected" >Chaco</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Chaco</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Chubut'}">
						        <option selected="selected" >Chubut</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Chubut</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Cordoba'}">
						        <option selected="selected" >Cordoba</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Cordoba</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Corrientes'}">
						        <option selected="selected" >Corrientes</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Corrientes</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Entre Rios'}">
						        <option selected="selected" >Entre Rios</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Entre Rios</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Formosa'}">
						        <option selected="selected" >Formosa</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Formosa</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Jujuy'}">
						        <option selected="selected" >Jujuy</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Jujuy</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'La Pampa'}">
						        <option selected="selected" >La Pampa</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>La Pampa</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'La Rioja'}">
						        <option selected="selected" >La Rioja</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>La Rioja</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Mendoza'}">
						        <option selected="selected" >Mendoza</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Mendoza</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Misiones'}">
						        <option selected="selected" >Misiones</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Misiones</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Neuquen'}">
						        <option selected="selected" >Neuquen</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Neuquen</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Rio Negro'}">
						        <option selected="selected" >Rio Negro</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Rio Negro</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Salta'}">
						        <option selected="selected" >Salta</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Salta</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'San Juan'}">
						        <option selected="selected" >San Juan</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>San Juan</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'San Luis'}">
						        <option selected="selected" >San Luis</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>San Luis</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Santa Cruz'}">
						        <option selected="selected" >Santa Cruz</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Santa Cruz</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Santa Fe'}">
						        <option selected="selected" >Santa Fe</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Santa Fe</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Santiago del Estero'}">
						        <option selected="selected" >Santiago del Estero</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Santiago del Estero</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Tierra del Fuego'}">
						        <option selected="selected" >Tierra del Fuego</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Tierra del Fuego</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Tucuman'}">
						        <option selected="selected" >Tucuman</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Tucuman</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${usuariom.provincia == 'Otros'}">
						        <option selected="selected" >Otros</option> 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        <option>Otros</option>
						        <br />
						    </c:otherwise>
						</c:choose>
					</frm:select></td>
				</tr>
			<tr>
				<td align="left">Pais</td>
				<td><frm:input name="pais" id="pais" class="input"
						value="${usuariom.pais}" size="25" type="text" path="pais" /></td>
			</tr>
			<tr>
				<td align="left">Telefono</td>
				<td><frm:input name="telefono" id="telefono" class="input"
						value="${usuariom.telefono}" size="25" type="text" path="telefono" /></td>
			</tr>
			<tr>
				<td align="left">Email</td>
				<td><frm:input name="email" id="email" class="input" value=""
						size="25" type="email" path="email" /></td>
			</tr>
		</table>
			<div> </div>
				<div><input type="submit" value="Guardar" name="btnguardar">
				<input type="reset" value="Limpiar"></div>
			

		
			    ${Mensaje}
			    </frm:form>
			    </div></div>
</body>
</html>
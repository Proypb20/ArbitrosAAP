<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociacion Argentina de Paintball | Sitio Oficial de AAP | Mostrar Usuarios</title>
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
				<td>${usuarios.tipoDocumento}  ${usuarios.nroDocumento}</td>
				<td>${usuarios.direccion}</td>
				<td>${usuarios.localidad}</td>
				<td>${usuarios.provincia}</td>
				<td>${usuarios.telefono}</td>
				<td>${usuarios.email}</td>
				
				</tr>
				
			</c:forEach>
	</table>
</div></div>
</body>
</html>
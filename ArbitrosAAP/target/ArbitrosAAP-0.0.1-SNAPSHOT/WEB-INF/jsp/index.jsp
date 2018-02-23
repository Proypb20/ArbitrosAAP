<%@ page import="aap.servicio.*"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<%@ page language='java' contentType='text/html' isErrorPage='false' errorPage='error.jsp' %>
<title>Asociacion Argentina de Paintball | Sitio Oficial de AAP | Inscripcion a eventos</title>
<head>
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
         			<a href="http://www.aapaintball.com.ar/" id="logo"><img src="http://www.aapaintball.com.ar/wp-content/uploads/2011/07/logo-aap-paintball-2016-1.png" alt="Asociación Argentina de Paintball" title="Sitio Oficial de AAP"></a>
                </div>
				<div class="clear"></div>
				<div id="widget-header">
				</div><!--#widget-header-->
				<div class="clear"></div>
				<div class="row-top">
			    <div class="clear"></div>
				</div>
</header>
				<frm:form action="BuscarUsuario.html">
					<table>
	  				<tr> 
	  					<td> Usuario:</td>
	  					<td> <frm:input id="usuario" class="input" type="text" path="usuario"/> </td>
	  				</tr>
	  				<tr>
	  					<td> Contraseña: </td>
	  					<td> <frm:input id="password" class="input" path="contrasena" type="password"/> </td>
	       			</tr>
	       			<tr> </tr>
	  				<tr>
	       				<td> <input type="submit" name="btnAceptar" value="Aceptar"> </td>
	  				</tr>
					</table>
				</frm:form>
				<h2>  </h2>
${Mensaje}
</div>
</div>
</body>
</html>

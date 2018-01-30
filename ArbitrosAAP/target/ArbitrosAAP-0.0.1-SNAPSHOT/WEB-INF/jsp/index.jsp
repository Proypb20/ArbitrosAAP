<%@ page import="aap.servicio.*"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<html>
<%@ page language='java' contentType='text/html' isErrorPage='false' errorPage='error.jsp' %>
<title>AsociaciÃ³n Argentina de Paintball | Sitio Oficial de AAP | Inscripcion a eventos</title>
<head>
</head>
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
<h2>  </h2>
<body>
				<frm:form action="BuscarUsuario.html">
					<table>
	  				<tr> 
	  					<td> Usuario:</td>
	  					<td> <frm:input path="usuario"/> </td>
	  				</tr>
	  				<tr>
	  					<td> Contraseña: </td>
	  					<td> <frm:input path="contrasena" type="password"/> </td>
	       			</tr>
	       			<tr> </tr>
	  				<tr>
	       				<td> <input type="submit" name="btnAceptar" value="Aceptar"> </td>
	  				</tr>
					</table>
				</frm:form>
				<h2>  </h2>
${Mensaje}
</body>
</html>

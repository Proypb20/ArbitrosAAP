<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociacion Argentina de Paintball | Sitio Oficial de AAP | Presupuesto</title>
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
	<table border="5px">
		<thead>
			<tr>
			    <td style="width:200px; height:10px" align="center">Torneo</td>
			    <td style="width:200px; height:10px" align="center">Evento</td>
				<td style="width:200px; height:10px" align="center">Apellido y Nombre</td>
				<td style="width:200px; height:10px" align="center">Categoria</td>
				<td style="width:200px; height:10px" align="center">Monto</td>
			</tr>
		</thead>
		    <c:set var="total" value="${0}"/>
			<c:forEach items="${PresupuestoList}" var="presupuesto">
				
				<tr>
				<td>${presupuesto.evento.torneo.nombre}</td>
				<td>${presupuesto.evento.nombre}</td>
				<td>${presupuesto.arbitro.usuario.apellido}, ${presupuesto.arbitro.usuario.nombre}</td>
 				<td>${presupuesto.arbitro.categoria.nombre}</td> 
				<td  align="right">${presupuesto.arbitro.categoria.honorarios}</td>
				</tr>
				 <c:set var="total" value="${total + presupuesto.arbitro.categoria.honorarios}" />
			</c:forEach>
			<tr>
			<td>Total:</td>
			<td></td>
			<td></td>
			<td></td>
			<td align="right">${total}</td>
			</tr>
	</table>	
</div></div>
</body>
</html>
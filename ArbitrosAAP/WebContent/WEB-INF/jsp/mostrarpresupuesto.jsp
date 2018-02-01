<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asociación Argentina de Paintball | Sitio Oficial de AAP | Presupuesto</title>
</head>
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
	<table border="1px">
		<thead>
			<tr>
				<td>Apellido y Nombre</td>
				<td>Categoria</td>
				<td>Honorarios</td>
				<td>Viaticos</td>
				<td>Firma</td>
			</tr>
		</thead>
		
			<c:forEach items="${PresupuestoList}" var="presupuesto">
				
				<tr>
				<td>${presupuesto.arbitro.usuario.apellido}, ${presupuesto.arbitro.usuario.nombre}</td>
				<td>${presupuesto.arbitro.categoria.nombre}</td>
				<td>${presupuesto.arbitro.categoria.honorarios}</td>
				<td>...............</td>
				<td>...............</td>
				
				</tr>
				
			</c:forEach>
	</table>
<!-- 	<input type="button" value="Volver"  onclick="javascript:history.go(-1)"> -->
</body>
</html>
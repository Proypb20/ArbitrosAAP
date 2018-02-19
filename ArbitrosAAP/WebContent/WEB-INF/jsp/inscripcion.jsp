<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<frm:form name="inscripto" action="Inscribir.html" method="post">
<form:hidden path="arbitro.idArbitro" value="${idArbitro}"/>
<table>
				 <tr>
					<td align="left">Torneo</td>
					<td><frm:select path="evento.torneo.idTorneo">
						<frm:options items="${TorneoList}" itemLabel="nombre" itemValue="idTorneo"/>
						</frm:select>
					</td>
				</tr>
				<tr>
					<td align="left">Evento</td>
					<td><frm:select path="evento.idEvento">
						<frm:options items="${EventoList}"  itemLabel="nombre" itemValue="idEvento"/>
						</frm:select>
					</td>
				</tr>
				<tr>
					<td align="left">Vehiculo</td>
					<td><frm:select name="viatico" class="form-control" style="width: 175px;" path="viatico">
						<option selected="selected" value=0>Necesito Transporte</option>
						<option value=1>Poseo Vehiculo-Puedo llevar gente</option>
						<option value=0>Viajo por mis propios medios</option>
					</frm:select></td>
			    <tr>
			    	<td> <input type="submit" value="Aceptar" onclick="validate()"> </td>
			        <td> <input type="reset" value="Limpiar"> </td>
<!-- 			        <td> <input type="button" value="Cancelar"  onclick="javascript:history.go(-1)"> </td> -->
			    </tr>
			    </table>
			    </frm:form>
</body>
</html>
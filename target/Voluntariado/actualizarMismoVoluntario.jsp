<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="beans.VoluntariadoDTO"%>
<%@page import="java.io.*,java.util.*,java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar</title>
</head>
<body>
<jsp:include page="menuAlumno.jsp"/>
<sql:setDataSource driver="com.mysql.jdbc.Driver"
					   url="jdbc:mysql://localhost:3306/bd_sistema"
					   var="localSource"
					   user="root"
					   password="admin123"/>
	<sql:query var="ejemplos" dataSource="${localSource}" sql="select * from tb_actividad"></sql:query>
	
	<%
		VoluntariadoDTO obj = (VoluntariadoDTO) request.getAttribute("Voluntariado");
	%>
<div class="container" style="width:450px">
	<form action="ServletVoluntariado?tipo=actualizarPorVol" id="formulario" method="post">
	<input type="hidden" name="txt_cod" value="${requestScope.Voluntariado.codigo}">
  	<h2>
  	<font color="white" size="5">
  		EDITAR MI PARTICIPACIÓN
  	</font>
  	</h2>
  <p>
  <font color="white" size="2">
  	Llenar el formulario a continuación:
  </font>
  </p>
      <div class="form-group">
      <label for="sel1">
      <font color="white" size="3">
      Actividad:
      </font>
      </label>
      <select name="cbo_actividad"class="form-control" id="sel1">
      <option selected> Seleccionar actividad</option>
        <c:forEach var="ejemplo" begin="0" items="${ejemplos.rows}">
							<option value="${ejemplo.cod_act}">${ejemplo.nom_act}</option>
						</c:forEach>
      </select>
    </div> 
  <div class="form-group">
      <label for="nm">
      <font color="white" size="3">
      Código de Alumno(a):
      </font>
      </label>
      <input type="text" name="txt_alumno" class="form-control" id="nom" class="required" value="${requestScope.Voluntariado.nomAlumno}">
    </div> 
    <button type="submit" class="btn btn-primary">GUARDAR</button>
    <input type="button" value="CANCELAR" class="btn btn-primary" 
			onclick="location.href='http://localhost:8080/Proyecto_Voluntariado/ServletVoluntariado?tipo=porAlumno'"/>
  </form>
  </div>
</body>
</html>
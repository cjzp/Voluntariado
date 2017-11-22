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
<title>Control de Voluntarios</title>
</head>
<body>
<jsp:include page="menuDocente.jsp"/>
<!--<sql:setDataSource driver="com.mysql.jdbc.Driver"
					   url="jdbc:mysql://localhost:3306/bd_sistema"
					   var="localSource"
					   user="root"
					   password="admin123"/>
	<sql:query var="ejemplos" dataSource="${localSource}" sql="select * from tb_actividad"></sql:query>-->
	
	<%
		VoluntariadoDTO obj = (VoluntariadoDTO) request.getAttribute("Voluntariado");
	%>
<div class="container" style="width:450px">
	<form action="ServletVoluntariado?tipo=actualizar" id="formulario" method="post">
	<input type="hidden" name="txt_cod" value="${requestScope.Voluntariado.codigo}">
  	<h2>
  	<font color="white" size="5">
  	CONTROL DE VOLUNTARIOS
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
      <input type="text" name="cbo_actividad" class="form-control" id="text" class="required" value="${requestScope.Voluntariado.nomActividad}">
    </div> 
  <div class="form-group">
      <label for="nm">
      <font color="white" size="3">
      Código del Alumno(a):
      </font>
      </label>
      <input type="text" name="txt_alumno" class="form-control" id="nom" class="required" value="${requestScope.Voluntariado.nomAlumno}">
    </div>
    <div class="form-group">
      <label for="inc">
      <font color="white" size="3">
      Estado de Asistencia:
      </font>
      </label>
      <br>
	<input type="radio" name="r_asistencia" value="Si asistió"><font color="white" size="2">ASISTIDO</font> &#160; &#160; &#160; &#160;
	<input type="radio" name="r_asistencia" value="No asistió"><font color="white" size="2">NO SE PRESENTÓ</font>
    </div>
    <div class="form-group">
      <label for="hrs">
      <font color="white" size="3">
      Horas realizadas:
      </font>
      </label>    
     <select name="txt_horas" class="form-control" id="sel2">
        <option selected>--Cantidad de Horas --</option>
					<option value="1">1 Horas </option>
					<option value="2">2 Horas</option>
	</select>
      <!--<input type="text" name="txt_horas" class="form-control" id="ho" class="required" value="${requestScope.Voluntariado.horas}">-->
    </div>
        <div class="form-group">
      <label for="inc">
      <font color="white" size="3">
     Observaciones:
      </font>
      </label>
      <input type="text" name="txt_justificacion" class="form-control" id="in" class="required" value="${requestScope.Voluntariado.justificacion}">
    </div>
    <button type="submit" class="btn btn-primary">GUARDAR ASISTENCIA</button>
    <input type="button" value="CANCELAR" class="btn btn-primary" 
			onclick="location.href='http://localhost:8080/Proyecto_Voluntariado/ServletVoluntariado?tipo=porActividad'"/>
  </form>
</div>	
</body>
</html>
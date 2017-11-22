<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.io.*,java.util.*,java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registro de Actividad</title>
</head>
<body>
<jsp:include page="menuAdministrador.jsp"/>
<sql:setDataSource driver="com.mysql.jdbc.Driver"
					   url="jdbc:mysql://localhost:3306/bd_sistema"
					   var="localSource"
					   user="root"
					   password="admin123"/>
	<sql:query var="ejemplos" dataSource="${localSource}" sql="select * from tb_institucion"></sql:query>
	<sql:query var="ejemplos2" dataSource="${localSource}" sql="select * from tb_docente"></sql:query>	
<div class="container" style="width:450px">
	<form action="ServletActividad?tipo=registrar" id="formulario" method="post">
  	<h2>
  	<font color="white" size="5">
  	NUEVA ACTIVIDAD
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
      Institución donde se realizará la actividad:
      </font>
      </label>
      <select name="cbo_institucion"class="form-control" id="sel1">
      <option selected> -- Seleccionar Institución --</option>
        <c:forEach var="ejemplo" begin="0" items="${ejemplos.rows}">
							<option value="${ejemplo.cod_ins}">${ejemplo.nom_ins}</option>
						</c:forEach>
      </select>
    </div> 
  <div class="form-group">
      <label for="nm">
      <font color="white" size="3">
      Actividad:
      </font>
      </label>
      <input type="text" class="form-control" id="nom" placeholder="Ingresar nombre de actividad" name="txt_nom">
    </div>
    <div class="form-group">
      <label for="des">
      <font color="white" size="3">
      Descripción:
      </font>
      </label>
      <input type="text" class="form-control" id="de" placeholder="Ingresar descripción" name="txt_des">
    </div>
    <div class="form-group">
      <label for="fe">
      <font color="white" size="3">
      Fecha programada:
      </font>
      </label>
      <input type="date" class="form-control" id="fec" placeholder="Ingresar fecha" name="txt_fecha">
    </div>
    <div class="form-group">
      <label for="sel2">
      <font color="white" size="3">
      Hora de inicio:
      </font>
      </label>
      <select name="cbo_inicio" class="form-control" id="sel2">
        <option selected>-- 00:00 --</option>
					<option value="08:00 AM">08:00 AM</option>
					<option value="09:00 AM">09:00 AM</option>
					<option value="10:00 AM">10:00 AM</option>
					<option value="11:00 AM">11:00 AM</option>
					<option value="12:00 PM">12:00 PM</option>
					<option value="01:00 PM">01:00 PM</option>
					<option value="02:00 PM">02:00 PM</option>
					<option value="03:00 PM">03:00 PM</option>
					<option value="04:00 PM">04:00 PM</option>
					<option value="05:00 PM">05:00 PM</option>
					<option value="07:00 PM">06:00 PM</option>
      </select>
    </div> 
    <div class="form-group">
      <label for="sel3">
      <font color="white" size="3">
      Hora de finalización:
      </font>
      </label>
      <select name="cbo_fin" class="form-control" id="sel3">
        <option selected>-- 00:00 -- </option>
					<option value="08:00 AM">08:00 AM</option>
					<option value="09:00 AM">09:00 AM</option>
					<option value="10:00 AM">10:00 AM</option>
					<option value="11:00 AM">11:00 AM</option>
					<option value="12:00 PM">12:00 PM</option>
					<option value="01:00 PM">01:00 PM</option>
					<option value="02:00 PM">02:00 PM</option>
					<option value="03:00 PM">03:00 PM</option>
					<option value="04:00 PM">04:00 PM</option>
					<option value="05:00 PM">05:00 PM</option>
					<option value="07:00 PM">06:00 PM</option>
      </select>
    </div> 
    <div class="form-group">
      <label for="sel4">
      <font color="white" size="3">
      Docente encargado:
      </font>
      </label>
      <select name="cbo_docente" class="form-control" id="sel4">
      <option selected> -- Seleccionar docente --</option>
        <c:forEach var="ejemplo2" begin="0" items="${ejemplos2.rows}">
							<option value="${ejemplo2.cod_doc}">${ejemplo2.cod_doc}</option>
						</c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">REGISTRAR</button>
    <input type="button" value="CANCELAR" class="btn btn-primary" 
			onclick="location.href='http://localhost:8080/Proyecto_Voluntariado/menuAdministrador.jsp'"/>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="form-inline">
      <label for="sel5">
      <font color="white" size="3">
      Estado actual:
      </font>
      </label>
      <select name="cbo_estado" class="form-control" id="sel5">
					<option value="2">En Revisión</option>
      </select>
      <!--<select name="cbo_estado" class="form-control" id="sel5">
        <option selected> --Seleccione--</option>
					<option value="1">Revisado</option>
					<option value="2">En Revisión</option>
					<option value="3">Descartado</option>
      </select>-->
    </div> 
  </form>
</div>	
</body>
</html>
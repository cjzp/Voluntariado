<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.ActividadDTO"%>
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
<title>Editar Actividad</title>
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
	<%
		ActividadDTO obj = (ActividadDTO) request.getAttribute("Actividad");
	%>
<div class="container" style="width:450px">
	<form action="ServletActividad?tipo=actualizar" id="formulario" method="post">
	<input type="hidden" name="txt_cod" value="${requestScope.Actividad.codigo}">
  	<h2>
  	<font color="white" size="5">
  	EDITAR ACTIVIDAD
  	</font>
  	</h2>
  <p>
  <font color="white" size="2">
  Llenar el formulario a continuación:
  </font>
  </p>
  <div class="form-group">
      <label for="nm">
      <font color="white" size="3">
      Código de Institución:
      </font>
      </label>
      <input type="text" class="form-control" id="text" name="txt_institucion" class="required" value="${requestScope.Actividad.nom_institucion}">
    </div>
  <div class="form-group">
      <label for="nm">
      <font color="white" size="3">
      Actividad:
      </font>
      </label>
      <input type="text" class="form-control" id="text" name="txt_nom" class="required" value="${requestScope.Actividad.nombre}">
    </div>
    <div class="form-group">
      <label for="des">
      <font color="white" size="3">
      Descripción:
      </font>
      </label>
      <input type="text" class="form-control" id="de" name="txt_des" class="required" value="${requestScope.Actividad.descripcion}">
    </div>
    <div class="form-group">
      <label for="fe">
      <font color="white" size="3">
      Fecha programada:
      </font>
      </label>
      <input type="date" class="form-control" id="fec" name="txt_fecha" value="${requestScope.Actividad.fecha}">
    </div>
    <div class="form-group">
      <label for="sel1">
      <font color="white" size="3">
      Hora de inicio:
      </font>
      </label>
      <input type="text" class="form-control" id="sel1" name="txt_inicio" value="${requestScope.Actividad.horaInicio}">
      <!--<select name="cbo_inicio"class="form-control" id="sel1">
       <option selected> 00:00 </option>
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
      </select>-->
    </div> 
    <div class="form-group">
      <label for="sel1">
      <font color="white" size="3">
      Hora de finalización:
      </font>
      </label>
      <input type="text" class="form-control" id="sel1" name="txt_fin" value="${requestScope.Actividad.horaFin}">
      <!--<select name="cbo_fin"class="form-control" id="sel1">
        <option selected> 00:00 </option>
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
      </select>-->
    </div> 
    <div class="form-group">
      <label for="nm">
      <font color="white" size="3">
      Código de Docente encargado:
      </font>
      </label>
      <input type="text" class="form-control" id="text" name="txt_docente" class="required" value="${requestScope.Actividad.nom_docente}">
    </div>
    <div class="form-group">
      <label for="sel1">
      <font color="white" size="3">
      Estado actual:
      </font>
      </label>
      <select name="cbo_estado"class="form-control" id="sel1">
					<option selected> --Seleccione--</option>
						<%
							String estado[]={"","Aprobado","En Revisión","Descartado"};
							String esta="";
							
							for (int i =1; i<estado.length;i++)
							{
								if(obj.getCodEstado()==i)
								{
									esta="selected";
								}
								else
									esta="";
							
						%>
						<option value="<%=i%>" <%=estado%>>
							<%=estado[i]%>
													  
						  <%}%>
						  
						</option>
      </select>
    </div>
    <div class="form-group">
      <label for="mot">
      <font color="white" size="3">
      Motivo de Estado:
      </font>
      </label>
      <input type="text" class="form-control" id="mo" name="txt_motivo" class="required" value="${requestScope.Actividad.motivoEstado}">
    </div> 
    <button type="submit" class="btn btn-primary">GUARDAR</button>
    <input type="button" value="CANCELAR" class="btn btn-primary" 
			onclick="location.href='http://localhost:8080/Proyecto_Voluntariado/ServletActividad?tipo=listar'"/>
  </form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
<%@ page import="beans.VoluntariadoDTO" %>
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
<title>Asistencia de Voluntarios</title>
</head>
<body>
<jsp:include page="menuDocente.jsp"/>
<ul class="pager">
  <li><a href="menuDocente.jsp">«« Atrás</a></li>
</ul>
<sql:setDataSource driver="com.mysql.jdbc.Driver"
					   url="jdbc:mysql://localhost:3306/bd_sistema"
					   var="localSource"
					   user="root"
					   password="admin123"/>
	<sql:query var="ejemplos" dataSource="${localSource}" sql="select * from tb_actividad where cod_estado = 1"></sql:query>
<div class="container">
	<form action="ServletVoluntariado?tipo=porActividad" method="post" class="form-inline">
    <div class="form-group">
    <p>
  <font color="white" size="5">
  CONTROL DE ASISTENCIA DE ALUMNOS
  </font>
  </p>
      <label for="sel1">
      <font color="white" size="3">
      Actividad realizada:
      </font>
      </label>
      <br>
      <select name="cbo_actividad"class="form-control" id="sel1">
      <option selected> -- Seleccionar actividad --</option>
						<c:forEach var="ejemplo" begin="0" items="${ejemplos.rows}">
							<option value="${ejemplo.nom_act}">${ejemplo.nom_act}</option>
						</c:forEach>
      </select>
    <button type="submit" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span>Buscar
    </button>
    </div>
  </form>
</div>
<br>
<div class="container">       
  <table class="table table-bordered" style="width:400px" align="center">
    <thead>
      <tr bgcolor='#111010'>
        <th>
        <font color="white" size="2">
        ACTIVIDAD
        </font>
        </th>
        <th>
        <font color="white" size="2">
        ALUMNO(A)
        </font>
        </th>
        <!--
        <font color="white" size="2">
        ESTADO DE ASISTENCIA
        </font>
        </th>
        <th>
        <font color="white" size="2">
        OBSERVACIONES
        </font>
        </th>
        <th>
        <font color="white" size="2">
        HORAS REALIZADAS
        </font>
        </th>-->
        <th colspan="2">
        <font color="white" size="2">
        ASISTENCIA
        </font>
        </th>
      </tr>
    </thead>
			<%
				ArrayList<VoluntariadoDTO> lista=(ArrayList<VoluntariadoDTO>) request.getAttribute("data");
			if(lista!=null)
			{
				for(VoluntariadoDTO xDoc:lista)
				{
					out.println("<tr>");
					out.println("<tr bgcolor='#FAFAFA'>");
					out.println("<td>"+xDoc.getNomActividad()+"</td>");
					out.println("<td>"+xDoc.getNomAlumno()+"</td>");
					/*out.println("<td>"+xDoc.getAsistencia()+"</td>");
					out.println("<td>"+xDoc.getJustificacion()+"</td>");
					out.println("<td>"+xDoc.getHoras()+"</td>");*/
					out.println("<td align='center'><a href='ServletVoluntariado?tipo=buscar&cod="+xDoc.getCodigo()+"'>"+
							"<img src='img/check.gif' title='Marcar Asistencia'></a></td>");
							/*out.println("<td align='center'><a href='ServletVoluntariado?tipo=eliminar&cod="+
								xDoc.getCodigo()+"'>"+"<img src='img/delete.gif' title='Eliminar'></a></td>");*/
							out.println("</tr>");
						
					out.println("</tr>");
					out.println("</tbody>");	
				}
			}
			%>
	</table>
	<div align="center">
	<ul class="pagination">
  	<li><a href="#">1</a></li>
  	<li><a href="#">2</a></li>
	</ul>
	</div>
	</div>
</body>
</html>
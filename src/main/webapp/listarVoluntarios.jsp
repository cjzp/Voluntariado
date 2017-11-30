<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
<%@ page import="beans.VoluntariadoDTO"%>
<%@ page import="beans.ActividadDTO"%>
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
<title>Lista de Voluntarios</title>
</head>
<body>
<jsp:include page="menuAlumno.jsp"/>
<ul class="pager">
  <li><a href="menuAlumno.jsp">«« Atrás</a></li>
</ul>

<div class="container">
	<form action="ServletVoluntariado?tipo=porActividadVol" method="post" class="form-inline">
    <div class="form-group">
    <p>
  <font color="white" size="5">
  VOLUNTARIOS REGISTRADOS
  </font>
  </p>
      <label for="sel1">
      <font color="white" size="3">
      Actividad:
      </font>
      </label>
      <br>
      <select name="cbo_actividad"class="form-control" id="sel1">
      <option selected> -- Seleccionar actividad --</option>
								
      <% 
      
      ArrayList<ActividadDTO> acts=(ArrayList<ActividadDTO>) request.getAttribute("acts");
      
      if(acts!=null)
      {    	 
      	for(ActividadDTO act : acts) 
      	{
          	  out.println("<option value='" + act.getNombre() +"'>" +act.getNombre() +    "</option>");
      		
      	}
      	
      }
      %>
      </select>
    <button type="submit" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span>Buscar
    </button>
    </div>
  </form>
</div>
<br>
<div class="container">
  <h3>
  <font color="white" size="5">
  LISTA DE VOLUNTARIOS
  </font>
  </h3>          
  <table class="table table-bordered" style="width:500px" align="center">
    <thead>
      <tr bgcolor='#111010'>
        <th>
        <font color="white" size="2">
        ACTIVIDAD
        </font>
        </th> 
        <th>
        <font color="white" size="2">
        ALUMNO(A) VOLUNTARIO
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
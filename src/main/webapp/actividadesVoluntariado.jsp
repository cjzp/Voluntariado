<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="beans.ActividadDTO" %>    
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
<title>Lista de Actividades</title>
</head>
<body>
<jsp:include page="menuAlumno.jsp"/>
<ul class="pager">
  <li><a href="ServletActividad?tipo=listarVol">PARTICIPAR</a></li>
</ul>
<div class="container">

	<%
		String mensaje ="";
		if(! (request.getAttribute("mensaje") == null))
		{
			 mensaje = (String) request.getAttribute("mensaje");
			out.println(" <font color=\"red\" size=\"8\">" +mensaje+ "</font>" );
		}
		
		
	%>
  <h3>
  <font color="white" size="5">
  LISTA DE ACTIVIDADES
  </font>
  </h3>          
  <table class="table table-bordered">
    <thead>
      <tr bgcolor='#111010'>
        <th>
        <font color="white" size="2">
        ACTIVIDAD
        </font>
        </th>
        <th>
        <font color="white" size="2">
        DESCRIPCIÓN DE ACTIVIDAD
        </font>
        </th>
        <th>
        <font color="white" size="2">
        INSTITUCIÓN
        </font>
        </th>
        <th>
        <font color="white" size="2">
        FECHA
        </font>
        </th>
        <th>
        <font color="white" size="2">
        HORA DE INICIO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        HORA FIN
        </font>
        </th>
        <th>
        <font color="white" size="2">
        DOCENTE ENCARGADO
        </font>
        </th>
      </tr>
    </thead>
			<%
				ArrayList<ActividadDTO> lista=(ArrayList<ActividadDTO>) request.getAttribute("data");
			if(lista!=null)
			{
				for(ActividadDTO xDoc:lista)
				{
					out.println("<tr>");
					out.println("<tr bgcolor='#FAFAFA'>");
					out.println("<td>"+xDoc.getNombre()+"</td>");
					out.println("<td>"+xDoc.getDescripcion()+"</td>");
					out.println("<td>"+xDoc.getNom_institucion()+"</td>");
					out.println("<td>"+xDoc.getFecha()+"</td>");
					out.println("<td>"+xDoc.getHoraInicio()+"</td>");
					out.println("<td>"+xDoc.getHoraFin()+"</td>");
					out.println("<td>"+xDoc.getNom_usuario()+"</td>");	
					out.println("</tr>");
					out.println("</tbody>");
				}
			}
			%>
			</table>
	</div>
</body>
</html>
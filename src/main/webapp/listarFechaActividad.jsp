<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="beans.ActividadDTO" %>
<%@page import="java.io.*,java.util.*,java.sql.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Fecha programada</title>
</head>
<body>
<jsp:include page="menuDocente.jsp"/>
<ul class="pager">
  <li><a href="menuDocente.jsp">«« Atrás</a></li>
</ul>
<div class="container">
	<form action="ServletActividad?tipo=porFecha" method="post" class="form-inline">	
    <div class="form-group">
        <p>
  			<font color="white" size="5">
  				ACTIVIDADES
  			</font>
  		</p>
      <label for="sel1">
      <font color="white" size="3">
      Fecha programada:
      </font>
      </label>
      <br>
      <input type="date" class="form-control" id="nom" placeholder="Ingresar la fecha" name="txt_fecha">
    <button type="submit" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span> Buscar
    </button>
    </div>
  </form>
</div>
<br>
<div class="container">
<h3>
  <font color="white" size="5">
  ACTIVIDADES POR FECHA
  </font>
  </h3>        
  <table class="table table-bordered" style="width:900px" align="center">
    <thead>
      <tr bgcolor='#111010'>
      	<th>
        <font color="white" size="2">
        FECHA
        </font>
        </th>
        <th>
        <font color="white" size="2">
        INSTITUCIÓN
        </font>
        </th>
        <th>
        <font color="white" size="2">
        ACTIVIDAD
        </font>
        </th>
        <!--</th>
        <th colspan="2">
        <font color="white" size="2">
        ACCIONES
        </font>
        </th>  -->
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
					out.println("<td>"+xDoc.getFecha()+"</td>");
					out.println("<td>"+xDoc.getNom_institucion()+"</td>");
					out.println("<td>"+xDoc.getNombre()+"</td>");
					//out.println("<td>"+xDoc.getDescripcion()+"</td>");
					//out.println("<td align='center'><a href='ServletActividad?tipo=buscar&cod="+xDoc.getCodigo()+"'>"+
					//		"<img src='img/edit.gif' title='Editar'></a></td>");
					//		out.println("<td align='center'><a href='ServletActividad?tipo=eliminar&cod="+
					//			xDoc.getCodigo()+"'>"+"<img src='img/delete.gif' title='Eliminar'></a></td>");
					//		out.println("</tr>");
						
					out.println("</tr>");
					out.println("</tbody>");	
				}
			}
			%>
	</table>
	</div>		
</body>
</html>
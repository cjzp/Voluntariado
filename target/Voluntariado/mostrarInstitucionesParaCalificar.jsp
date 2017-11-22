<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="beans.InstitucionNombresDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<title>Listado de Instituciones</title>
</head>
<body>
<jsp:include page="menuAdministrador.jsp"/>
<ul class="pager">
  <li><a href="menuAdministrador.jsp">RETROCEDER</a></li>
</ul>
<div class="container">
  <h3>
  <font color="white" size="5">
  LISTA DE INSTITUCIONES
  </font>
  </h3>          
  <table class="table table-bordered">
    <thead>
      <tr bgcolor='#111010'>
        <th>
        <font color="white" size="2">
        INSTITUCIÓN
        </font>
        </th>
        <th colspan="1">
        <font color="white" size="1">
        ACCIONES
        </font>
        </th>
      </tr>
    </thead>
			<%
				ArrayList<InstitucionNombresDTO> lista=(ArrayList<InstitucionNombresDTO>) request.getAttribute("data");
			if(lista!=null)
			{
				for(InstitucionNombresDTO xDoc:lista)
				{
					out.println("<tbody>");
					out.println("<tr>");
					out.println("<tr bgcolor='#FAFAFA'>");
					out.println("<td align='center'>"+xDoc.getNombre()+"</td>");
					out.println("<td align='center'><a href='ServletInstitucion?tipo=buscarCOD&cod="+xDoc.getCodigo()+"'>"+
							"Registrar</a></td>");
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
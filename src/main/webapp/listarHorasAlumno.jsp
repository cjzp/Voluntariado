<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
<%@ page import="beans.VoluntariadoDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Horas de Alumno</title>
</head>
<body>
<jsp:include page="menuDocente.jsp"/>
<ul class="pager">
  <li><a href="menuDocente.jsp">�� Atr�s</a></li>
</ul>
	
<div class="container">
	<form action="ServletVoluntariado?tipo=horasAlumno" method="post" class="form-inline">
    <div class="form-group">
    <p>
  <font color="white" size="5">
  INGRESAR C�DIGO DE ALUMNO
  </font>
  </p>
      <label for="sel1">
      <font color="white" size="3">
      C�digo:
      </font>
      </label>
      <br>
      <input type="text" name="txt_codigo" class="form-control" id="text" class="required">
    <button type="submit" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span>Ver todas
    </button>
    </div>
  </form>
</div>
<br>
<div class="container">       
  <table class="table table-bordered" style="width:500px" align="center">
    <thead>
      <tr bgcolor='#111010'>
      <th>
      <font color="white" size="2">
        NOMBRE ALUMNO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        TOTAL DE HORAS
        </font>
        </th>
        <th>
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
					out.println("<td>"+xDoc.getNomAlumno()+"</td>");
					out.println("<td>"+xDoc.getHoras()+"</td>");					
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
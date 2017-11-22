<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
<%@ page import="beans.ReporteAlumnoDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Buscar por Sección</title>
</head>
<body>
<jsp:include page="menuDocente.jsp"/>
<ul class="pager">
  <li><a href="menuDocente.jsp">«« Atrás</a></li>
</ul>
	
<div class="container">
	<form action="ServletDocente?tipo=porSeccion" method="post" class="form-inline">
    <div class="form-group">
    <p>
  <font color="white" size="5">
  BUSCAR VOLUNTARIOS
  </font>
  </p>
      <label for="sel1">
      <font color="white" size="3">
      Sección:
      </font>
      </label>
      <br>
      <select name="cbo_seccion" class="form-control" >
					<option value="TA01">TA01</option>
					<option value="ASA01">ASA01</option>
					<option value="AEA01">AEA01</option>
					<option value="CA01">CA01</option>
	  </select>
    <button type="submit" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span> Buscar
    </button>
    </div>
  </form>
</div>
<br>
<div class="container">       
  <table class="table table-bordered" style="width:800px" align="center">
    <thead>
      <tr bgcolor='#111010'>
        <th>
        <font color="white" size="2">
        CODIGO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        NOMBRE
        </font>
        </th>
        <th>
        <font color="white" size="2">
        APELLIDO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        CARRERA
        </font>
        </th>
        <th>
        <font color="white" size="2">
        SECCION
        </font>
        </th>
        <th>
        <font color="white" size="2">
        TELEFONO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        CORREO
        </font>
        </th>
      </tr>
    </thead>
			<%
				ArrayList<ReporteAlumnoDTO> lista=(ArrayList<ReporteAlumnoDTO>) request.getAttribute("data");
			if(lista!=null)
			{
				for(ReporteAlumnoDTO xDoc:lista)
				{
					out.println("<tr>");
					out.println("<tr bgcolor='#FAFAFA'>");
					out.println("<td>"+xDoc.getCodigo()+"</td>");
					out.println("<td>"+xDoc.getNombre()+"</td>");
					out.println("<td>"+xDoc.getApellido()+"</td>");
					out.println("<td>"+xDoc.getCarrera()+"</td>");
					out.println("<td>"+xDoc.getSeccion()+"</td>");
					out.println("<td>"+xDoc.getTelefono()+"</td>");
					out.println("<td>"+xDoc.getCorreo()+"</td>");
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
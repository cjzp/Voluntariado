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
<title>Estado de Actividad</title>
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
	<sql:query var="ejemplos" dataSource="${localSource}" sql="select * from tb_estado"></sql:query>
<div class="container">
	<form action="ServletActividad?tipo=porEstado" method="post" class="form-inline">	
    <div class="form-group">
        <p>
  			<font color="white" size="5">
  				CONTROL DE ACTIVIDAD
  			</font>
  		</p>
      <label for="sel1">
      <font color="white" size="3">
      Estado de Actividad:
      </font>
      </label>
      <br>
      <select name="cbo_estado"class="form-control" id="sel1">
      <option selected> -- Seleccionar estado --</option>
        <c:forEach var="ejemplo" begin="0" items="${ejemplos.rows}">
							<option value="${ejemplo.nom_estado}">${ejemplo.nom_estado}</option>
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
<h3>
  <font color="white" size="5">
  ACTIVIDADES POR ESTADO
  </font>
  </h3>        
  <table class="table table-bordered" style="width:900px" align="center">
    <thead>
      <tr bgcolor='#111010'>
      	<th>
        <font color="white" size="2">
        ESTADO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        MOTIVO DE ESTADO
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
					out.println("<td>"+xDoc.getNombreEstado()+"</td>");
					out.println("<td>"+xDoc.getMotivoEstado()+"</td>");
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
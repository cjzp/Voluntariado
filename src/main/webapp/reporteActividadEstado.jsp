<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="beans.ReporteActividadDTO" %>
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

<div class="container">
	<form action="ServletDocente?tipo=estado" method="post" class="form-inline">	
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
        <option value="Aprobado">Aprobado</option>
        <option value="En Revisión">En Revisión</option>
        <option value="Descartado">Descartado</option>

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
        INSTITUCION
        </font>
        </th>
        <th>
        <font color="white" size="2">
        ACTIVIDAD
        </font>
        </th>
        <th>
        <font color="white" size="2">
        DESCRIPCION
        </font>
        </th>
        <th>
        <font color="white" size="2">
        FECHA
        </font>
        </th>
        <th>
        <font color="white" size="2">
        HORA INICIO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        HORA FIN
        </font>
        </th>
        <th>
        <font color="white" size="2">
        DOCENTE
        </font>
        </th>
        <th>
        <font color="white" size="2">
        ESTADO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        MOTIVO
        </font>
        </th>
        <th>
        <font color="white" size="2">
        VACANTES
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
				ArrayList<ReporteActividadDTO> lista=(ArrayList<ReporteActividadDTO>) request.getAttribute("data");
			if(lista!=null)
			{
				for(ReporteActividadDTO xDoc:lista)
				{

					out.println("<tr>");
					out.println("<tr bgcolor='#FAFAFA'>");
					out.println("<td>"+xDoc.getNom_institucion()+"</td>");
					out.println("<td>"+xDoc.getNom_actividad()+"</td>");
					out.println("<td>"+xDoc.getDesc_act()+"</td>");
					out.println("<td>"+xDoc.getFecha_act()+"</td>");
					out.println("<td>"+xDoc.getHoraInicio()+"</td>");
					out.println("<td>"+xDoc.getHoraFin()+"</td>");
					out.println("<td>"+xDoc.getNom_docente()+"</td>");
					out.println("<td>"+xDoc.getNom_estado()+"</td>");
					out.println("<td>"+xDoc.getMotivo_estado()+"</td>");
					out.println("<td>"+xDoc.getVacantes()+"</td>");
					out.println("</tr>");
					out.println("</tbody>");	
				}
			}
			%>
	</table>
	</div>		
</body>
</html>
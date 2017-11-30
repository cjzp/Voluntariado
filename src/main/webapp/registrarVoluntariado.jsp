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
<title>Voluntariado</title>
</head>

<jsp:include page="menuAlumno.jsp"/>

 <body>  

<ul class="pager">
  <li><a href="ServletActividad?tipo=listarActividadVol">VER ACTIVIDADES</a></li>
</ul>


<div class="container" style="width:450px">


	<form action="ServletVoluntariado?tipo=registrar" id="formulario" method="post">	
  <p>
  <font color="white" size="3">
  Para participar llena el formulario a continuación:
  </font>
  </p>
  <div class="form-group">
      <label for="nm">
      <font color="white" size="3">
      Mí código:
      </font>
      </label>
      <%
		String valores = null;
		if(session.getAttribute("datos")==null)
			pageContext.forward("ServletUsuario?tipo=cerrarSesion");
		else{
			valores = (String)session.getAttribute("usuario");
		}
		
	/*
			ArrayList<?> acts = (ArrayList<?>)request.getAttribute("data");
			ActividadDTO act = (ActividadDTO) acts.get(0);*/
			ArrayList<ActividadDTO> acts = (ArrayList<ActividadDTO>)request.getAttribute("data");
	
			Map<ActividadDTO,Integer> mapa = (Map<ActividadDTO,Integer>) request.getAttribute("mapa");
			
					
		
	%>
      <input type="text" name="txt_alumno" class="form-control required" id="text" value=<%=valores %>>
    </div>
    <div class="form-group">
      <label for="sel1">
      <font color="white" size="3">
      Actividad a participar:
      </font>
      </label>
      <select name="cbo_actividad" class="form-control" id="sel1">
      <option selected> Seleccionar actividad</option>
      
      
			
      <% 
      if(acts!=null)
      {    	 
      	for(ActividadDTO act : acts) 
      	{
          	  out.println("<option value='" + act.getCodigo()  +"'>" +act.getNombre() + "     vacantes: "+ mapa.get(act)+    "</option>");
      		
      	}
      	
      }
      %>
    
      </select>
        
  
      <br>
      
      <!--
      <select disabled class="form-control" id="vac">
      <option selected> Vacantes</option>      
			
      <% 
      /*
      if(!mapa.isEmpty())
      {    	 
      	for(ActividadDTO act : acts) 
      	{
          	  out.println("<option value='" + mapa.get(act) +"'>" + mapa.get(act)  + "</option>");
      		
      	}
      	
      }*/
      %>
    
      </select>
      -->
    
    </div> 
    <button type="submit"  class="btn btn-primary">REGISTRARME</button>
    <input type="button" value="CANCELAR" class="btn btn-primary" 
			onclick="location.href='http://localhost:8080/Voluntariado/menuAlumno.jsp'"/>
  </form>
</div>
<br>
<div class="container">
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
					//out.println("</tbody>");
				}
			}
			%>
			
			</table>
	</div>
		<!-- 
	<script>
			

			jQuery.noConflict();
			
			jQuery(document).ready(function(){
			    
							
				jQuery("#sel1").change(function(){
					var n = jQuery(".index").text();
					
					  jQuery("#vacantes").text(n);
					
				});
				
			});
			
				
			
			</script>
	
			-->
			
	
</body>



</html>
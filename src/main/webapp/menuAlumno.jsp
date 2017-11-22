<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Menu Alumno</title>
</head>
<body background="img/DSC_2298.JPG">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <img src="img/logov.png">
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="menuAlumno">Inicio</a></li>
      <li><a href="ServletActividad?tipo=listarActividadVol">Ver actividades</a></li>
      <li><a href="listarVoluntarios.jsp">Ver Voluntarios</a></li>
      <li><a href="verParticipacionesRealizadas.jsp">Mis participaciones</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
    <%
	String valores = null;
		if(session.getAttribute("datos")==null)
			pageContext.forward("ServletUsuario?tipo=cerrarSesion");
		else{
			valores = (String)session.getAttribute("nombre");
		}
	%>

      <li><a href="#"><span class="glyphicon glyphicon-user"></span>
      <font color="white" size="3"> 
      <%=valores %>
      </font>
      </a></li>
      
     
      <li><a href="ServletUsuario?tipo=cerrarSesion"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesión</a></li>
    </ul>
  </div>
</nav>
<br>
</body>
</html>
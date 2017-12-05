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
<title>Menu Administrador</title>
</head>
<body background="img/DSC_2297.jpg">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <img src="img/logov.png">
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="menuAdministrador.jsp">Inicio</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Instituciones <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="registrarInstitucion.jsp">Registrar Institución</a></li>
          <li><a href="ServletInstitucion?tipo=listarIns">Lista de Instituciones</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Actividades <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="registrarActividad.jsp">Registrar Actividad</a></li>
          <li><a href="ServletActividad?tipo=listar">Lista de Actividades</a></li>
        </ul>
      </li> 
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Registro <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="registrarUsuario.jsp">Registrar Docente</a></li>
          <li><a href="registrarAlumno.jsp">Registrar Alumno</a></li>
        </ul>
      </li>  
	    <!-- DANTE -->
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Comentarios y Calificación <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="ServletInstitucion?tipo=insNombres">Registrar</a></li>
          <li><a href="ServletInstitucion?tipo=reporteComentarios">Ver Reporte</a></li>
        </ul>
      </li>  
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
</body>
</html>

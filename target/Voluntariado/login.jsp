<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ufc-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Iniciar Sesión</title>
</head>
<body background="img/fondologin.png">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <img src="img/logov.png">
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Inicio</a></li>
   		<li><a href="#">¿Quiénes somos?</a></li>
         <li><a href="#">Haz voluntariado</a></li>
         <li><a href="#">Comentarios</a></li>
         <li><a href="#">Visión y Misión</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Registrate</a></li>
      <li class="active"><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesión</a></li>
    </ul>
  </div>
</nav>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <h3>
      <font color="white" size="5">
      Beneficios de ser voluntario:
      </font>
      </h3>
      <br>
      <p>
      <font color="white" size="3">
      Desarrollar capacidades y aptitudes para mejorar como persona y como profesional.
      </font>
      </p>
      <p>
      <font color="white" size="3">
      Conocer y compartir con personas poniendo en practica los valores como la solidaridad, el trabajo en equipo y compromiso social.
      </font>
      </p>
      <p>
      <font color="white" size="3">
      Experiencia inolvidable junto a tus compañeros y amigos.
      </font>
      </p>
      <p>
      <font color="white" size="3">
      Validar horas de voluntariado como puntaje para algún curso.
      </font>
      </p>
      <p>
      <font color="white" size="3">
      Formar parte de un Proyecto que ayude a los que más lo necesitan.
      </font>
      </p>
    </div>
    <div class="container" style="width:310px">
	<br>
	<br>
  <form action="ServletUsuario?tipo=sesion" name="frmSesion" method="post">
    <div class="form-group">
      <label for="text">
      <font color="white" size="3">
      Usuario:
      </font>
      </label>
      <input type="text" class="form-control" id="text" placeholder="Ingresar usuario" name="txt_login">
    </div>
    <div class="form-group">
      <label for="pwd">
      <font color="white" size="3">
      Contraseña:
      </font>
      </label>
      <input type="password" class="form-control" id="pwd" placeholder="Ingresar contraseña" name="txt_pass">
    </div>
    <p>
    <font color="red" size="2">
				${requestScope.msg}
	</font>
	</p>
    <div class="checkbox">
      <label><input type="checkbox" name="remember">
      <font color="white" size="2">
      Recordar usuario
      </font>
      </label>
    </div>
    <button type="submit" class="btn btn-success">INICIAR SESIÓN</button>
  </form>
</div>
  </div>
</div>
</body>
</html>
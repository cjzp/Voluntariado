<%@page import="beans.ComentariosDTO"%>
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
<title>Registrar Comentarios y Calificaciones a Institucion</title>
</head>
<body>
	<jsp:include page="menuAdministrador.jsp"/>
	<%
	ComentariosDTO obj = (ComentariosDTO) request.getAttribute("Institucion");
	%>
<div class="container" style="width:450px">
	<form action="ServletInstitucion?tipo=registrarComentarios" method="post">
	<input type="hidden" name="txt_cod" value="${requestScope.Institucion.codigo}">
  	<h2>
  	<font color="white" size="5">
  	REGISTRAR CALIFICACION INSTITUCIÓN
  	</font>
  	</h2>
  <p>
  <font color="white" size="2">
  Llenar el formulario a continuación:
  </font>
  </p>
  <div class="form-group">
      <label for="nm">
      <font color="white" size="3">
      Comentarios:
      </font>
      </label>
      <input type="text" name="txt_comentarios" class="form-control" id="text" value="${requestScope.Institucion.comentarios}">
    </div>
    <div class="form-group">
      <label for="crt">
      <font color="white" size="3">
      Calificación:
      </font>
      </label>
      <input type="text" name="txt_calificacion" class="form-control" id="text"  value="${requestScope.Institucion.calificacion}"> 
    </div>
    
    <button type="submit" class="btn btn-primary">REGISTRAR</button>
    <input type="button" value="CANCELAR" class="btn btn-primary" 
			onclick="location.href='http://localhost:8080/Voluntariado/ServletInstitucion?tipo=insNombres'"/>
  </form>
</div>		
</body>
</html>

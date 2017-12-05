<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.InstitucionDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Actualizar Institucion</title>
</head>
<body>
	<jsp:include page="menuAdministrador.jsp"/>
	<%
		InstitucionDTO obj = (InstitucionDTO) request.getAttribute("Institucion");
	%>
<div class="container" style="width:450px">
	<form action="ServletInstitucion?tipo=actualizar" method="post">
	<input type="hidden" name="txt_cod" value="${requestScope.Institucion.codigo}">
  	<h2>
  	<font color="white" size="5">
  	EDITAR INSTITUCIÓN
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
      Nombre de la Institución:
      </font>
      </label>
      <input type="text" name="txt_nombre" class="form-control" id="text" value="${requestScope.Institucion.nombre}">
    </div>
    <div class="form-group">
      <label for="crt">
      <font color="white" size="3">
      Caracteristicas:
      </font>
      </label>
      <input type="text" class="form-control" id="ca" name="txt_carac" value="${requestScope.Institucion.caracteristicas}"> 
    </div>
    <div class="form-group">
      <label for="dr">
      <font color="white" size="3">
      Dirección:
      </font>
      </label>
      <input type="text" name="txt_direccion" class="form-control" id="dir" value="${requestScope.Institucion.direccion}"> 
    </div>
    <div class="form-group">
      <label for="tlf">
      <font color="white" size="3">
      Teléfono:
      </font>
      </label>
      <input type="text" name="txt_fono" class="form-control" id="fono" value="${requestScope.Institucion.telefono}">
    </div>
    
    <button type="submit" class="btn btn-primary">GUARDAR</button>
    <input type="button" value="CANCELAR" class="btn btn-primary" 
			onclick="location.href='http://localhost:8080/Voluntariado/ServletInstitucion?tipo=listar'"/>
  </form>
</div>		
</body>
</html>
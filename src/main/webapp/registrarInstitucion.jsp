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
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script> <!-- jquery   -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.js"></script> <!--  jquery validate -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/additional-methods.js"></script> <!--  aditional methods -->
<script type="text/javascript">

$(document).ready(function()
		{
			$("#formulario").validate( {
				rules:
				{
					txt_nombre:{
						required:true,
						number:true,
						maxlength:7,
					},
					txt_carac:{
						required:true,
						number:true,
						maxlength:7,
					},
					
					txt_direccion:{
						required:true,
						lettersonly:true,
						maxlength:40,
						minlength:5
					},
					txt_fono:{
						required:true
					},
				},
				
				messages: 
				{
					txt_nombre:{
						required:"Este campo es requerido",
					},
					txt_carac:{
						required:"Este campo es requerido",
					},
					txt_direccion:{
						required:"Este campo es requerido",
					},
					txt_fono:{
						required:"Este campo es requerido"
					},
				}
			});
		
		});
	</script>

	<style type="text/css">
		.error{color:;}
	</style>
<title>Registro de Institución</title>
</head>
<body>
<jsp:include page="menuAdministrador.jsp"/>
<div class="container" style="width:450px">
	<form action="ServletInstitucion?tipo=registrar" id="formulario" method="post">
  	<h2>
  	<font color="white" size="5">
  	NUEVA INSTITUCIÓN
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
      <input type="text" class="form-control" id="nom" placeholder="Ingresar nombre" name="txt_nombre" class="required">
    </div>
    <div class="form-group">
      <label for="crt">
      <font color="white" size="3">
      Características:
      </font>
      </label>
      <input type="text" class="form-control" id="car" placeholder="Ingresar caracteristicas" name="txt_carac" class="required">
    </div>
    <div class="form-group">
      <label for="dr">
      <font color="white" size="3">
      Dirección:
      </font>
      </label>
      <input type="text" class="form-control" id="dir" placeholder="Ingresar dirección" name="txt_direccion" class="required">
    </div>
    <div class="form-group">
      <label for="tlf">
      <font color="white" size="3">
      Teléfono:
      </font>
      </label>
      <input type="text" class="form-control" id="fono" placeholder="Ingresar telefono" name="txt_fono" class="required">
    </div>  
    <button type="submit" class="btn btn-primary">REGISTRAR</button>
    <input type="button" value="CANCELAR" class="btn btn-primary" 
			onclick="location.href='http://localhost:8080/Proyecto_Voluntariado/menuAdministrador.jsp'"/>
  </form>
</div>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
    <head>
  <meta charset="utf-8">
  <title>Registrar Docentes</title>
  <script  type="text/javascript" src="./jquery/jquery-3.2.1.min.js"></script>
  <script  type="text/javascript" src="./jquery/jquery-ui-1.12.1/jquery-ui.js"></script>
  <script  type="text/javascript" src="./js/bootstrap.js"></script>

  <link rel="stylesheet" type="text/css" href="./css/estilo.css">
  <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.css">
</head>
	<body background="img/DSC_2297.jpg">
		<div>
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<br><br>
	               		<h1 class="title" id="label-font">REGISTRO DE DOCENTES</h1>
	               		<hr />
	               	</div>
	            </div>
	            <div>
		            <div class="col-sm-3"></div> 
		           
		           <form action="ServletDocente?tipo=registrar"> 
					<div class="col-sm-6 form-group">
						<div class="form-group">
						  <input class="form-control" id="codigo" name="codigo" placeholder="Código Docente" type="text" required>
						</div>
						<div class="form-group">
						  <input class="form-control" id="nombre" name="nombre" placeholder="Nombre Docente" type="text" required>
						</div>
	                    <div class="form-group">
						  <input class="form-control" id="fono" name="fono" placeholder="Teléfono Docente" type="text" required>
						</div>
	                    <div class="form-group">
						  <input class="form-control" id="correo" name="correo" placeholder="Correo Docente" type="text" required>						
						</div>
						<br>	
						<div class="form-group ">
								<button type="button" class="btn btn-primary btn-lg btn-block login-button">Guardar</button><br>
								<button type="submit" class="btn btn-primary btn-lg btn-block login-button" formaction="menuAdministrador.jsp" formnovalidate>Cancelar</button>							
						</div>
					</div>
					</form>
				
				</div>		
					
			</div>
		</div>
	</body>
</html>
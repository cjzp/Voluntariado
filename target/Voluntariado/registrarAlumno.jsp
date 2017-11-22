<!DOCTYPE html>
<html lang="en">
    <head>
  <meta charset="utf-8">
  <title>Registrar Alumno</title>
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
	               <br>
	               		<h1 class="title" id="label-font">REGISTRO DE ALUMNOS</h1>
	               		<hr />
	               	</div>
	            </div>
	            <div>
		            <div class="col-sm-3"></div> 
		           
		           <form action=ServletAlumno?tipo=registrar method="post">
					<div class="col-sm-6 form-group">
					<br><br>
	                	<div class="form-group">
						  <input class="form-control" id="codigo" name="codigo" placeholder="Código Alumno" type="text" 			required>
						</div>
						<div class="form-group">
						  <input class="form-control" id="nombre" name="nombre" placeholder="Nombre Alumno" type="text" required>
						</div>
						<div class="form-group">
						  <input class="form-control" id="apePaterno" name="apePaterno" placeholder="Apellido Paterno Alumno" type="text" required>
						</div>
						<div class="form-group">
						  <input class="form-control" id="apeMaterno" name="apeMaterno" placeholder="Apellido Materno Alumno" type="text" required>
						</div>
						
						<div class="form-group">
							<select name="cbo_carrera"class="form-control" id="sel1">
							      <option selected> Carrera</option>
													<c:forEach var="ejemplo" begin="0" items="${ejemplos.rows}">
														<option value="${ejemplo.nom_car}">${ejemplo.nom_car}</option>
													</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<select name="cbo_seccion"class="form-control" id="sel1">
							      <option selected> Sección</option>
													<c:forEach var="ejemplo" begin="0" items="${ejemplos.rows}">
														<option value="${ejemplo.nom_sec}">${ejemplo.nom_sec}</option>
													</c:forEach>
							</select>
						</div>						


						<div class="form-group">
						  <input class="form-control" id="fono" name="fono" placeholder="Teléfono Alumno" type="text" required>
						</div>
	                    <div class="form-group">
						  <input class="form-control" id="correo" name="correo" placeholder="Correo Alumno" type="text" required>
						</div><br>	
						<div class="form-group ">
								<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Guardar</button><br>
								<button type="submit" class="btn btn-primary btn-lg btn-block login-button" formaction="menuAdministrador.jsp" formnovalidate>Cancelar</button>							
						</div>
						
					</div>
					</form>
				
				</div>		
					
			</div>
		</div>
	</body>
</html>
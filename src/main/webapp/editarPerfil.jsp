<!DOCTYPE html>
<html lang="en">
    <head>
  <meta charset="utf-8">
  <title>Editar Perfil</title>
  <script  type="text/javascript" src="./jquery/jquery-3.2.1.min.js"></script>
  <script  type="text/javascript" src="./jquery/jquery-ui-1.12.1/jquery-ui.js"></script>
  <script  type="text/javascript" src="./js/bootstrap.js"></script>

  <link rel="stylesheet" type="text/css" href="./css/estilo.css">
  <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap-theme.css">
</head>
	<body background="img/fondologin.png">
		<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <img src="img/logov.png">
			    </div>
			    <ul class="nav navbar-nav">
			      	<li><a href="index.jsp">Inicio</a></li>
			   		<li><a href="menu1.jsp">¿Quiénes somos?</a></li>
			        <li><a href="#">Haz voluntariado</a></li>

			    </ul>	
			  </div>
		</nav>
		<div>
			<div class="row main">
				<div class="panel-heading">
					<div class="panel-title text-center">
		               		<br>
		               		<h1 class="title" id="label-font-pas">EDITAR PERFIL</h1> 		
		            </div> 
		            <!-- 
		            <sql:query var="ejemplos" dataSource="${localSource}" sql="select * from tb_usuario where cod_usu = ?"></sql:query>
		             -->
				        <form action=ServletUsuario?tipo=cambiarPass method="post">
				        	<div class="col-sm-4"></div>
								<div class="col-sm-4 form-group">
									<br>
				                	<div class="form-group">
									  <input class="form-control" type="password" id="contrasena" name="contrasena" placeholder="Contraseña actual" type="text" 			required>
									</div>
									<div class="form-group">
									  <input class="form-control" type="password" id="newcontrasena" name="newcontrasena" placeholder="Nueva contraseña" type="text" required>
									</div>
									<div class="form-group">
									  <input class="form-control" type="password" id="confcontrasena" name="confcontrasena" placeholder="Confirmar contraseña" type="text" required>
									</div>
									<div>
											<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Guardar</button><br>
										</div>
										<div>
											<button type="submit" class="btn btn-primary btn-lg btn-block login-button" formaction="menuAdministrador.jsp" formnovalidate>Cancelar</button>							
										</div>
								</div>
								
							</form>
						</div>		
					</div>
				</div>
	</body>
</html>
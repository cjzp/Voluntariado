<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ufc-8">
<title>Bienvenido</title>
</head>
<body>
	<%
	String valores = null;
		if(session.getAttribute("datos")==null)
			pageContext.forward("ServletUsuario?tipo=cerrarSesion");
		else{
			valores = (String)session.getAttribute("nombre");
		}
	%>
	<h3>
		<font color="red" size="2">
		<b>
			Bievenido :
		</b>
		</font>
		<font color="green" size="2">
		<b>
		<%=valores %>
		</b>
		</font>
		
	</h3>

</body>
</html>
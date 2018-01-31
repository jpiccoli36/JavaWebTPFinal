
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Habilitar o Inhabilitar Usuarios</title>
<link href="style/fondo.css" rel="stylesheet">
<meta charset="ISO-8859-1">

</head>
<body>
<h1>Sistema Informatico Reservas </h1>

	<form class="form-signin" name="signin" action="ServletsHabilitarOInhabilitarUsuario" method="post">
		<h2 class="form-signin-heading">Habilitar Usuario</h2>
		<% ArrayList<Persona> per = (ArrayList<Persona>) request.getAttribute("listausu");	%>
		<label>Seleccionar Usuario:</label>
				<select name="idusuario">
				
			<%	for (Persona p : per) {%>
 <option value="<%=p.getIdUsuario()%>"> <%=p.getUsuario()%></option>

 
 <%
			}
					%>
</select>		<br>
									
		
	<label>Seleccionar Estado:</label>
	<select name="estado">
	<option value="habilitado">Habilitar</option>
	<option value ="inhabilitado"> Inhabilitar</option>
	</select>
	<br>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Aceptar</button>
	</form>
<form action="ServletsAdmin" method="post">
		<input type="submit" value="Volver al menú" />
	</form>
</body>
</html>
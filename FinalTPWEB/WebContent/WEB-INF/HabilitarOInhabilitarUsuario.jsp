
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

	<form class="form-signin" name="signin" action="ServletsHabilitarOInhabilitarUsuario" method="post">
		<h1 class="form-signin-heading">Habilitar Usuario</h1>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Persona"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Baja Usuario</title>
<link href="style/fondo.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

</head>
<body>
<h1>Sistema Informatico Reservas </h1>

	<form class="form-signin" name="signin" action="ServletsBajaUsuario"
		method="post">
		<h2 class="form-signin-heading">Eliminar Usuario</h2>
		<label for="idusuario" class="sr-only">Usuario</label>
		<% ArrayList<Persona> usu = (ArrayList<Persona>) request.getAttribute("listausu");	%>
				<select name="idusuario">
				
			<%	for (Persona p : usu) {%>
 <option value="<%=p.getId()%>"> <%=p.getUsuario()%></option> 
 <%
			}
					%>
</select>				
		
		 
			<button class="btn btn-lg btn-primary btn-block" type="submit">Eliminar
				Usuario</button>
	</form>
<form action="ServletsAdmin" method="post">
		<input type="submit" value="Volver al men�" />
	</form>
</body>
</html>

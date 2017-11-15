<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Persona"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Bienvenido
		<%=((Persona)session.getAttribute("user")).getNombre() %></h1>
	<form action="ServletsVerReservas" method="post">
		<input type="submit" value="Ver Reservas" />
	</form>
<form action="ServletVerElementos" method="post">
		<input type="submit" value="Alta Reserva" />
	</form>
		<form action="ServletsBuscarReservaUsuario" method="post">
		<input type="submit" value="Baja Reservas" />
	</form>
	
	
<form action="login.html" method="post">
		<input type="submit" value="Salir" />
	</form>

</body>
</html>
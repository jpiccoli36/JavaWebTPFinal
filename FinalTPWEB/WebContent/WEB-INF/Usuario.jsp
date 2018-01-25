<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Persona"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

#header {
	width: 100%;
	margin: 0px;
	font-family: Arial, Helvetica, sans-serif;
}

ul, ol {
	list-style: none;
}

.nav>li {
	float: left;
}

.nav li a {
	background-color: black;
	color: #fff;
	text-decoration: none;
	padding: 10px 12px;
	display: block;
}

.nav li ul {
	display: none;
	position: absolute;
	min-width: 100%;
}

.nav li:hover>ul {
	display: block;
}

.nav li ul li {
	position: relative;
}
</style>
</head>
<body>
	<h1>
	Bienvenido
		<%=((Persona)session.getAttribute("user")).getNombre() %></h1>
	<div id="header" style="width: 100%">
		<ul class="nav">	
	<li><a>Reservas</a>
	<ul>
	<li>
	<form action="ServletsVerReservas" method="post">
	<input type="hidden" name="opcion" value="1">
		<input type="submit" style="cursor: pointer; background-color: black; color: white; border-style: none; height: 30px; width: 200px; font-size: 12pt"
								 value="Ver Reservas" />
	</form>
	</li>
	<li>	

	<form action="ServletsVerTipoElementos" method="post">
							<input type="hidden" name="opcion" value="7">
							<input
								type="submit"
								style="cursor: pointer; background-color: black; color: white; border-style: none; height: 30px; width: 200px; font-size: 12pt"
								value="Alta Reserva" /></input>
						</form>
	</li>
	<li>
		<form action="ServletsBuscarReservaUsuario" method="post">
		<input type="submit" style="cursor: pointer; background-color: black; color: white; border-style: none; height: 30px; width: 200px; font-size: 12pt"
								 value="Baja Reservas" />
	</form>
	</li>
	
	</ul>
		</li>
	</div>
	<div align="right"
		style="font-size: 27px; padding-top: 0px; padding-right: 150px;">
<form action="login.html" method="post">
		<input type="submit" style="width: 100px; height: 35px;" value="Cerrar Sesion" />
	</form>
	</div>


</body>
</html>
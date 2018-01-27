<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Persona"%>
<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Elemento a Reservar</title>
</head>
<body>	
	<div class="container">

		<form class="form-signin" name="signin" action="ServletsAltaReserva"
			method="post">
			<h2 class="form-signin-heading">Reserva</h2>
			<input type="hidden"name="user" value="<%=((Persona)session.getAttribute("user")).getUsuario()%> ">
			<label for="fechaini" class="sr-only">Fecha Inicio</label> <input
				name="fechaini" id="fechaini" class="form-control"
				placeholder="dd/mm/yyyy" required="" autofocus="" type=""> <label
				for="horaini" class="sr-only">Hora Inicio</label> <input
				name="horaini" id="horaini" class="form-control" placeholder="hh:mm"
				required="" autofocus="" type=""> <Br> <label
				for="fechafin" class="sr-only">Fecha Fin</label> <input
				name="fechafin" id="fechafin" class="form-control"
				placeholder="dd/mm/yyyy" required="" type=""> <label
				for="horafin" class="sr-only">Hora Fin</label> <input
				name="horafin" id="horafin" class="form-control" placeholder="hh:mm"
				required="" type=""> <Br> <select name="tipoel">



				<%
					if ((((Persona) session.getAttribute("categoria")).getCategoria()).equals("user")) {
				%>
				<%
					ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaele");
						for (Elemento p : ele) {
				%>
				<option value="<%=p.getNombre_elemento()%>">
					<%=p.getNombre_elemento()%></option>
				<%
					}
					}
				%>
				<%
					if ((((Persona) session.getAttribute("categoria")).getCategoria()).equals("encargado")) {
						ArrayList<Elemento> elemencargado = (ArrayList<Elemento>) request.getAttribute("listaeleencargado");
						for (Elemento e : elemencargado) {
				%>
				<option value="<%=e.getNombre_elemento()%>">
					<%=e.getNombre_elemento()%></option>
				<%
					}
				%>
				<%
					ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaele");
						for (Elemento p : ele) {
				%>
				<option value="<%=p.getNombre_elemento()%>">
					<%=p.getNombre_elemento()%></option>
				<%
					}
					}
				%>



			</select>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Buscar
				Elementos</button>

		</form>

	</div>
	<form action="ServletsVerReservas" method="post">
<input type="hidden" name="opcion" value="2">
		<input type="submit" value="Volver al menu" />
	</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Persona"%>
<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
</head>
<body>
	<div class="container">

		<form class="form-signin" name="signin" action="ServletsAltaReserva"
			method="post">
			<h2 class="form-signin-heading">Reserva</h2>
			<label for="horaini" class="sr-only">Hora Inicio</label> <input
				name="horaini" id="horaini" class="form-control"
				placeholder="dd-mm-yyyy hh:mm" required="" autofocus="" type="">
			<Br> <label for="horafin" class="sr-only">Hora Fin</label> <input
				name="horafin" id="horafin" class="form-control"
				placeholder="dd-mm-yyyy hh:mm" required="" type=""> <Br>
			<label for="tipoel" class="sr-only">Tipo Elemento</label> <input
				name="tipoel" id="tipoel" class="form-control"
				placeholder="Tipo Elemento" required="" type=""> <Br>
				
			<button class="btn btn-lg btn-primary btn-block" type="submit">Buscar
				Elementos</button>

		</form>
		<table>
			Tipo Elementos
			<Br>


			<%
				ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaele");
				for (Elemento p : ele) {
			%>
			<tr>
				<td><%=p.getNombre_elemento()%> &nbsp;</td> >

			</tr>
			<%
				}
			%>
		</table>


	</div>
	<!-- /container -->

</body>
</html>
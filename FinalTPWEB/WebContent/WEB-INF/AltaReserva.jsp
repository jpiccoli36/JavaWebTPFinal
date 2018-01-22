<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Reservas"%>
<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="form-signin" name="signin" action="ServletsReservar"
		method="post">
		<h2 class="form-signin-heading">Reserva</h2>
		<select name="elemento">

			<%
				ArrayList<Reservas> res = (ArrayList<Reservas>) request.getAttribute("listaelementos");
				for (Reservas r : res) {
			%>
			<option value="<%=r.getElemento()%>">
				<%=r.getElemento()%></option>


			<%
				}
			%>
		</select> <label for="detalle" class="sr-only">Detalle</label> <input
			name="detalle" id="detalle" class="form-control"
			placeholder=" Detalle" required="" type=""> <Br>
			<input type="hidden"
				name="horaini" value=<%=request.getParameter("horaini") %> >
				<input type="hidden"
				name="fechaini" value=<%=request.getParameter("fechaini") %> >
				<input type="hidden"
				name="fechafin" value=<%=request.getParameter("fechafin") %> >
				<input type="hidden"
				name="horafin" value=<%=request.getParameter("horafin") %> >
				<input type="hidden"
				name="tipoel" value=<%=request.getParameter("tipoel") %> >					
				

		<button class="btn btn-lg btn-primary btn-block" type="submit">Reservar</button>

	</form>
	<form action="ServletsVerReservas" method="post">
<input type="hidden" name="opcion" value="2">
		<input type="submit" value="Volver al menu" />
	</form>





</body>
</html>
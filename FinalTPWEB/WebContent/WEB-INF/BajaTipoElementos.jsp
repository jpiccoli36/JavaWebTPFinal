<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Reservas"%>
<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<form class="form-signin" name="signin"
		action="ServletsBajaTipoElementos" method="post">
		<h2 class="form-signin-heading">Eliminar Tipo Elementos</h2>
		<%
			ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaelementos");
		%>
		<label>Seleccionar Tipo Elemento:</label>
		<select name="idelemento">

			<%
				for (Elemento p : ele) {
			%>
			<option value="<%=p.getId_elemento()%>">
				<%=p.getNombre_elemento()%></option>


			<%
				}
			%>
		</select>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Eliminar
			Tipo Elemento</button>

	</form>

	<form action="ServletsAdmin" method="post">
		<input type="submit" value="Volver al menú" />
	</form>

</body>
</html>
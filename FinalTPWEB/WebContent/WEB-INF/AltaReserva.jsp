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
			
			<label for="elemento" class="sr-only">Elemento</label> <input
				name="elemento" id="elemento" class="form-control"
				placeholder=" Elemento" required="" type=""> <Br>
				<label for="detalle" class="sr-only">Detalle</label> <input
				name="detalle" id="detalle" class="form-control"
				placeholder=" Detalle" required="" type=""> <Br>
				
			<button class="btn btn-lg btn-primary btn-block" type="submit">Reservar</button>

		</form>
				
				
				
			<table>
			Elementos Disponibles
			<Br>


			<%
				ArrayList<Reservas> ele = (ArrayList<Reservas>) request.getAttribute("listaelementos");
				for (Reservas p : ele) {
			%>
			<tr>
				<td><%=p.getElemento()%> &nbsp;</td> >

			</tr>
			<%
				}
			%>
		</table>		

</body>
</html>
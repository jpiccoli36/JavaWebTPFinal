<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Reservas"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletsCancelarTodasReservas" method="post">
		<label for="idreserva" class="sr-only">User</label> <input
				name="idreserva" id="idreserva" class="form-control" placeholder="ID Reserva"
				required="" autofocus="" type="">
		<input type="submit" value="Cancelar Reserva" />
		</form>


	<table>
		<%
			ArrayList<Reservas>listaRes= (ArrayList<Reservas>)request.getAttribute("listaReservas");
			for(Reservas r : listaRes){
		%>
		<tr>
			<td><%=r.getIdreservas() %> &nbsp;</td>
			<td><%=r.getUsuario() %></td>
			<td><%=r.getElemento() %></td>
			<td><%=r.getTipoElemento() %></td>
		

		</tr>
		<%
			}
		%>
	</table>

</body>
</html>
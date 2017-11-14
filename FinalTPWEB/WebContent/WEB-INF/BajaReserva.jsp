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


<form action="ServletsBuscarReserva" method="post">
		<input type="submit" value="BuscarReservas" />
		
		<form action="ServletsCancelarReserva" method="post">
		<input type="submit" value="Cancelar Reserva" />
		


	<table>
		<%
			ArrayList<Reservas>listaRes= (ArrayList<Reservas>)request.getAttribute("listaReservas");
			for(Reservas r : listaRes){
		%>
		<tr>
			<td><%=r.getIdreservas() %> &nbsp;</td>
			<td><%=r.getElemento() %></td>
			<td><%=r.getTipoElemento() %></td>
			<td><%=r.getDetalle() %></td>

		</tr>
		<%
			}
		%>
	</table>

</body>
</html>
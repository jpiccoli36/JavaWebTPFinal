<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Reservas"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/fondo.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja Reservas</title>
</head>
<body>
<h1>Sistema Informatico Reservas </h1>
<form action="ServletsVerReservas" method="post">
<input type="hidden" name="opcion" value="2">
		<input type="submit" value="Volver al menu" />
	</form>


		
		<form action="ServletsCancelarReservaUsuario" method="post">
		<label for="idreserva" class="sr-only">User</label> <input
				name="idreserva" id="idreserva" class="form-control" placeholder="ID Reserva"
				required="" autofocus="" type="number">
		<input type="submit" value="Cancelar Reserva" />
		</form>

<table>
	<thead>
       <tr>
           <th>ID-RESERVA</th>           
           <th>ELEMENTO</th>
           <th>TIPO ELEMENTO</th>
           <th>FECHA INICIO</th>
           <th>FECHA FIN</th>
       </tr>
   </thead>
   <tbody>
		<%
		ArrayList<Reservas>listaRes= (ArrayList<Reservas>)request.getAttribute("listaReservas");
			for(Reservas r : listaRes){
		%>
		<tr>
			<td><%=r.getIdreservas() %> &nbsp;</td>			
			<td><%=r.getElemento() %></td>
			<td><%=r.getTipoElemento() %></td>
			<td><%=r.getFhinicio() %></td>
			<td><%=r.getFhfin() %></td>
		

		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	

</body>
</html>
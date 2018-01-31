<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Reservas"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/fondo.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver Reservas</title>
</head>
<body>
<h1>Sistema Informatico Reservas </h1>
<form action="ServletsVerReservas" method="post">
<input type="hidden" name="opcion" value="2">
		<input type="submit" value="Volver al menu" />
	</form>
	<form action="ServletsVerReservas">

<table>
	
	<thead>
       <tr>
           <th>ELEMENTO</th>
           <th>TIPO ELEMENTO</th>
           <th>FECHA HS INICIO</th>
           <th>FECHA HS FIN</th>
       </tr>
   </thead>
   <tbody>
		<%
			ArrayList<Reservas>res= (ArrayList<Reservas>)request.getAttribute("listar");
			for(Reservas re : res){
		%>
		<tr>
			<td><%=re.getElemento()%></td>
				<td><%=re.getTipoElemento() %></td>
				<td><%=re.getFhinicio() %></td>
				<td><%=re.getFhfin() %></td>

		</tr>
		<%
			}
		%>
		</tbody>
	</table>
				
						</form>
</body>
</html>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletsUsuario" method="post">
		<input type="submit" value="Salir" />
	</form>
	<form action="ServletsVerReservas">
		<table>
			<% 

ArrayList<Reservas> res= (ArrayList<Reservas>) request.getAttribute("listar");
%>

			<% for(Reservas re: res){ %>
			<tr>
				<td><%=re.getElemento() %></td>
				<td><%=re.getTipoElemento() %></td>
				<td><%=(re.getFhinicio()) %></td>
				<td><%=re.getFhfin() %></td>
			</tr>
			<%


}
%>

			</select>



			</form>
</body>
</html>
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
<form class="form-signin" name="signin" action="ServletsAltaElementoReserva"
			method="post">
			<h2 class="form-signin-heading">Tipo Elementos</h2>
			<% ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaelementos");	%>
				<select name="idelemento">
				
			<%	for (Elemento e : ele) {%>
 <option value="<%=e.getId_elemento()%>"> <%=e.getNombre_elemento()%></option>

 
 <%
			}
					%>
</select>	
<Br>
				<label for="nombreelementoreserva" class="sr-only">Nombre Elemento Reserva</label> <input
				name="nombreelementoreserva" id="nombreelementoreserva" class="form-control"
				placeholder="Nombre Elemento Reserva" required="" type=""> <Br>										
				
			<button class="btn btn-lg btn-primary btn-block"   type="submit" >Alta Elemento Reserva</button>
			
		</form>	
			
			
			
			
		
</body>
</html>
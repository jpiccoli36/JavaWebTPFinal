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

<form class="form-signin" name="signin" action="ServletsAltaElementoReserva"
			method="post">
			<h2 class="form-signin-heading">Agregar Elemento</h2>
			<% ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaelementos");	%>
			<label>Seleccionar Tipo Elemento:</label>
				<select name="nombretipoelemento">
				
			<%	for (Elemento e : ele) {%>
 <option value="<%=e.getNombre_elemento()%>"> <%=e.getNombre_elemento()%></option>

 
 <%
			}
					%>
</select>	
<Br>
				<label for="nombreelementoreserva" class="sr-only">Nombre Elemento</label> <input
				name="nombreelementoreserva" id="nombreelementoreserva" class="form-control"
				placeholder="Nombre Elemento Reserva" required type="text"> <Br>										
				
			<button class="btn btn-lg btn-primary btn-block"   type="submit" >Agregar Elemento</button>
			
		</form>	
			
			<form action="ServletsAdmin" method="post">
		<input type="submit" value="Volver al menú" />
	</form>
			
			
		
</body>
</html>
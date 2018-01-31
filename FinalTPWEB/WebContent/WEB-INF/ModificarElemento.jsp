<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Modificar Elemento</title>
<link href="style/fondo.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

</head>
<body>
<h1>Sistema Informatico Reservas </h1>
	<div class="container">

		<form class="form-signin" name="signin" action="ServletsModificarElemento"
		
			method="post">
			
		
			
			
						
			<h2 class="form-signin-heading">Modificar Elemento</h2>
			<label for="nombreelemento" class="sr-only">Nombre Elemento</label> <input
				name="nombreelemento" id="nombreelemento" class="form-control"
				placeholder="<%=request.getAttribute("nombre") %>" required type="text" autofocus="">
					
				<input type="hidden"
				name="id" value="<%=request.getAttribute("id")%>" >				
				<% ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listatipo");	%>
				<br><label>Seleccionar Tipo Elemento:</label>
					<select name="tipoelemento">
				
			<%	for (Elemento p : ele) {%>
 <option value="<%=p.getNombre_elemento()%>"> <%=p.getNombre_elemento()%></option>

 
 <%
			}
					%>
</select>	
			
				
			<button class="btn btn-lg btn-primary btn-block" type="submit">Aceptar</button>
	
		
</form>

	</div>
	<form action="ServletsAdmin" method="post">
		<input type="submit" value="Cancelar" />
	</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="" content="text/html; charset=ISO-8859-1">
<link href="style/fondo.css" rel="stylesheet">
<title>Ver Tipos Elementos Baja Elementos</title>
</head>
<body>
<h1>Sistema Informatico Reservas </h1>
<form class="form-signin" name="signin" action="ServletsRecuperarElemento"
			method="post">
			<h2 class="form-signin-heading">Eliminar Elemento</h2>
			<label>Seleccionar Tipo Elemento:</label>
			<% ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaele");	%>
				<select name="idelemento">
				
			<%	for (Elemento p : ele) {%>
 <option value="<%=p.getNombre_elemento()%>"> <%=p.getNombre_elemento()%></option>

 
 <%
			}
					%>
</select>											
				
			<button class="btn btn-lg btn-primary btn-block"   type="submit" >Aceptar </button>
			
		</form>	
		<form action="ServletsAdmin" method="post">
		<input type="submit" value="Volver al menú" />
	</form>
			
			
			
			
		
</body>
</html>
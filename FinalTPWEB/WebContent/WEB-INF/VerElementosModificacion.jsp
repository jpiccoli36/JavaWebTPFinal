<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ver Elementos</title>
<link href="style/fondo.css" rel="stylesheet">

<meta http-equiv="" content="text/html; charset=ISO-8859-1">

</head>
<body>
<h1>Sistema Informatico Reservas </h1>
<form class="form-signin" name="signin" action="ServletsRecuperarTipoElemento"
			method="post">
			<h2 class="form-signin-heading">Modificacion Tipo Elemento</h2>
			<% ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaele");	%>
			<label>Seleccionar Tipo Elemento:</label>
				<select name="idelemento">
				
			<%	for (Elemento p : ele) {%>
 <option value="<%=p.getId_elemento()%>"> <%=p.getNombre_elemento()%></option>

 
 <%
			}
					%>
</select>											
				
			<button class="btn btn-lg btn-primary btn-block"   type="submit" >Modificar Tipo Elemento </button>
			
		</form>	
		
		<form action="ServletsAdmin" method="post">
		<input type="submit" value="Volver al men�" />
	</form>
			
			
			
			
		
</body>
</html>
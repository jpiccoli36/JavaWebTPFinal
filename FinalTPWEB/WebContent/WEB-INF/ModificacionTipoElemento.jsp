<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento sin t&iacute;tulo</title>
</head>
<body>
	<div class="container">

		<form class="form-signin" name="signin" action="ServletsModificarTipoElemento"
		
			method="post">
			
		
			Nombre <%=request.getAttribute("nombre") %> 
			Cantidad <br><%=request.getAttribute("cantidad") %> </br>
			ID <%=request.getAttribute("id") %>
						
			<h2 class="form-signin-heading">Modificacion Tipo Elementos</h2>
			<label for="nombreelemento" class="sr-only">Nombre Tipo Elemento</label> <input
				name="nombreelemento" id="nombreelemento" class="form-control"
				placeholder="<%=request.getAttribute("nombre") %>" required="" autofocus="" type="">
			<Br> <label for="cantidadelemento" class="sr-only">Cantidad Tipo Elemento</label> <input
				name="cantidadelemento" id="cantidadelemento" class="form-control"
				placeholder="<%=request.getAttribute("cantidad") %>" required="" type=""> <Br>
				<label for="<%=request.getAttribute("id") %>" class="sr-only">Cantidad Tipo Elemento</label> <input
				name="idelemento" id="<%=request.getAttribute("id") %>" class="form-control"
				placeholder="<%=request.getAttribute("id") %>" required="" type="" >
			
				
			<button class="btn btn-lg btn-primary btn-block" type="submit">Modificar Tipo
				Elemento</button>
	
		
</form>
	</div>


</body>
</html>
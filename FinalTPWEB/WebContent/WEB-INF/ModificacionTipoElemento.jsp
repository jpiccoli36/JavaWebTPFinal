<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Modificar Tipo Elementos</title>
<link href="style/fondo.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />


</head>
<body>
<h1>Sistema Informatico Reservas </h1>

		
	<div class="container">

		<form class="form-signin" name="signin" action="ServletsModificarTipoElemento"
		
			method="post">		
						
			<h2 class="form-signin-heading">Modificacion Tipo Elemento</h2>
						
			<label for="nombreelemento" class="sr-only">Nombre Tipo Elemento</label> <input
				name="nombreelemento" id="nombreelemento" class="form-control"
				placeholder="<%=request.getAttribute("nombre") %>" required type="text" autofocus="">
			<Br> 
			<label for="cantidadelemento" class="sr-only">Cantidad Tipo Elemento</label> <input
				name="cantidadelemento" id="cantidadelemento" class="form-control"
				placeholder="<%=request.getAttribute("cantidad") %>" required type="number"> <Br>
				<label for="anticipacion" class="sr-only">Días Anticipacion Reserva</label> <input
				name="anticipacion" id="anticipacion" class="form-control"
				placeholder="<%=request.getAttribute("anticipacion") %>" required type="number" autofocus="">
			<Br>
			<label for="maximo" class="sr-only">Dìas Maximos Reserva</label> <input
				name="maximo" id="maximo" class="form-control"
				placeholder="<%=request.getAttribute("maximo") %>" required type="number" autofocus="">
			<Br>
				
			<input type="hidden"
				name="idelemento" value="<%=request.getAttribute("id") %>" >
				<br><label>Autorizado a ver tipo Elemento:
			</label>
					<select required name="autorizado">
 <option value="user">usuario</option>
 <option value="encargado">encargado</option>
	</select>
			
			<br>		
			<button class="btn btn-lg btn-primary btn-block" type="submit">Aceptar</button>
	
		
</form>
	</div>
<form action="ServletsAdmin" method="post">
		<input type="submit" value="Cancelar" />
	</form>

</body>
</html>
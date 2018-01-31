<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidades.Error"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/fondo.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
<h1>Sistema Informatico Reservas </h1>
<div class="alert alert-warning">
<%
	Error e= new Error();
%>
<%Object mensaje=request.getAttribute("error");%>
<%Object url=request.getAttribute("url");%>
<%Object opcion= request.getAttribute("opcion"); %>

   <strong><%=mensaje%></strong>
   
   <form action="<%=url %>" method="post">
   <input type="hidden" name="opcion" value="<%=opcion %>"/>
		<input type="submit" value="Volver" />
	</form>
   </div>
    
    
   


</body>

</html>
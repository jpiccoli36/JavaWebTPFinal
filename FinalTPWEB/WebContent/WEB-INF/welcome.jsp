<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		Bienvenido
		<%=((Persona)session.getAttribute("user")).getNombre() %></h1>
	<h1><%=((Persona)session.getAttribute("categoria")).getCategoria()%></h1>



</body>
</html>

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
			<form action="ServletsAdmin" method="post">
		<input type="submit" value="Volver al menú" />
	</form>
	<table>
	
	<thead>
       <tr>
           <th>ID</th>
           <th>DNI</th>
           <th>APELLIDO</th>
           <th>NOMBRE</th>
       </tr>
   </thead>
   <tbody>
		<%
			ArrayList<Persona>listaPers= (ArrayList<Persona>)request.getAttribute("listaPersonas");
			for(Persona p : listaPers){
		%>
		<tr>
			<td><%=p.getId() %> &nbsp;</td>
			<td><%=p.getDNI() %></td>
			<td><%=p.getApellido() %></td>
			<td><%=p.getNombre() %></td>

		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Elemento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form class="form-signin" name="signin" action="ServletsBajaElemento"
			method="post">
			<h2 class="form-signin-heading">Elementos</h2>
			<% ArrayList<Elemento> ele = (ArrayList<Elemento>) request.getAttribute("listaele");	%>
				<select name="idelemento">
				
			<%	for (Elemento p : ele) {%>
 <option value="<%=p.getIdElementosReserva()%>"> <%=p.getNombreElementoReserva()%></option>

 
 <%
			}
					%>
</select>											
				
			<button class="btn btn-lg btn-primary btn-block"   type="submit" >Baja Elemento </button>
			
		</form>	
			
			
			
			
		
</body>
</html>
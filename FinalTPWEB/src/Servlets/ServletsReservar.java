package Servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorReservas;
import Entidades.Reservas;


@WebServlet("/ServletsReservar")
public class ServletsReservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletsReservar() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ControladorReservas cr = new ControladorReservas();
cr.ReservarElemento((String)request.getSession().getAttribute("user"), (java.util.Date)request.getSession().getAttribute("horaini"),(java.util.Date)request.getSession().getAttribute("horafin"), 
		request.getParameter("elemento"),(String) request.getSession().getAttribute("Tipoel"), request.getParameter("detalle"));


		
	}

}

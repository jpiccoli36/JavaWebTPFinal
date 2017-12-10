package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ControladorReservas cr = new ControladorReservas();

		String fechahsini = (request.getParameter("fechaini") + " " + request.getParameter("horaini"));
		String fechahsfin = (request.getParameter("fechafin") + " " + request.getParameter("horafin"));
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		java.util.Date FechaHoraIni = null;
		java.util.Date FechaHoraFin = null;
		try {
			FechaHoraIni = f.parse(fechahsini);
			FechaHoraFin = f.parse(fechahsfin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cr.ReservarElemento((String) request.getSession().getAttribute("usuario"), FechaHoraIni, FechaHoraFin,
				request.getParameter("elemento"), request.getParameter("tipoel"), request.getParameter("detalle"));

		request.getRequestDispatcher("WEB-INF/Usuario.jsp").forward(request, response);

	}

}

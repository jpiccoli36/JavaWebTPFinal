package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;
import Controlador.ControladorReservas;
import Entidades.Elemento;
import Entidades.Reservas;

/**
 * Servlet implementation class ServletsAltaReserva
 */
@WebServlet("/ServletsAltaReserva")
public class ServletsAltaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsAltaReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Reservas> re = new ArrayList<Reservas>();
		ControladorElementos ce= new ControladorElementos();
		ControladorReservas cr= new ControladorReservas();
		String usuario=(String) request.getSession().getAttribute("usuario");
		
		
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		java.util.Date FechaHoraIni = null;
		java.util.Date FechaHoraFin = null;
		try {
			FechaHoraIni = f.parse(request.getParameter("horaini"));
			FechaHoraFin = f.parse((String)request.getParameter("horafin"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String TipoEl =request.getParameter("tipoel");	
		Reservas r = new Reservas();
		//r.setFhfin((java.sql.Date) FechaHoraFin);
		//r.setFhinicio((java.sql.Date) FechaHoraIni);
		r.setTipoElemento(TipoEl);
		r.setUsuario(usuario);		
		request.getSession().setAttribute("horaini",FechaHoraFin);
		request.getSession().setAttribute("horafin",FechaHoraIni);
		request.getSession().setAttribute("Tipoel",r.getTipoElemento());
		request.getSession().setAttribute("user",r.getUsuario());	
		
		re=cr.ConsultaElementosDisponibles(FechaHoraIni, FechaHoraFin, TipoEl)	;
		request.setAttribute("listaelementos", re);		
		request.getRequestDispatcher("WEB-INF/AltaReserva.jsp").forward(request, response);
		
	}

}

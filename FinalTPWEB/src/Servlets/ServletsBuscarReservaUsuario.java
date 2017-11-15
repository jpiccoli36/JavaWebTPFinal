package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorReservas;
import Entidades.Reservas;

/**
 * Servlet implementation class ServletsBuscarReservaUsuario
 */
@WebServlet("/ServletsBuscarReservaUsuario")
public class ServletsBuscarReservaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsBuscarReservaUsuario() {
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
		ControladorReservas cr= new ControladorReservas();
		String usuario=(String) request.getSession().getAttribute("usuario");		
		
		ArrayList<Reservas> res = new ArrayList<Reservas>();
		res=cr.ConsultaTodosReservasUsuario(usuario);		
		request.setAttribute("listaReservas", res);
		request.getRequestDispatcher("WEB-INF/BajaReserva.jsp").forward(request, response);
	}

}

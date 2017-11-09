package Servlets;
import Entidades.Persona;
import Entidades.Reservas;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import Controlador.ControladorReservas;

/**
 * Servlet implementation class ServletsVerReservas
 */
@WebServlet("/ServletsVerReservas")
public class ServletsVerReservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsVerReservas() {
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
		
		System.out.println(usuario);
		ArrayList<Reservas> res = new ArrayList<Reservas>();
		res=cr.ConsultaTodosReservasUsuario(usuario);		
		request.setAttribute("listar", res);
		request.getRequestDispatcher("WEB-INF/VerReservas.jsp").forward(request, response);
	}

	
		
		
		
		
	}
	


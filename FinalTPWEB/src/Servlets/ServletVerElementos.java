package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;
import Entidades.Elemento;
import Entidades.Reservas;

/**
 * Servlet implementation class ServletVerElementos
 */
@WebServlet("/ServletVerElementos")
public class ServletVerElementos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerElementos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorElementos ce = new ControladorElementos();
		
		ArrayList<Elemento> el = new ArrayList<Elemento>();
		el=ce.ConsultaTodosTiposElementos();		
		request.setAttribute("listaele",el);
		request.getRequestDispatcher("WEB-INF/ElementosReserva.jsp").forward(request,response);;
	}
		
		
	}



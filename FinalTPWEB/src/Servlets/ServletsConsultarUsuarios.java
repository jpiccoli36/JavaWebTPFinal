package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorUsuario;
import Entidades.Persona;

/**
 * Servlet implementation class ServletsConsultarUsuarios
 */
@WebServlet("/ServletsConsultarUsuarios")
public class ServletsConsultarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsConsultarUsuarios() {
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorUsuario cu = new ControladorUsuario();
		ArrayList<Persona> ap= new ArrayList<Persona>();
		ap=cu.ConsultaTodosUsuarios();
		if(request.getParameter("opcion").equals("1")){
		request.setAttribute("listaPersonas", ap);		
		request.getRequestDispatcher("WEB-INF/ListaUsuarios.jsp").forward(request, response);
		}
		else{
			request.setAttribute("listausu",ap);
			request.getRequestDispatcher("WEB-INF/HabilitarOInhabilitarUsuario.jsp").forward(request, response);
			
		}
	}

}

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorReservas;
import Controlador.ControladorUsuario;

/**
 * Servlet implementation class ServletsBuscarReservas
 */
@WebServlet("/ServletsBuscarReserva")
public class ServletsBuscarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsBuscarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorReservas cr = new ControladorReservas();
		try {
			String usuario=((String) request.getSession().getAttribute("user"));
			
			request.setAttribute("listaReservas", cr.ConsultaTodosReservasUsuario(usuario));
		} catch (Exception ade) {
			request.setAttribute("Error", ade.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/BajaReserva.jsp").forward(request, response);
		
	}
	}



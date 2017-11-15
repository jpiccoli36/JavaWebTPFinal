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


@WebServlet("/ServletsCancelarReservaUsuario")
public class ServletsCancelarReservaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletsCancelarReservaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorReservas cr = new ControladorReservas();
		int id= Integer.parseInt(request.getParameter("idreserva"));
		cr.CancelarReserva(id);		
		
		String usuario=(String) request.getSession().getAttribute("usuario");		
		
		ArrayList<Reservas> res = new ArrayList<Reservas>();		
		res=cr.ConsultaTodosReservasUsuario(usuario);		
		request.setAttribute("listar", res);
		request.getRequestDispatcher("WEB-INF/VerReservas.jsp").forward(request, response);
		
		
	}

}

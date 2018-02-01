package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorUsuario;
import Entidades.Persona;

/**
 * Servlet implementation class ServletsHabilitarUsuario
 */
@WebServlet("/ServletsHabilitarOInhabilitarUsuario")
public class ServletsHabilitarOInhabilitarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletsHabilitarOInhabilitarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id=Integer.parseInt(request.getParameter("idusuario"));		
		Persona p = new Persona();
		p.setId(id);		
		ControladorUsuario cu = new ControladorUsuario();
		if(request.getParameter("estado").equals("habilitado")){
		cu.HabilitarUsuario(p);}
		else{
			cu.InhabilitarUsuario(p);
		}
		request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);
		
	
	}

}

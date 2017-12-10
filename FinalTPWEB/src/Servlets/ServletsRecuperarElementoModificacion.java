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

@WebServlet("/ServletsRecuperarElementoModificacion")
public class ServletsRecuperarElementoModificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletsRecuperarElementoModificacion() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorElementos ce= new ControladorElementos();
		Object tipoEl=request.getParameter("tipoelemento");
		ArrayList<Elemento> ae=new ArrayList<Elemento>();
		ae=ce.ConsultaTodosElementos(tipoEl);
		request.setAttribute("listaele", ae);
		request.getRequestDispatcher("WEB-INF/VerElementosAModificar.jsp").forward(request, response);
	}

}

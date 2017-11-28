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


@WebServlet("/ServletsVerTipoElementosModificacion")
public class ServletsVerTipoElementosModificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletsVerTipoElementosModificacion() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
ControladorElementos ce = new ControladorElementos();
		
		ArrayList<Elemento> el = new ArrayList<Elemento>();
		el=ce.ConsultaTodosTiposElementos();		
		request.setAttribute("listaele",el);
		request.getRequestDispatcher("WEB-INF/VerElementosModificacion.jsp").forward(request,response);
	
	}

}

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

@WebServlet("/ServletsVerTipoElementos")
public class ServletsVerTipoElementos extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletsVerTipoElementos() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorElementos ce = new ControladorElementos();
		ArrayList<Elemento> ae = new ArrayList<Elemento>();
		ae=ce.ConsultaTodosTiposElementos();
		request.setAttribute("listaelementos", ae);
		request.getRequestDispatcher("WEB-INF/BajaTipoElementos.jsp").forward(request, response);
		

	}

}

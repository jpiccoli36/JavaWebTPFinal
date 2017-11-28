package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;
import Entidades.Elemento;


@WebServlet("/ServletsRecuperarTipoElemento")
public class ServletsRecuperarTipoElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletsRecuperarTipoElemento() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Elemento e = new Elemento();
		ControladorElementos ce = new ControladorElementos();
		int idelemento=Integer.parseInt(request.getParameter("idelemento"));
		e=ce.ConsultarTipoElemento(idelemento);
		String nombre=e.getNombre_elemento();
		int cantidad= e.getCantidad_elemento();
		int id=e.getId_elemento();		
		request.setAttribute("cantidad",e.getCantidad_elemento());
		request.setAttribute("nombre",nombre);
		request.setAttribute("id",e.getId_elemento());
		request.getRequestDispatcher("WEB-INF/ModificacionTipoElemento.jsp").forward(request,response);
	
	}

}

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;
import Controlador.ControladorUsuario;
import Entidades.Elemento;
import Entidades.Persona;


@WebServlet({ "/ServletsAltaElemento", "/Servletaltaelemento" })
public class ServletsAltaElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletsAltaElemento() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Nombre=request.getParameter("Nombre");
		int Cantidad=Integer.parseInt(request.getParameter("Cantidad"));
		
		
		Elemento el=new Elemento();
		el.setNombre_elemento(Nombre);
		el.setCantidad_elemento(Cantidad);	
		ControladorElementos ctrl= new ControladorElementos();		
		ctrl.Alta(el);	
	
		request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);
	
	
	}

}

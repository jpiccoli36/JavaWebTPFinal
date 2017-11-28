package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;
import Entidades.Elemento;

@WebServlet("/ServletsAltaElementoReserva")
public class ServletsAltaElementoReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletsAltaElementoReserva() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ControladorElementos ce = new ControladorElementos();
		int id=Integer.parseInt( request.getParameter("idelemento"));
		String nombre=request.getParameter("nombreelementoreserva");
		Elemento e = new Elemento();
		Elemento w = new Elemento();
		w.setNombre_elemento(nombre);	
		e=ce.ConsultarTipoElemento(id);
		Object TipoEl=e.getNombre_elemento();
		
		
		ce.AgregarElemento(w, TipoEl);
	}

}

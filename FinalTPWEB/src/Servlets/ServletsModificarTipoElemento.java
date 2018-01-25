package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;
import Entidades.Elemento;


@WebServlet("/ServletsModificarTipoElemento")
public class ServletsModificarTipoElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletsModificarTipoElemento() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Elemento e = new Elemento();
		ControladorElementos ce = new ControladorElementos();
		String nombre = request.getParameter("nombreelemento");
		int cantidad= Integer.parseInt(request.getParameter("cantidadelemento"));
		int id= Integer.parseInt(request.getParameter("idelemento"));
		String autorizado=request.getParameter("autorizado");
		e.setId_elemento(id);	
		e.setNombre_elemento(nombre);
		e.setCantidad_elemento(cantidad);
		e.setAutorizado(autorizado);
		e.setAnticipacionDiasReserva(Integer.parseInt(request.getParameter("anticipacion")));
		e.setCantidadDiasMaximosReserva(Integer.parseInt(request.getParameter("maximo")));
		ce.ModificarTipoElementos(e);	
		request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);
		
	}

}

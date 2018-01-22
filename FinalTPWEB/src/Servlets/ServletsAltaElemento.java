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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Nombre = request.getParameter("Nombre");
		int Cantidad = Integer.parseInt(request.getParameter("Cantidad"));
		String autorizado=request.getParameter("autorizado");

		Elemento el = new Elemento();
		el.setAutorizado(autorizado);
		el.setNombre_elemento(Nombre);
		el.setCantidad_elemento(Cantidad);
		el.setAnticipacionDiasReserva(Integer.parseInt(request.getParameter("anticipacion")));
		el.setCantidadDiasMaximosReserva(Integer.parseInt(request.getParameter("maximo")));
		
		ControladorElementos ctrl = new ControladorElementos();
		ctrl.Alta(el);
		request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);

	}

}

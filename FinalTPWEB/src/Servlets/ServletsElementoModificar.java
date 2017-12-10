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

@WebServlet("/ServletsElementoModificar")
public class ServletsElementoModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletsElementoModificar() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorElementos ce=new ControladorElementos();
		Elemento e=new Elemento();
		int id=Integer.parseInt(request.getParameter("idelemento"));
		e=ce.ConsultarElemento(id);
		request.setAttribute("nombre", e.getNombreElementoReserva());
		request.setAttribute("tipoelemento", e.getTipoElementoReserva());
		request.setAttribute("id", e.getIdElementosReserva());	
		ArrayList<Elemento> ae=new ArrayList<Elemento>();
		ae=ce.ConsultaTodosTiposElementos();
		request.setAttribute("listatipo", ae);
		request.getRequestDispatcher("WEB-INF/ModificarElemento.jsp").forward(request, response);
		
	}

}

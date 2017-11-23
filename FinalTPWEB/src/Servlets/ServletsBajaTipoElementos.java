package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Controlador.ControladorElementos;
import Controlador.ControladorUsuario;
import Entidades.Elemento;
import Entidades.Persona;

@WebServlet("/ServletsBajaTipoElementos")
public class ServletsBajaTipoElementos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletsBajaTipoElementos() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idelemento=Integer.parseInt(request.getParameter("idelemento"));
		Elemento e = new Elemento();
		e.setId_elemento(idelemento);
		ControladorElementos ce= new ControladorElementos();
		ce.Baja(e);		
		request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);
	}

}

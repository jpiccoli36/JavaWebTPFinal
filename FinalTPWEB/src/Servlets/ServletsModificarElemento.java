package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;

@WebServlet("/ServletsModificarElemento")
public class ServletsModificarElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletsModificarElemento() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ControladorElementos ce=new ControladorElementos();
		int id=Integer.parseInt(request.getParameter("id"));
		String tipo=request.getParameter("tipoelemento");
		String nombre=request.getParameter("nombreelemento");		
		ce.ModificarElemento(id, nombre, tipo);
		request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);
		
	}

}

package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorUsuario;
import Entidades.Persona;
import Entidades.Error;



/**
 * Servlet implementation class ServletsLogin
 */
@WebServlet({ "/ServletsLogin", "/servletslogin" })
public class ServletsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public ServletsLogin() {    	
		
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			
			Persona per=new Persona();					
			per.setContraseña(pass);
			per.setUsuario(user);
			ControladorUsuario ctrl= new ControladorUsuario();
		
			
			try {
				
				per=ctrl.login(per);				
			
			if(per.getCategoria().equals("admin"))
			{
			
			request.getSession().setAttribute("user", per);	
			request.getSession().setAttribute("admin", per);			
			request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);
			}
			else{
				if((per.getCategoria().equals("user")) ||( per.getCategoria().equals("encargado")))
			{
					
				request.getSession().setAttribute("user", per);
				request.getSession().setAttribute("usuario", user);
			request.getSession().setAttribute("categoria", per);
			request.getRequestDispatcher("WEB-INF/Usuario.jsp").forward(request, response);
		
			}
				}	
			
}
			catch(java.sql.SQLException e){
				request.setAttribute("error", "Error en la conexion");
				request.setAttribute("url","login.html");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
}
			catch(Exception k){	
				
				
				request.setAttribute("error","Usuario/Password Incorrecta o Usuario Inhabilitado");
				request.setAttribute("url","login.html");				
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		
		
		
	
	}
			
			
	}
	}

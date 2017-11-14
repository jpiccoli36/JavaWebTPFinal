package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorUsuario;
import Entidades.Persona;



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
		try {
			
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			
			Persona per=new Persona();
			per.setUsuario(user);
			per.setContraseña(pass);
			
			ControladorUsuario ctrl= new ControladorUsuario();
			
			Persona pers=ctrl.login(per);
			if(pers.getCategoria().equals("admin"))
			{
			
			request.getSession().setAttribute("user", pers);	
			request.getSession().setAttribute("admin", pers);
			request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);
			}
			else{
				request.getSession().setAttribute("user", pers);
				request.getSession().setAttribute("usuario", user);
			request.getSession().setAttribute("categoria", pers);
			request.getRequestDispatcher("WEB-INF/Usuario.jsp").forward(request, response);
				 //no se como mandar cuando no esta en web-inf
			}
			
		//	response.getWriter().append(user).append(" ").append(pass);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
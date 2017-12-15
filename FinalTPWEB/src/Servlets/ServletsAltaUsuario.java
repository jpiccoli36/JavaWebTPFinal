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

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet({ "/ServletsAltaUsuario","/AltaUsuario", "/altausuario", "/Altausuarios", "/altausuarios", "/altaUsuarios" })
public class ServletsAltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public ServletsAltaUsuario() {
        super();
           }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DNI=request.getParameter("DNI");
		String Nombre=request.getParameter("Nombre");
		String Apellido=request.getParameter("Apellido");
		String Usuario=request.getParameter("Usuario");
		String Password=request.getParameter("Password");
		String Email=request.getParameter("Email");
		String habilitado=request.getParameter("habilitado");
		String categoria=request.getParameter("Categoria");		
		
		Persona per=new Persona();
		per.setCategoria(categoria);
		per.setApellido(Apellido);
		per.setContraseña(Password);
		per.setDNI(DNI);
		per.setNombre(Nombre);
		per.setEmail(Email);
		per.setUsuario(Usuario);		
		per.setEstados(habilitado);
		per.setCategoria(categoria);
		ControladorUsuario ctrl= new ControladorUsuario();		
		try{
			ctrl.AltaPersona(per);		
		
		request.getSession().setAttribute("user", per);			
		request.getRequestDispatcher("WEB-INF/Admin.html").forward(request, response);
		}
		catch(SQLException s){
			request.setAttribute("error", "error al agregar el usuario");
			request.setAttribute("url", "ServletsAdmin");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			
		} catch (Exception s) {
			request.setAttribute("error", "error al agregar el usuario");
			request.setAttribute("url", "ServletsAdmin");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
	}

	

}

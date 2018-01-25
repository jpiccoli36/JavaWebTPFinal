package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;
import Controlador.ControladorUsuario;
import Entidades.Elemento;
import Entidades.Persona;

@WebServlet("/ServletsVerTipoElementos")
public class ServletsVerTipoElementos extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletsVerTipoElementos() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opcion=Integer.parseInt(request.getParameter("opcion"));
		ControladorElementos ce = new ControladorElementos();
		ArrayList<Elemento> ae = new ArrayList<Elemento>();
		switch (opcion) {
		case 1:
	
		ae=ce.ConsultaTodosTiposElementosAdmin();
		request.setAttribute("listaelementos", ae);
		request.getRequestDispatcher("WEB-INF/BajaTipoElementos.jsp").forward(request, response);
			
			break;
		case 2:			
			ae=ce.ConsultaTodosTiposElementos();
			request.setAttribute("listaelementos", ae);
			request.getRequestDispatcher("WEB-INF/SeleccionarElementoReserva.jsp").forward(request, response);
			
			break;
		case 3:
			
			ae=ce.ConsultaTodosTiposElementos();		
			request.setAttribute("listaele",ae);
			request.getRequestDispatcher("WEB-INF/VerElementosModificacion.jsp").forward(request,response);
			
			break;
		case 4:		
			ae=ce.ConsultaTodosTiposElementos();
			request.setAttribute("listaele",ae);
			request.getRequestDispatcher("WEB-INF/VerTiposElementosBajaElementos.jsp").forward(request, response);
			break;
		case 5:
			
		ae=ce.ConsultaTodosTiposElementos();
		request.setAttribute("listaele", ae);
		request.getRequestDispatcher("WEB-INF/VerTiposElementosModificarElementos.jsp").forward(request, response);			
			break;
		case 6:					
			Elemento e=new Elemento();
			int id=Integer.parseInt(request.getParameter("idelemento"));
			e=ce.ConsultarElemento(id);
			request.setAttribute("nombre", e.getNombreElementoReserva());
			request.setAttribute("tipoelemento", e.getTipoElementoReserva());
			request.setAttribute("id", e.getIdElementosReserva());		
			ae=ce.ConsultaTodosTiposElementos();
			request.setAttribute("listatipo", ae);
			request.getRequestDispatcher("WEB-INF/ModificarElemento.jsp").forward(request, response);
		break;
		case 7:		
			
			if(request.getSession().getAttribute("categoria").equals("user")){
			ae=ce.ConsultaTodosTiposElementos();			
			request.setAttribute("listaele",ae);			
			request.getRequestDispatcher("WEB-INF/ElementosReserva.jsp").forward(request,response);
			}
			else{			
				ArrayList<Elemento> aee=new ArrayList<Elemento>();
				ae=ce.ConsultaTodosTiposElementos();		
				aee=ce.ConsultaTodosTiposElementosEncargado();				
				request.setAttribute("listaele",ae);
				request.setAttribute("listaeleencargado", aee);
				request.getRequestDispatcher("WEB-INF/ElementosReserva.jsp").forward(request,response);				
				
			}
						
		default:
			break;
		}
		

	}

}

package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorElementos;
import Controlador.ControladorReservas;
import Entidades.Reservas;

/**
 * Servlet implementation class ServletsAltaReserva
 */
@WebServlet("/ServletsAltaReserva")
public class ServletsAltaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletsAltaReserva() {
		super();
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Reservas> re = new ArrayList<Reservas>();
		ControladorElementos ce= new ControladorElementos();
		ControladorReservas cr= new ControladorReservas();	

		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
		java.util.Date FechaHoraIni = null;
		java.util.Date FechaHoraFin = null;
		try {
			FechaHoraIni = f.parse(request.getParameter("fechaini")+" "+request.getParameter("horaini"));
			FechaHoraFin=f.parse(request.getParameter("fechafin")+" "+request.getParameter("horafin"));			

		
		if(!((FechaHoraIni.compareTo(FechaHoraFin))!=1 & (FechaHoraIni.compareTo(FechaHoraFin))<0)){				
		
			Exception exp = new Exception("La Fecha fin es menor a la Fecha inicial");
			request.setAttribute("error", exp.getMessage());
			String url="ServletsVerTipoElementos";
			request.setAttribute("url", url );
			request.setAttribute("opcion", 7);
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
		else{
			
			
			String TipoEl =request.getParameter("tipoel");			
			
			int FechaM=0;			
			FechaM = ce.ConsultarTiempoAnterioridadReserva(TipoEl);			
			Date hoy = new Date();
			
			//https://github.com/pedro96x/TPWeb/blob/master/TP%20Web/src/servlet/aNuevaReserva2.java		
			if(((FechaHoraIni.getTime()-hoy.getTime())/86400000) < FechaM){
				
				Exception e = new Exception("Debe reservar con mas dias de anticipacion(como minimo "+FechaM+" dias)");
				request.setAttribute("error", e.getMessage());
				String url="ServletsVerTipoElementos";
				request.setAttribute("url", url );
				request.setAttribute("opcion", 7);
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			}
			else{
				int LimMaxDeTiempoDeReserva=ce.ConsultarTiempoMaximoReserva(TipoEl);
				if(LimMaxDeTiempoDeReserva< ((FechaHoraFin.getTime()-FechaHoraIni.getTime())/86400000)){
					Exception e = new Exception("Supera La Cantidad De dias Maximos de Reserva(maximo "+LimMaxDeTiempoDeReserva+"dias) ");
					request.setAttribute("error", e.getMessage());
					String url="ServletsVerTipoElementos";
					request.setAttribute("url", url );
					request.setAttribute("opcion", 7);
					request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
					
				}
				else{
				request.setAttribute("horaini",request.getParameter("horaini"));
				request.setAttribute("fechaini",request.getParameter("fechaini"));
				request.setAttribute("fechafin",request.getParameter("fechafin"));
				request.setAttribute("horafin",request.getParameter("horafin"));
				request.setAttribute("tipoel",TipoEl);
					
				
				re=cr.ConsultaElementosDisponibles(FechaHoraIni, FechaHoraFin, TipoEl)	;
				request.setAttribute("listaelementos", re);		
				request.getRequestDispatcher("WEB-INF/AltaReserva.jsp").forward(request, response);
				}
					
	
		
		}
			}
			
		}
		
		 catch (ParseException e) {
		e= new ParseException("Formato de Fecha Incorrecto",0);
		request.setAttribute("error", e.getMessage());
		String url="ServletsVerTipoElementos";
		request.setAttribute("url", url );
		request.setAttribute("opcion", 7);
		request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		
		 } catch (Exception e) {
			 e=new Exception("Oops!ocurrio un Error Inesperado");
			 request.setAttribute("error", e.getMessage());
				String url="ServletsVerTipoElementos";
				request.setAttribute("url", url );
				request.setAttribute("opcion", 7);
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
	}}
			


		
	
	


		
	
package Controlador;

import java.util.ArrayList;
import java.util.Date;

import Datos.DatosReserva;
import Entidades.Reservas;


public class ControladorReservas {
	DatosReserva dr = new DatosReserva();

	public ArrayList<Reservas> ConsultaElementosDisponibles(Date fechaHoraIni, Date fechaHoraFin, Object tipoEl) {
		
		return dr.ConsultaElementosDisponibles(fechaHoraIni, fechaHoraFin, tipoEl);
	}

	public ArrayList<Reservas> ConsultaTodosReservasUsuario(String usuario) {
		return dr.ConsultaTodosReservasUsuario(usuario);
		
	}

	public ArrayList<Reservas> ConsultarTodasReservas() {
		return dr.ConsultarTodasReservas();
	
	}

	public void CancelarReserva(int idReserva) {
		dr.CancelarReserva(idReserva);
		
	}

	public Reservas ContarReservas(String tipo, String usuario) {
		return dr.ContarReservas(tipo, usuario);
		
	}

	public void ReservarElemento(String usuario, Date fechaHoraIni, Date fechaHoraFin, String elemento, String tipo,String detalle) {
		dr.ReservarElemento(usuario, fechaHoraIni, fechaHoraFin, elemento, tipo, detalle);
		
	}

	
	
}

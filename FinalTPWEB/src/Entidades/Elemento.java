package Entidades;

import java.io.Serializable;

public class Elemento implements Serializable {
	int id_elemento;
	int CantidadDiasMaximosReserva;
	int AnticipacionDiasReserva;
	int idElementosReserva;
	String NombreElementoReserva;
	String tipoElementoReserva;
	String autorizado;
	int cantidad_elemento;
	String nombre_elemento;

	public Elemento() {

	}
	public int getCantidadDiasMaximosReserva() {
		return CantidadDiasMaximosReserva;
	}

	public void setCantidadDiasMaximosReserva(int cantidadDiasMaximosReserva) {
		CantidadDiasMaximosReserva = cantidadDiasMaximosReserva;
	}

	public int getAnticipacionDiasReserva() {
		return AnticipacionDiasReserva;
	}

	public void setAnticipacionDiasReserva(int anticipacionDiasReserva) {
		AnticipacionDiasReserva = anticipacionDiasReserva;
	}

	
	public int getIdElementosReserva() {
		return idElementosReserva;
	}

	public void setIdElementosReserva(int idElementosReserva) {
		this.idElementosReserva = idElementosReserva;
	}

	public String getNombreElementoReserva() {
		return NombreElementoReserva;
	}

	public void setNombreElementoReserva(String nombreElementoReserva) {
		NombreElementoReserva = nombreElementoReserva;
	}

	public String getTipoElementoReserva() {
		return tipoElementoReserva;
	}

	public void setTipoElementoReserva(String tipoElementoReserva) {
		this.tipoElementoReserva = tipoElementoReserva;
	}



	public String getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(String autorizado) {
		this.autorizado = autorizado;
	}

	public Elemento(String nombre, int id, int cantidad) {
		this.setNombre_elemento(nombre);
		this.setId_elemento(id);
		this.setCantidad_elemento(cantidad);
	}

	public int getId_elemento() {
		return id_elemento;
	}

	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}

	public int getCantidad_elemento() {
		return cantidad_elemento;
	}

	public void setCantidad_elemento(int cantidad_elemento) {
		this.cantidad_elemento = cantidad_elemento;
	}

	public String getNombre_elemento() {
		return nombre_elemento;
	}

	public void setNombre_elemento(String nombre_elemento) {
		this.nombre_elemento = nombre_elemento;
	}



}

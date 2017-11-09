package Entidades;

import java.io.Serializable;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Reservas implements Serializable {
	int idreservas;
	String usuario;
	String Elemento;
	String TipoElemento;
	String detalle;
	java.sql.Date fhinicio;
	java.sql.Date fhfin;
	int CantidadReservas;
	public int getCantidadReservas() {
		return CantidadReservas;
	}
	public void setCantidadReservas(int cantidadReservas) {
		CantidadReservas = cantidadReservas;
	}
	public int getIdreservas() {
		return idreservas;
	}
	public void setIdreservas(int idreservas) {
		this.idreservas = idreservas;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getElemento() {
		return Elemento;
	}
	public void setElemento(String elemento) {
		Elemento = elemento;
	}
	public String getTipoElemento() {
		return TipoElemento;
	}
	public void setTipoElemento(String tipoElemento) {
		TipoElemento = tipoElemento;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public java.sql.Date getFhinicio() {
		return fhinicio;
	}
	public void setFhinicio(java.sql.Date fhinicio) {
		this.fhinicio = fhinicio;
	}
	public java.sql.Date getFhfin() {
		return fhfin;
	}
	public void setFhfin(java.sql.Date fhfin) {
		this.fhfin = fhfin;
	}
	

}

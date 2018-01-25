package Controlador;


import java.util.ArrayList;

import Datos.DatosElementos;
import Entidades.Elemento;


public class ControladorElementos {
	DatosElementos de= new DatosElementos();
	
	public ArrayList<Elemento> ConsultaTodosTiposElementos() {
		return de.ConsultaTodosTiposElementos();	
		
	}
	public ArrayList<Elemento> ConsultaTodosElementos(Object TipoEl){
		return de.ConsultaTodosElementos(TipoEl);
		
	}
	public ArrayList<Elemento >SeleccionarTiposElementos(Object TipoEl)
	{
		return de.SeleccionarTiposElementos(TipoEl);
		
	}
	public int CantidadElementoTipoElemento(String tipoel){
		return de.CantidadElementoTipoElemento(tipoel);
	}
	
public  ArrayList<Elemento > AgregarTipos(){
		
		return de.ConsultaTodosTipos();
	}
public void Alta(Elemento e) {
	
	de.AltaElementos(e);
}
public void Baja(Elemento e){
	de.BajaElementos(e);
}
public void AgregarElemento(Elemento e, Object TipoEl){
	 de.agregarElementoReserva(e, TipoEl);

	
}
public void BajaTipoElemento(int idelemento) {
	de.BajaTipoElemento(idelemento);
	
}
public void ModificarElemento(int id, String nombre, String tipo) {

	de.ModificarElemento(id, nombre, tipo);
	
}
public void ModificarTipoElementos(Elemento e) {
	de.ModificarTipoElementos(e);
	
}
public Elemento CantidadMaxReservas(String tipo) {
	
	return de.CantidadMaxReservas(tipo);
	
}
public Elemento ConsultarTipoElemento(int idelemento){
return de.ConsultarTipoElemento(idelemento);
}
public Elemento ConsultarElemento(int id){
	return de.ConsultarElemento(id);
}
public ArrayList<Elemento> ConsultaTodosTiposElementosEncargado() {
	return de.ConsultaTodosTiposElementosEncargado();	
}
public int ConsultarTiempoAnterioridadReserva(String tipoEl) throws Exception {
	return de.ConsultarTiempoAnterioridadReserva(tipoEl);
	
}
public int ConsultarTiempoMaximoReserva(String tipoEl) {
	return de.ConsultarTiempoMaximoReserva(tipoEl);

}
public ArrayList<Elemento> ConsultaTodosTiposElementosAdmin() {
	return de.ConsultaTodosTiposElementosAdmin();
}
}

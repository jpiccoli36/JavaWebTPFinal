package Controlador;

import java.sql.ResultSet;
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


}

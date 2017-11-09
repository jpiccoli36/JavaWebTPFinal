package Controlador;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.DatosElementos;
import Datos.DatosUsuarios;
import Datos.Login;
import Entidades.Elemento;
import Entidades.Persona;

public class ControladorUsuario {
	private DatosUsuarios du;

	Scanner w = new Scanner(System.in);
	

	public ControladorUsuario() {
		
		du = new DatosUsuarios();
	}

	public ArrayList<Persona> ConsultaTodosUsuarios() {
		return du.ConsultaTodosUsuarios();
	}

	

	public void AltaPersona(Persona p) {
		
		du.AltaUsuario(p);

	}

	public void BajaPersonas(Persona p) {
		du.BajaUsuario(p);

	}

	public Persona ConsultarEstado(int iD) {
		
		return du.ConsultarEstado(iD);

	}

	public void InhabilitarUsuario(Persona p) {
		du.InhabilitarUsuario(p);

	}

	public void HabilitarUsuario(Persona p) {
		du.HabilitarUsuario(p);

	}

	
	public Persona login(Persona p) {
		Login log = new Login();
		return log.login(p);

	}

}

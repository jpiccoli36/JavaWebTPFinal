package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Persona;

public class Login {
	public Persona login(Persona w){
		java.sql.PreparedStatement stmt =null;
		ResultSet rs = null;
		Persona p = new Persona();
		
		try {
			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select NombreUsuario, ApellidoUsuario,DNI,Categoria,habilitado from usuarios where Usuario= ? and Contraseña=?");
			stmt.setString(1,w.getUsuario());
			stmt.setString(2, w.getContraseña());
			
			rs=stmt.executeQuery();
			
			if((rs.next())){
				p.setNombre(rs.getString("NombreUsuario"));
				p.setApellido(rs.getString("ApellidoUsuario"));				
				p.setDNI(rs.getString("DNI"));
				p.setCategoria(rs.getString("Categoria"));
				p.setEstados(rs.getString("habilitado"));				
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
		return p;
	}

}

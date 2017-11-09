package Datos;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Elemento;
import Entidades.Persona;

public class DatosUsuarios {
	public void AltaUsuario(Persona p) {
		int b = 0;
		java.sql.PreparedStatement stmt = null;

		ResultSet rs = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert  into usuarios(NombreUsuario,ApellidoUsuario,DNI,Usuario,Contraseña,Categoria,habilitado) values  (?,?,?,?,?,?,? )  ",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getDNI());
			stmt.setString(4, p.getUsuario());
			stmt.setString(5, p.getContraseña());
			stmt.setString(6, p.getCategoria());

			if (p.getEstados().equals("habilitado")) {
				stmt.setString(7, "habilitado");
			} else {
				stmt.setString(7, "inhabilitado");
			}

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				p.setIdUsuario(rs.getInt(1));
			}
			JOptionPane.showMessageDialog(null, "Usuario Agregado");
			rs.close();
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();

		}
		
	}

	public void BajaUsuario(Persona p) {

		java.sql.PreparedStatement stmt = null;

		try {

			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM usuarios where IdUsuario=?");
			stmt.setInt(1, p.getIdUsuario());
			stmt.executeUpdate();

		} catch (SQLException s) {

			s.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Usuario Eliminado");
		try {
			stmt.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	public ArrayList<Persona> ConsultaTodosUsuarios() {
		ArrayList<Persona> pe = new ArrayList<Persona>();
		ResultSet rs = null;

		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();

			rs = stmt.executeQuery("select * from usuarios");
			if (rs != null) {
				while (rs.next()) {
					Persona p = new Persona();
					p.setApellido(rs.getString("ApellidoUsuario"));
					p.setNombre((rs.getString("NombreUsuario")));
					p.setCategoria(rs.getString("Categoria"));
					p.setContraseña(rs.getString("Contraseña"));
					p.setDNI(rs.getString("DNI"));
					p.setEstados(rs.getString("habilitado"));
					p.setIdUsuario(rs.getInt("IdUsuario"));
					p.setUsuario(rs.getString("Usuario"));

					pe.add(p);

				}
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return pe;

	}

	public Persona ConsultarEstado(int id) {

		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona p = new Persona();
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from usuarios where IdUsuario= ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs != null) {				
				rs.next();
				p.setApellido(rs.getString("ApellidoUsuario"));
				p.setNombre((rs.getString("NombreUsuario")));
				p.setCategoria(rs.getString("Categoria"));
				p.setContraseña(rs.getString("Contraseña"));
				p.setDNI(rs.getString("DNI"));
				p.setEstados(rs.getString("habilitado"));
				p.setIdUsuario(rs.getInt("IdUsuario"));
				p.setUsuario(rs.getString("Usuario"));

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {

		}
		return p;
	}

	public void HabilitarUsuario(Persona p) {
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("UPDATE usuarios SET habilitado=? WHERE idUsuario= ?");
			stmt.setInt(2, p.getIdUsuario());
			stmt.setString(1, "habilitado");
			stmt.executeUpdate();
			
			stmt.close();

		} catch (SQLException e1) {

			JOptionPane.showMessageDialog(null, "Ya esta Habilitado");
		}

	}

	public void InhabilitarUsuario(Persona p) {
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("UPDATE usuarios SET habilitado=? WHERE idUsuario= ? ");
			stmt.setInt(2, p.getIdUsuario());
			stmt.setString(1, "inhabilitado");
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}

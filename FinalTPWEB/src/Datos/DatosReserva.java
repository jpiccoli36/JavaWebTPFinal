package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import Entidades.Elemento;
import Entidades.Reservas;

public class DatosReserva {

	public ArrayList<Reservas> ConsultaElementosDisponibles(Date fechaHoraIni, Date fechaHoraFin, Object tipoEl) {
		ArrayList<Reservas> re = new ArrayList<Reservas>();
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from elementos el "
							+ "where TipoElemento=? and NombreElementoReserva not in ( select elemento "
							+ "from reservas r inner join elementos e on r.elemento=e.NombreElementoReserva"
							+ " where ? between fhinicio and fhfin or " + "? between fhinicio and fhfin or "
							+ "fhinicio<=? and fhfin<= ? or " + "fhinicio>=? and fhfin<= ? or "
							+ "fhinicio>=? and fhinicio<=?)");
			stmt.setObject(1, tipoEl);
			stmt.setTimestamp(2, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(4, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(5, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(6, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(7, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setTimestamp(8, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(9, new java.sql.Timestamp(fechaHoraFin.getTime()));

			rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Reservas r = new Reservas();
					r.setElemento(rs.getString("NombreElementoReserva"));
					r.setTipoElemento(rs.getString("TipoElemento"));
					re.add(r);

				}
				rs.close();
				stmt.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return re;

	}

	public void CancelarReserva(int IDReserva) {

		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("delete from reservas where idreserva=?");
			stmt.setInt(1, IDReserva);
			stmt.executeUpdate();

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Reservas> ConsultaTodosReservasUsuario(String user) {
		ArrayList<Reservas> re = new ArrayList<Reservas>();
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * " + "from reservas" + " where usuario=? and fhinicio>=curdate()");
			stmt.setString(1, user);
			rs = stmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Reservas r = new Reservas();
					r.setDetalle(rs.getString("detalle"));
					r.setElemento(rs.getString("elemento"));
					r.setIdreservas(rs.getInt("idreserva"));
					r.setUsuario(rs.getString("usuario"));
					r.setTipoElemento(rs.getString("tipoelemento"));
					re.add(r);
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return re;
	}

	public ArrayList<Reservas> ConsultarTodasReservas() {
		ArrayList<Reservas> re = new ArrayList<Reservas>();
		ResultSet rs = null;

		try {
			Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * " + "from reservas " + "where fhinicio>=curdate();");
			if (rs != null) {
				while (rs.next()) {
					Reservas r = new Reservas();
					r.setElemento(rs.getString("elemento"));
					r.setIdreservas(rs.getInt("idreserva"));
					r.setUsuario(rs.getString("usuario"));
					r.setTipoElemento(rs.getString("tipoelemento"));
					re.add(r);
				}

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;

	}

	public Reservas ContarReservas(String tipo, String usuario) {
		Reservas r = new Reservas();
		ResultSet rs = null;
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select count(*) Cantidad_Reservas"
					+ " from reservas " + "where usuario=? and tipoelemento=? and fhfin>= curdate()");
			stmt.setString(1, usuario);
			stmt.setString(2, tipo);
			rs = stmt.executeQuery();
			rs.next();
			r.setCantidadReservas(rs.getInt(1));

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}

	public void ReservarElemento(String usuario, Date fechaHoraIni, Date fechaHoraFin, String elemento, String tipo,
			String detalle) {
		java.sql.PreparedStatement stmt = null;

		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("insert into reservas (usuario, fhinicio, fhfin, elemento, tipoelemento,detalle) "
							+ "values (?,?,?,?,?,?)");
			stmt.setString(1, usuario);
			stmt.setTimestamp(2, new java.sql.Timestamp(fechaHoraIni.getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(fechaHoraFin.getTime()));
			stmt.setString(4, elemento);
			stmt.setString(5, tipo);
			stmt.setString(6, detalle);
			stmt.executeUpdate();

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

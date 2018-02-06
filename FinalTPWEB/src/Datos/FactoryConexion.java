package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConexion {


private static FactoryConexion instancia;
private Connection conn;
private String host="localhost";
		//node14280-sir-tpweb.jelastic.saveincloud.net";
private String port="3306";
private String user="root";
private String password="root";
private String db="javatp";

private FactoryConexion() {

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	}

}

public static FactoryConexion getInstancia(){
	if (FactoryConexion.instancia == null){		
		FactoryConexion.instancia=new FactoryConexion();
	}
	return FactoryConexion.instancia;
}



private int cantConn=0;
public Connection getConn(){
	try {
		if(conn==null || conn.isClosed()){
			conn = DriverManager.getConnection(
		        "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+password+"&useSSL=false");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	cantConn++;
	return conn;

}
}


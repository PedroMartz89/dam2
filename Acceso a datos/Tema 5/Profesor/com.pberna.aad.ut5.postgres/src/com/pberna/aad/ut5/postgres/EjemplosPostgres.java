package com.pberna.aad.ut5.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemplosPostgres {
	private final static String CADENA_CONEXION = 
			"jdbc:postgresql://localhost/ut5";
	
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CADENA_CONEXION, 
				"postgres", "1234"); 
	}
	
	public static void ejemploCrearTablaColumnaArrayConValores() {
		try(Connection conexion = getConnection();
				Statement sentencia = conexion.createStatement()) {
			
			//ejecutamos
			sentencia.execute("DROP TABLE IF EXISTS tareas");
			sentencia.execute("CREATE TABLE tareas(comercial_id integer,"
					+ "agenda VARCHAR[][])");
			
			//insertamos valores
			sentencia.execute("INSERT INTO tareas VALUES(3," +
					"'{{\"reunión 9:30\",\"comida 14:30\"},"
					+ "{\"reunión 8:30\",\"cena 8:30\"}}')");
			
			//todas las tareas del segundo día del comercial 3
			try(ResultSet rs = sentencia.executeQuery(
					"SELECT agenda[2:2] FROM tareas where comercial_id=3")) {
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
			}
			
			//consulta la segunda tarea del primer día del comercial 3
			try(ResultSet rs = sentencia.executeQuery(
					"SELECT agenda[1][2] FROM tareas where comercial_id=3")) {
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

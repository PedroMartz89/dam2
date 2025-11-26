package ejFicheros;

import ejFicheros.utils.ConectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	
	//ejercicio1
	public void listarDatosTodasTablas() {
		final String SQL = "SELECT * from escritores, editoriales, libros;";
        Connection conn = ConectionDB.getInstance();
        try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            //
            System.out.println(rs.getInt(5));
            System.out.println(rs.getString(6));
            System.out.println(rs.getString(7));
            System.out.println(rs.getString(8));

            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getDate(4));

            System.out.println(rs.getInt(9));
            System.out.println(rs.getString(10));
            System.out.println(rs.getInt(11));
            System.out.println(rs.getString(12));
            System.out.println(rs.getInt(13));
            System.out.println(rs.getInt(14));

        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	//ejercicio2
	public void darLibroDeAlta() {
		
	}
	
	//ejercicio3
	public void eliminarEscritor() {
		
	}
	
	//ejercicio4
	public void mostrarLibrosEscritor() {
		
	}
	
	//ejercicio5
	public void mostrarEstadisticasPaginas() {
		
	}
}

package ra2;

import ra2.utils.ConnectionDB;

import java.sql.*;
import java.util.Scanner;

public class Jdbc {
	
	//ejercicio1
	public void listarDatosTresTablas() {
        final String SQL_CANALES = "SELECT * from Canales;";
        final String SQL_GENEROS = "SELECT * from Generos;";
        final String SQL_USUARIOS = "SELECT  * from Usuarios;";

        try (Connection conn = ConnectionDB.getInstance();
             Statement stmt = conn.createStatement();
        ){
            System.out.println("--- CANALES ---");
            ResultSet rsCanales = stmt.executeQuery(SQL_CANALES);
            while (rsCanales.next()) {

                int id = rsCanales.getInt(1);
                String nombre = rsCanales.getString(2);
                String frecuencia = rsCanales.getString(3);
                System.out.println("ID: " + id + " Nombre: " + nombre  + " Frecuencia: " + frecuencia);
            }
            rsCanales.close();
            System.out.println("--- USUARIOS ---");
            ResultSet rsUsuarios = stmt.executeQuery(SQL_USUARIOS);
            while (rsUsuarios.next()) {
                int id = rsUsuarios.getInt(1);
                String nombre = rsUsuarios.getString(2);
                String correo = rsUsuarios.getString(3);
                System.out.println("ID: " + id + " Nombre: " + nombre  + " Correo: " + correo);
            }
            rsUsuarios.close();

            System.out.println("--- GENEROS ---");
            ResultSet rsGeneros = stmt.executeQuery(SQL_GENEROS);
            while (rsGeneros.next()) {
                int id = rsGeneros.getInt(1);
                String nombre = rsGeneros.getString(2);
                System.out.println("ID: " + id + " Nombre: " + nombre);
            }
            rsGeneros.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	//ejercicio2
	public void darProgramaDeAlta() {

        final String SQL_OBTENER_ID_CANAL = "SELECT id_canal FROM Canales WHERE id_canal = ?;";
        final String SQL_OBTENER_ID_GENERO = "SELECT id_genero FROM Generos WHERE id_genero = ?;";
        final String SQL_INSERT_PROGRAMA = "INSERT INTO Programas " +
                "(id_programa, titulo, codigo_programa, id_canal, id_genero)"
                + "VALUES (?, ?, ?, ?, ?);";

        try (Scanner sc = new Scanner(System.in);
            Connection conn = ConnectionDB.getInstance();
        ) {

            System.out.println("--- ALTA ---");
            System.out.println("Introduce el ID del programa: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Introduce el titulo del programa: ");
            String titulo = sc.nextLine();

            System.out.println("Introduce el código del programa: ");
            String codigo = sc.nextLine();

            String solicitudCanal = "Introduce el ID del canal: ";
            String error = "No se ha encontrado el id especificado, vuelva a intentarlo";
            int idCanal = obtenerIdValido(sc, SQL_OBTENER_ID_CANAL, solicitudCanal, error);
            String solicitudGenero = "Introduce el ID del género: ";
            int idGenero = obtenerIdValido(sc, SQL_OBTENER_ID_GENERO, solicitudGenero, error);

            try (PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT_PROGRAMA)) {

                pstmt.setInt(1, id);
                pstmt.setString(2, titulo);
                pstmt.setString(3, codigo);
                pstmt.setInt(4, idCanal);
                pstmt.setInt(5, idGenero);

                pstmt.executeUpdate();
                System.out.println("Programa dado de alta correctamente.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


	}

    private int obtenerIdValido(Scanner sc, String sql, String mensajeSolicitud, String mensajeError) throws SQLException {
        boolean encontrado = false;
        int id = 0;

        while (!encontrado) {
            System.out.println(mensajeSolicitud);
            int idEntrada = sc.nextInt();
            sc.nextLine();

            try (PreparedStatement pstmt = ConnectionDB.getInstance().prepareStatement(sql)) {
                pstmt.setInt(1, idEntrada);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    id = idEntrada;
                    encontrado = true;
                } else {
                    System.out.println(mensajeError);
                }
            }
        }

        return id;
    }

    //ejercicio3
	public void eliminarCanal() {
        final String SQL_DELETE = "DELETE FROM Canales WHERE id_canal = ?;";
        final String SQL_OBTENER_ID_CANAL = "SELECT id_canal FROM Canales WHERE id_canal = ?;";
        try (Scanner sc = new Scanner(System.in);
             Connection conn = ConnectionDB.getInstance();
        ){
            String solicitudCanal = "Introduce el ID del canal: ";
            String errorCanal = "No se ha encontrado el canal especificado.";
            int id = obtenerIdValido(sc, SQL_OBTENER_ID_CANAL, solicitudCanal, errorCanal);

            if (id == 0) {
                return;
            }
            PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Se ha eliminado correctamente.");

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	//ejercicio4
	public void mostrarProgramasGenero() {
        final String SQL_SELECT_PROGRAMAS_GENERO = "SELECT DISTINCT p.titulo, p.codigo_programa, c.nombre " +
                "FROM Programas p " +
                "JOIN Canales c ON c.id_canal = p.id_canal " +
                "JOIN Generos g ON p.id_genero = g.id_genero " +
                "WHERE g.id_genero = ?;";

        int id_genero = pedirGenero();

        try (Connection conn = ConnectionDB.getInstance();
            PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_PROGRAMAS_GENERO);
        ){
            pstmt.setInt(1, id_genero);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String codigo_programa = rs.getString("codigo_programa");
                String nombre = rs.getString("nombre");
                System.out.println("Titulo: " + titulo +  " - Codigo: " + codigo_programa + "- Nombre del canal: " + nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private int obtenerGenero(Scanner sc, String sql, String mensajeSolicitud, String mensajeError) throws SQLException {
        int id = 0;

        System.out.println(mensajeSolicitud);
        int idEntrada = sc.nextInt();
        sc.nextLine();

        try (PreparedStatement pstmt = ConnectionDB.getInstance().prepareStatement(sql)) {
            pstmt.setInt(1, idEntrada);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                id = idEntrada;

            } else {
                    System.out.println(mensajeError);
            }
        }
        return id;
    }

    public int pedirGenero() {
        final String SQL_MOSTRAR_GENEROS = "SELECT id_genero, nombre FROM Generos;";
        try (Connection conn = ConnectionDB.getInstance();
             Statement stmt = conn.createStatement();
             Scanner sc =  new Scanner(System.in);
        ) {
            while (true) {
                ResultSet rs = stmt.executeQuery(SQL_MOSTRAR_GENEROS);
                final String SQL_OBTENER_ID_GENEROS = "SELECT id_genero FROM Generos WHERE id_genero = ?;";
                while (rs.next()) {
                    int idGenero = rs.getInt("id_genero");
                    String nombre = rs.getString("nombre");
                    System.out.println(idGenero + " " + nombre);
                }
                String pedirGenero = "Introduce el código del género: ";
                String errorGenero = "No se ha encontrado el género, vuelva a intentarlo";
                int id_genero = obtenerGenero(sc, SQL_OBTENER_ID_GENEROS, pedirGenero, errorGenero);
                if (id_genero != 0) {
                    return id_genero;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	//ejercicio5
	public void mostrarEstadisticasCanales() {
		final String SQL_ESTADISTICAS_CANALES = "SELECT c.id_Canal, c.nombre, (SELECT count(e.id_emision) as 'emisiones' " +
                "from Emisiones e join tv.Programas P on e.id_programa = P.id_programa " +
                "join tv.Canales C on C.id_canal = P.id_canal where c.id_canal = C.id_canal) " +
                "as 'Emisiones' from Canales c order by 'Emisiones';";

        try (Connection conn = ConnectionDB.getInstance();
             Statement stmt = conn.createStatement();
        ){
            stmt.executeQuery(SQL_ESTADISTICAS_CANALES);
            ResultSet rs = stmt.executeQuery(SQL_ESTADISTICAS_CANALES);
            while (rs.next()) {
                int id_canal =  rs.getInt("id_canal");
                String nombre = rs.getString("nombre");
                String emisiones = rs.getString("emisiones");

                System.out.println("ID canal: " +  id_canal + "- Nombre: " + nombre + " - Emisiones: " + emisiones);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

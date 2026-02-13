import DBConection.DBConnection;

import java.sql.*;

public class GestorVideoclub {
    public void inciciarBD() {
        try (Connection conn = DBConnection.getConnection()){
            Statement stmt = conn.createStatement();

            // Tipos estructurados

            stmt.execute("CREATE TYPE tipo_direccion AS (calle VARCHAR(100), ciudad VARCHAR(50), provincia VARCHAR(50))");
            stmt.execute("CREATE TYPE tipo_director AS (nombre VARCHAR(100), nacionalidad VARCHAR(50))");

            // Tabla cliente

            stmt.execute("CREATE TABLE cliente (" +
                         "id INT PRIMARY KEY, " +
                         "nombre VARCHAR(100), " +
                         "direccion tipo_direccion, " +
                         "edad INT)");

            // Tabla pelicula

            stmt.execute("CREATE TABLE pelicula (" +
                         "titulo VARCHAR(100) PRIMARY KEY, " +
                         "director tipo_director, " +
                         "prestado INT DEFAULT 0, " +
                         "CONSTRAINT fk_cliente FOREIGN KEY (prestado) REFERENCES cliente(id))");

            // Cliente 0 (videoclub)

            stmt.execute("INSERT INTO cliente VALUES (0, 'VIDEOCLUB', ('Sede', 'Central', 'Sistema'), 0)");

            System.out.println("Se ha creado la base de datos correctamente.");
        } catch (Exception e) {
            System.out.println("Los tipos o tablas ya existen.");
        }
    }

    public void insertarDatos() {
        final String SQL_CLIENTE = "INSERT INTO cliente VALUES (?, ?, (?, ?, ?), ?)";
        final String SQL_PELICULA = "INSERT INTO pelicula VALUES (?, (?, ?), ?)";

        try (Connection conn = DBConnection.getConnection()){

            PreparedStatement pstmt1 = conn.prepareStatement(SQL_CLIENTE);
            pstmt1.setInt(1, 1); pstmt1.setString(2, "Jorge Hernández");

            pstmt1.setString(3, "Calle Mayor");
            pstmt1.setString(4, "Madrid");
            pstmt1.setString(5, "Madrid");

            pstmt1.setInt(6, 19);
            pstmt1.executeUpdate();

            PreparedStatement pstmt2 = conn.prepareStatement(SQL_PELICULA);
            pstmt2.setString(1, "Inception");
            pstmt2.setString(2, "Christopher Nolan"); pstmt2.setString(3, "Britanica");
            pstmt2.setInt(4, 1); // Prestada a Jorge
            pstmt2.executeUpdate();

            PreparedStatement pstmt3 = conn.prepareStatement(SQL_PELICULA);
            pstmt3.setString(1, "Pulp Fiction");
            pstmt3.setString(2, "Quentin Tarantino");
            pstmt3.setString(3, "Estadounidense");
            pstmt3.setInt(4, 0);
            pstmt3.executeUpdate();
            System.out.println("Se han insertado todos los datos.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarTodo() {
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT id, nombre, (direccion).calle, (direccion).ciudad FROM cliente");
            System.out.println("--- CLIENTES ---");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarPrestamos() {
        String sql = "SELECT p.titulo, (p.director).nombre, c.nombre, (c.direccion).ciudad " +
                     "FROM pelicula p JOIN cliente c ON p.prestado = c.id " +
                     "WHERE p.prestado <> 0";

        try (Connection conn = DBConnection.getConnection();
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            System.out.println("--- PRÉSTAMOS ---");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " de " + rs.getString(2) + " prestado a: " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPorDirector(String nombreDir) {

        String sql = "DELETE FROM pelicula WHERE (director).nombre = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreDir);
            int filas = pstmt.executeUpdate();
            System.out.println("Se eliminaron " + filas + " películas.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProvincia() {

        String sql = "UPDATE cliente SET direccion.provincia = 'Almería' WHERE id <> 0";

        try (Connection con = DBConnection.getConnection()) {
            con.createStatement().executeUpdate(sql);
            System.out.println("Provincia actualizada a Almería para todos los clientes.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

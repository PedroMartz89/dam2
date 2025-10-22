import javax.sound.midi.Soundbank;
import javax.sound.midi.SysexMessage;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        menu();
    }

    public static void menu() throws SQLException {
        boolean continuar = true;
        while (continuar) {

            System.out.println("""
                    1. Llamar procedimiento.
                    2. Ejecutar transacción.
                    3. Mostrar metadatos de la BD.
                    4. Salir.
                    """);

            System.out.println("Elije una opción: ");
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    insertaOActualizaClienteMenu(sc);
                    break;
                case 2:
                   ejecutarTransaccion(sc);
                   break;
                case 3:
                    mostrarMetadatos();
                    break;
                case 4:
                    continuar = false;
                    break;
            }

        }
    }

    public static void insertaOActualizaClienteMenu(Scanner sc) throws SQLException {

        System.out.print("\nIntroduce el DNI del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("\nIntroduce el apellido del cliente: ");
        String apellido = sc.nextLine();
        System.out.println("\nIntroduce el CP del cliente: ");
        String cp = sc.nextLine();
        insertaOActualizaCliente(nombre, apellido, cp);
        System.out.println("Procedimiento ejecutado correctamente!");
    }
    public static void insertaOActualizaCliente(String dni, String apellido, String cp) throws SQLException {

        Connection conn = ConnectionDB.getInstance();
        CallableStatement cs = conn.prepareCall("{call insertaOActualizaCliente(?, ?, ?)}");
        cs.setString(1, dni);
        cs.setString(2, apellido);
        cs.setString(3, cp);
        cs.execute();
        System.out.println("Cliente insertado o actualizado correctamente.");
        cs.close();



    }

    private static void ejecutarTransaccion(Scanner sc) throws SQLException {
        System.out.println("\n=== Actualizar Apellidos de 2 Clientes ===");
        Connection conn = ConnectionDB.getInstance();
        try {
            conn.setAutoCommit(false);

            for (int i = 1; i <= 2; i++) {
                System.out.print("Ingrese DNI del cliente " + i + ": ");
                String dni = sc.nextLine();
                System.out.print("Ingrese nuevos Apellidos: ");
                String apellidos = sc.nextLine();

                String sql = "UPDATE CLIENTES SET apellidos = ? WHERE dni = ?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, apellidos);
                    ps.setString(2, dni);

                    int filas = ps.executeUpdate();
                    if (filas == 0) {
                        throw new SQLException("No se encontró cliente con DNI: " + dni);
                    }
                }
            }

            conn.commit();
            System.out.println("Transacción completada correctamente.");

        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Error en la transacción. Se realizó rollback.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true); // Volvemos a autocommit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mostrarMetadatos() throws SQLException {
        Connection conn = ConnectionDB.getInstance();
        try {
            DatabaseMetaData meta = conn.getMetaData();

            System.out.println("\n=== METADATOS DE LA BASE DE DATOS ===");
            System.out.println("Soporta transacciones: " + meta.supportsTransactions());
            System.out.println("Número máximo de conexiones: " + meta.getMaxConnections());


            System.out.println("\nFunciones de cadena disponibles:");
            String sql = "SELECT ROUTINE_NAME FROM INFORMATION_SCHEMA.ROUTINES WHERE ROUTINE_TYPE='FUNCTION'";
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println("- " + rs.getString("ROUTINE_NAME"));
                }
            }

            System.out.println("\nColumnas de la tabla country:");
            try (ResultSet columnas = meta.getColumns(null, null, "country", "%")) {
                while (columnas.next()) {
                    System.out.println(columnas.getString("COLUMN_NAME") + " - " + columnas.getString("TYPE_NAME"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener metadatos de la base de datos.");
            e.printStackTrace();
        }
    }
}

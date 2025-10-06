import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        menu();
    }

    public static void createTable() throws SQLException {

        String sql = "CREATE TABLE alumno2904647 (id INT PRIMARY KEY, nombre VARCHAR(50), apellido VARCHAR(50), edad INT);";
        Connection connection = ConexionBD.getInstance();
        Statement stm = connection.createStatement();
        stm.executeUpdate(sql);
        System.out.println("Tabla creada correctamente.");
    }

    public static void insertAlumno() throws SQLException {

        String sql = "insert into alumno2904647 values(1, 'Roberto', 'Company', 20);";
        Connection connection = ConexionBD.getInstance();
        Statement stm = connection.createStatement();
        stm.executeUpdate(sql);
        System.out.println("INSERT ejecutado correctamente.");
    }

    public static void mostrarTabla() throws SQLException {
        String sql = "select * from alumno2904647;";
        Connection connection = ConexionBD.getInstance();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int edad = rs.getInt("edad");

            System.out.println();
            System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad);

        }
    }

    public static void vaciarTabla() throws SQLException {
        String sql = "delete from alumno2904647;";
        Connection connection = ConexionBD.getInstance();
        Statement stm = connection.createStatement();
        stm.executeUpdate(sql);
        System.out.println("Tabla alumno2904647 limpiada.");
    }

    public static void deleteTable() throws SQLException {
        String sql = "drop table alumno2904647;";
        Connection connection = ConexionBD.getInstance();
        Statement stm = connection.createStatement();
        stm.executeUpdate(sql);
        System.out.println("Tabla alumno2904647 eliminada.");
    }

    public static void menu() throws SQLException {
        String menu = """
                1- Crear tabla alumno.\
                
                2- Insertar alumno2.\
                
                3- Mostrar tabla alumno.\
                
                4- Vaciar tabla alumno.\
                
                5- Borrar tabla alumno.\
                
                6- Salir.""";

        while (true) {
            System.out.println("----- ELIGE UNA OPCIÓN -----");
            System.out.println(menu);
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    createTable();
                    break;
                case 2:
                    insertAlumno();
                    break;
                case 3:
                    mostrarTabla();
                    sc.nextLine();
                    System.out.println("Presione ENTER para continuar...");
                    String continuar = sc.nextLine();
                    break;
                case 4:
                    vaciarTabla();
                    break;
                case 5:
                    deleteTable();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Introduce una opción válida.");
                    break;
            }
        }

    }
}

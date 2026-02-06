public class Main {
    public static void main(String[] args) {
        GestorVideoclub gestorVideoclub = new GestorVideoclub();

        gestorVideoclub.inciciarBD();
        gestorVideoclub.insertarDatos();
        gestorVideoclub.mostrarTodo();
        gestorVideoclub.mostrarPrestamos();
        gestorVideoclub.eliminarPorDirector("Quentin Tarantino");
        gestorVideoclub.mostrarTodo();
        gestorVideoclub.actualizarProvincia();
    }
}

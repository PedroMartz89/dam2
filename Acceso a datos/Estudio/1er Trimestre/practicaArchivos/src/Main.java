import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static Path dirActual;
    private static Path dirPersonal;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        dirPersonal = Paths.get(System.getProperty("user.home"));
        dirActual = dirPersonal.resolve("Desktop");
        menu(sc);
    }

    public static void mostrarDirCarpetaActual() {

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dirActual)) {

            for (Path p : directoryStream) {
                System.out.println("Directorio: " + p.getFileName());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cambiarDirectorio(Scanner sc) {

        System.out.println("A que directorio quieres cambiar: ");
        String nuevoDir = sc.nextLine();
        Path pathNuevoDir = dirActual.resolve(nuevoDir);

        if (nuevoDir.isEmpty()) {
            System.out.println("Introduce un directorio.");
            return;
        }

        if (!Files.exists(pathNuevoDir)) {
            System.out.println("No existe el directorio.");
            return;
        }

        if (nuevoDir.equals("..")) {

            Path parent = dirActual.getParent();

            if (parent == null) {
                System.out.println("No existe directorio padre.");
            }

            dirActual = parent;

        } else {

            Path directorioCambiar = dirActual.resolve(nuevoDir);
            if (!Files.exists(directorioCambiar)) {
                System.out.println("No existe el directorio al que quieres cambiar.");
            }

            if (!Files.isDirectory(directorioCambiar)) {
                System.out.println("No es un directorio.");
            }

            dirActual = directorioCambiar.normalize();
            System.out.println("Nueva ruta establecida.");
        }

    }

    public static void crearArchivoDirActual(Scanner sc) {

        System.out.println("Introduce el nombre del archivo: ");
        String archivoNuevo = sc.nextLine();

        Path rutaArchivoNuevo = dirActual.resolve(archivoNuevo);

        if (Files.exists(rutaArchivoNuevo)) {
            System.out.println("La ruta especificada ya existe.");
            return;
        }

        try {
            Files.createFile(rutaArchivoNuevo);

            BufferedWriter bw = Files.newBufferedWriter(rutaArchivoNuevo);
            bw.write("Pedro Martinez Sanchez");
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mostrarContenidoFichero(Scanner sc) {
        System.out.println("Introduce el nombre del fichero a leer: ");
        String ficheroLeer = sc.nextLine();

        Path pathFichero = dirActual.resolve(ficheroLeer);

        if (Files.isDirectory(pathFichero)) {
            System.out.println("Es un directorio.");
            return;
        }

        if (!Files.exists(pathFichero)) {
            System.out.println("El fichero no existe.");
            return;
        }

        try (BufferedReader br = Files.newBufferedReader(pathFichero);){

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void anadirLineaFichero(Scanner sc) {
        System.out.println("Introduce el fichero a editar: ");
        String fichero = sc.nextLine();

        System.out.println("Introduce la linea a añadir: ");
        String lineaNueva = sc.nextLine();

        Path pathFichero = dirActual.resolve(fichero);

        if (Files.isDirectory(pathFichero)) {
            System.out.println("Es un directorio.");
            return;
        }

        if (!Files.exists(pathFichero)) {
            System.out.println("El fichero no existe.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(pathFichero), true));) {

            bw.write("\n"+lineaNueva);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void eliminarFicheroCarpetaActual(Scanner sc) {
        System.out.println("Introduce el nombre del fichero: ");
        String ficheroBorrar = sc.nextLine();

        Path rutaFicheroBorrar = dirActual.resolve(ficheroBorrar);

        if (Files.isDirectory(rutaFicheroBorrar)) {
            System.out.println("Es un directorio.");
            return;
        }

        if (!Files.exists(rutaFicheroBorrar)) {
            System.out.println("El fichero no existe.");
            return;
        }

        try {
            Files.delete(rutaFicheroBorrar);

        } catch (IOException e) {
            System.out.println("No se ha podido borrar el fichero.");
        }
    }

    public static void menu(Scanner sc) throws IOException {

        boolean salir = false;

        while (!salir) {

            System.out.println();
            System.out.println("--- Menú ---");
            System.out.println("Directorio actual: " + dirActual.toString());
            System.out.println("1. Mostrar directorios y archivos de la carpeta actual.");
            System.out.println("2. Cambiar a un subdirectorio o directorio padre.");
            System.out.println("3. Crear un nuevo archivo de texto en la carpeta actual.");
            System.out.println("4. Mostrar el contenido de un archivo de texto de la carpeta actual.");
            System.out.println("5. Añadir una nueva línea de texto a un archivo de la carpeta actual.");
            System.out.println("6. Eliminar un archivo de la carpeta actual.");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            String lineaOpcion = sc.nextLine();
            int opcion;

            try {
                opcion = Integer.parseInt(lineaOpcion);
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    mostrarDirCarpetaActual();
                    break;
                case 2:
                    cambiarDirectorio(sc);
                    break;
                case 3:
                    crearArchivoDirActual(sc);
                    break;
                case 4:
                    mostrarContenidoFichero(sc);
                    break;
                case 5:
                    anadirLineaFichero(sc);
                    break;
                case 6:
                    eliminarFicheroCarpetaActual(sc);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        System.out.println("Programa finalizado.");
    }
}

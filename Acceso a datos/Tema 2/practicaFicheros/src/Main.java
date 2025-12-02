import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static Path dirActual;
    public static Path dirPersonal;

    static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        dirPersonal = Paths.get(System.getProperty("user.home"));
        dirActual = dirPersonal.resolve("Desktop");
        menu(sc);
    }

    /**
     *
     * Metodo que gestiona el menu de opciones que interactua con el usuario
     *
     * @param sc para obtener la opción que introduce el usuario por consola
     * @throws IOException para controlar las posibles excepciones de los ficheros
     */
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
                    cambiarSubdirectorio(sc);
                    break;
                case 3:
                    crearArchivo(sc);
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

    /**
     * Metodo que permite eliminar un archivo de la carpeta donde nos encontramos
     * @param sc para recibir el nombre del fichero a borrar
     */
    private static void eliminarFicheroCarpetaActual(Scanner sc) {
        System.out.println("Introduce el fichero para borrar: ");
        String fichero = sc.nextLine();
        Path ficheroBorrar = dirActual.resolve(fichero);

        if (!Files.exists(ficheroBorrar)) {
            System.out.println("El fichero no existe");
            return;
        }

        if (Files.isDirectory(ficheroBorrar)) {
            System.out.println("Es un directorio");
            return;
        }

        if (Files.exists(ficheroBorrar)) {

            try {
                Files.delete(ficheroBorrar);
                System.out.println("Se ha eliminado el fichero " + fichero);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * Metodo que permite añadir una nueva linea en el fichero que el usuario ingrese por consola.
     *
     * @param sc para pedir al usuario que ingrese tanto el fichero a editar como el texto a añadir.
     * @throws IOException excepcion que controla los posibles errores al leer el fichero
     */
    private static void anadirLineaFichero(Scanner sc) throws IOException {
        System.out.println("Introduce el fichero para añadir la línea: ");
        String fichero = sc.nextLine();
        System.out.println("Introduce el texto a añadir: ");
        String lineaNueva = sc.nextLine();

        Path ficheroEscribir = dirActual.resolve(fichero);

        if (!Files.exists(ficheroEscribir)) {
            System.out.println("El fichero no existe");
        }

        if (Files.isDirectory(ficheroEscribir)) {
            System.out.println("Es un directorio");
        }

        if (Files.exists(ficheroEscribir)) {

            BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(ficheroEscribir), true));
            bw.write("\n"+lineaNueva);
            bw.close();
        }
    }

    /**
     * Metodo que permite mostrar el contenido de un fichero que este en el directorio actual.
     * @param sc para recibir por teclado el fichero que el usuario quiere abrir.
     * @throws IOException excepcion que controla los posibles errores al leer el fichero
     */
    private static void mostrarContenidoFichero(Scanner sc) throws IOException {

        System.out.println("Introduce el fichero para abrir: ");
        String fichero = sc.nextLine();

        Path ficheroLeer = dirActual.resolve(fichero);

        if (Files.exists(ficheroLeer)) {

            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(ficheroLeer)));
            String lineas = "";
            while ((lineas = br.readLine()) != null) {
                System.out.println(lineas);
            }

            br.close();
        }

        if (Files.isDirectory(ficheroLeer)) {
            System.out.println("El archivo escrito es un directorio");
        }

        if (!Files.exists(ficheroLeer)) {
            System.out.println("El fichero no existe.");
        }
    }

    /**
     * Metodo que permite crear un archivo nuevo y añadir automaticamnete la linea 'Pedro Martinez Sanchez' a este.
     * @param sc para recibir por teclado el nombre del archivo que el usuario quiere crear en el directorio actual.
     * @throws IOException excepcion que controla los posibles errores al leer el fichero
     */
    private static void crearArchivo(Scanner sc) throws IOException {


        System.out.println("Introduce el nombre del archivo a crear: ");
        String ficheroNuevo = sc.nextLine();

        Path rutaFicheroNuevo = dirActual.resolve(ficheroNuevo);

        if (Files.exists(rutaFicheroNuevo)) {
            System.out.println("El fichero ya existe.");
            return;
        }

        Files.createFile(rutaFicheroNuevo);

        BufferedWriter bw = Files.newBufferedWriter(rutaFicheroNuevo);
        bw.write("Pedro Martínez Sánchez");
        bw.close();

        System.out.println("Se ha creado el fichero correctamente.");
    }

    /**
     * Metodo que permite al usuario cambiar tanto a un subdirectorio como al directorio padre.
     * @param sc para recibir por consola el nombre del subdirectorio o '..' para acceder al padre.
     */
    private static void cambiarSubdirectorio(Scanner sc) {

        System.out.println("Introduce el nombre del subdirectorio: ");
        String opcion = sc.nextLine();

        if (opcion.isEmpty()) {
            System.out.println("No se ha introducido niguna ruta.");
            return;
        }

        if (opcion.equals("..")){
            Path parent = dirActual.getParent();

            if (parent == null) {
                System.out.println("No existe directorio padre.");
                return;
            }

            setPathActual(parent.normalize());
            System.out.println("Se ha cambiado el directorio actual al directorio padre.");

        } else {

            Path rutaCandidata = dirActual.resolve(opcion);

            if (!Files.exists(rutaCandidata)) {
                System.out.println("No existe la ruta indicada.");
            }

            if (!Files.isDirectory(rutaCandidata)) {
                System.out.println("La ruta especificada no es un directorio.");
            }

            setPathActual(rutaCandidata.normalize());
            System.out.println("Se ha establecido la nueva ruta.");
        }
    }

    /**
     * Metodo que permite listar todo el directorio actual y mostrar informacion relevante sobre este.
     */
    public static void mostrarDirCarpetaActual() {

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dirActual)){

            for (Path p : directoryStream) {
                if (Files.isDirectory(p)) {
                    System.out.println("Nombre : " + p.getFileName());
                    System.out.println("Última vez modificado: " + Files.getLastModifiedTime(p));
                    System.out.println("Tamaño: " + (calcularTamanoDir(p) / 1024));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo auxiliar para calcular el tamaño en Kb de un directorio.
     *
     * @param dir directorio con tipo Path que calcularemos
     * @return devuelve un long con el tamaño del directorio
     * @throws IOException excepcion que controla los posibles errores al leer el fichero
     */
    private static long calcularTamanoDir(Path dir) throws IOException {
        final long[] tamano = {0};

         Files.walk(dir).forEach(ruta -> {
         if (Files.isRegularFile(ruta)) {
             try {
                 tamano[0] += Files.size(ruta);
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }

        });

        return tamano[0];
    }

    /**
     * Metodo setter para cambiar el valor del path actual a uno nuevo pasado por parámetros.
     * @param nuevoPath nuevo Path que contiene el nuevo directorio actual.
     */
    public static void setPathActual(Path nuevoPath) {

        dirActual = nuevoPath;
    }
}

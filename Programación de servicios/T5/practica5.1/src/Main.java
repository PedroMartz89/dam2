import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static Path directorioOrigen;
    private static Path directorioDestino;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
        int opcion = Integer.parseInt(scanner.nextLine());
        boolean continuar = true;
        while (continuar){
            try {
                switch (opcion) {
                    case 1 -> {
                        establecerDirectorio();
                    }
                    case 2 -> {
                        crearCopiaCifrada();
                    }
                    case 3 -> verificarIntegridad();
                    case 4 -> {
                        System.out.println("Saliendo.");
                        continuar = false;
                    }
                    default -> System.out.println("Opción no válida.");
                }
                mostrarMenu();
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public static void mostrarMenu() {
        System.out.println("\n--- Menú de control ---");
        System.out.println("1. Establecer directorio de origen y destino.");
        System.out.println("2. Copiar directorio origen a destino.");
        System.out.println("3. Verficiar integridad.");
        System.out.println("4. Salir");
    }
    public static void establecerDirectorio() {
        System.out.print("Introduce la ruta del directorio origen: ");
        directorioOrigen = Paths.get(scanner.nextLine());
        System.out.print("Introduce la ruta del directorio destino: ");
        directorioDestino = Paths.get(scanner.nextLine());

        if (Files.exists(directorioOrigen) && Files.isDirectory(directorioOrigen)) {
            System.out.println("Directorios configurados correctamente.");
        } else {
            System.out.println("Error: El directorio de origen no existe.");
        }
    }

    public static void crearCopiaCifrada() throws Exception {
        if (directorioOrigen == null || directorioDestino == null) {
            throw new Exception("Debe configurar los directorios primero.");
        }

        System.out.print("Introduce la clave secreta: ");
        String claveTexto = scanner.nextLine();
        SecretKeySpec secretKey = ServicioCifrado.generarClave(claveTexto);

        if (!Files.exists(directorioDestino)) Files.createDirectories(directorioDestino);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorioOrigen)) {
            for (Path archivo : stream) {
                if (Files.isRegularFile(archivo)) {
                    Path archivoDestino = directorioDestino.resolve(archivo.getFileName());

                    // Cifraro
                    byte[] contenidoCifrado = ServicioCifrado.procesarAES(Files.readAllBytes(archivo), secretKey, Cipher.ENCRYPT_MODE);
                    Files.write(archivoDestino, contenidoCifrado);

                    // Generar Hash SHA-256 del archivo
                    String hash = ServicioCifrado.calcularHash(archivoDestino);

                    // Crear fichero .CHK
                    Path archivoChk = directorioDestino.resolve(archivo.getFileName().toString() + ".CHK");
                    Files.writeString(archivoChk, hash);

                    System.out.println("Procesado: " + archivo.getFileName());
                }
            }
        }
        System.out.println("Se ha cifrado todo correctamente.");
    }

    private static void verificarIntegridad() throws Exception {
        if (directorioDestino == null || !Files.exists(directorioDestino)) {
            throw new Exception("El directorio destino no existe.");
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorioDestino)) {
            for (Path archivoCifrado : stream) {
                String nombreBase = archivoCifrado.getFileName().toString();

                if (!nombreBase.endsWith(".CHK")) {
                    Path archivoChk = directorioDestino.resolve(nombreBase + ".CHK");

                    if (!Files.exists(archivoChk)) {
                        System.out.println("[ERROR] Falta el fichero .CHK para: " + nombreBase);
                        continue;
                    }

                    String hashCalculado = ServicioCifrado.calcularHash(archivoCifrado);
                    String hashGuardado = Files.readString(archivoChk).trim();

                    if (hashCalculado.equals(hashGuardado)) {
                        System.out.println("[OK] " + nombreBase + " no ha sido modificado");
                    } else {
                        System.out.println("[!] " + nombreBase + " HA SIDO ALTERADO");
                    }
                }
            }
        }
    }
}
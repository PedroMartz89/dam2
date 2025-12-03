package ra1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ficheros {
	
	//ejercicio6
	public List<String> obtenerFicherosMasRecientesQueFichero(String rutaFichero, String rutaDirectorio) {
		Path pathFichero = Paths.get(rutaFichero);
        Path pathActual = Paths.get(System.getProperty("user.dir"));
        if (Files.notExists(pathFichero)) {
            return null;

        } else {
            List<String> listaFicheros = new ArrayList<>();
            if (Files.isDirectory(pathFichero)) {
                return listaFicheros;
            }
            Path directorio = Paths.get(rutaDirectorio);
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directorio)){

                for (Path file : directoryStream) {
                    if (Files.getLastModifiedTime(file).toMillis() > Files.getLastModifiedTime(directorio).toMillis()) {
                        listaFicheros.add(file.toAbsolutePath().toString());
                    }
                }
                return listaFicheros;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
	}
	
	//ejercicio7
	public Pelicula buscarPeliculaMasRecaudacion(String rutaFichero, float recaudacion) {

        try (RandomAccessFile raf = new RandomAccessFile(rutaFichero, "r")) {

            raf.setLength(0);

            while (raf.readLine() != null) {
                int anyo = raf.readInt();
                long recaudacionD = raf.readLong();
                String titulo = raf.readUTF();
                if (recaudacionD >= recaudacion) {
                    return new Pelicula(anyo, recaudacionD, titulo);
                }
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
	
	//ejercicio8
	public void miniProcesadorTextos() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del fichero:");
            String fichero = sc.nextLine();
            Path ficheroPath = Paths.get(fichero);
            System.out.println(ficheroPath);
            Path ficheroPathAbsoluto =  Paths.get(ficheroPath.toAbsolutePath().toString());
            System.out.println(ficheroPathAbsoluto);
            if (Files.exists(ficheroPath)) {
                Files.delete(ficheroPath);
            }

            while (true) {
                System.out.println("Quieres codificación por defecto o iso-8859-1? : (1 - 2)");
                int opcion = sc.nextInt();
                if (opcion != 1 && opcion != 2) {
                    System.out.println("Introduce una opción correcta");

                } else {
                    sc.nextLine();
                    int lineasEcritas = 0;
                    while (true) {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(ficheroPathAbsoluto), true))) {

                            System.out.println("Introduce una línea de texto: ");
                            String texto = sc.nextLine();

                            if (texto.equals("bye")) {
                                System.out.println("Terminando el programa y cerrando fichero...");
                                System.exit(0);
                            } else if (texto.equals("lineas?")) {
                                System.out.println("Se han escrito " + lineasEcritas + " lineas.");
                                continue;
                            }
                            if (opcion == 1) {
                                bw.write(texto + "\n");
                                lineasEcritas++;
                            } else {
                                try {
                                    FileOutputStream fos = new FileOutputStream(fichero);
                                    OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1);
                                    Writer writer = new BufferedWriter(osw);

                                    writer.write(texto);
                                    writer.close();
                                    fos.close();
                                    osw.close();
                                    lineasEcritas++;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }

                    }

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

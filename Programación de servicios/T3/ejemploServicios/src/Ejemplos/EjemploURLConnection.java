package Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EjemploURLConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://aulavirtual.iescierva.net/");

            //Obtener la conexión
            URLConnection conn = url.openConnection();

            //Crear reader
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            reader.close();
        } catch (MalformedURLException e) {
            System.err.println("La URL no tiene un formato correcto.");
        } catch (IOException e) {
            System.err.println("No se ha podido conectar a la URL.");
        }
    }
}

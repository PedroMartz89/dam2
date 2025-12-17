package Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class EjemploURLConnectionEscritura {
    public static void main(String[] args) {

        try {
            //PASO 1: Crear URL
            URL url = URI.create("http://79.109.156.94/cgi-bin/backwards.pl").toURL();

            //PASO 2: Obtener la conexion
            URLConnection connection = url.openConnection();

            //PASO 3: Establecer la capacidad de salida
            connection.setDoOutput(true);

            //PASO 4: Obtener los streams y envolverlo en un Writer
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

            //PASO 5: Escribir los datos
            String datos = "string=" + URLEncoder.encode("Hola Mundo", StandardCharsets.UTF_8);
            out.write(datos);
            out.close();

            //PASO 6: Lectura de la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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

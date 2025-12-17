package Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/*
* La clase URL nos permite conectarnos a un servidor web
* Con url.OpenStream() empezamos a leer datos directamente de la web
* Con url.OpenConnection() recibimos un objeto URLConnection que permite leer metadatos
* */
public class EjemploURL {
    public static void main(String[] args) {
        try {
            //Definir la URL a consultar
            URL url = new URL("https://www.google.com");

            //Abrir flujo de lectura
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

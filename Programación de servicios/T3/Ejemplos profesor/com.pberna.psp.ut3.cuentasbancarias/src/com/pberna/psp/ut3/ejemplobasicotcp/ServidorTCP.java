package com.pberna.psp.ut3.ejemplobasicotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public void inicioEscuchaPeticiones() {
		try (ServerSocket server = new ServerSocket(8888);){
			while(true) {
				//quedamos a la espera de peticiones
				System.out.println("Soy el servidor y escucho peticiones en el puerto 8888");						
				Socket socket = server.accept();			
				System.out.println("Ha llegado una nueva petición");
				
				InputStream inputStream = socket.getInputStream();
				//OutputStream outputStream = socket.getOutputStream();
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inputStream));
				
				GestionarConexionTCP gestionConexiones = new GestionarConexionTCP(reader);
				gestionConexiones.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

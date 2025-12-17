package com.pberna.psp.ut3.cuentasbancarias;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServidorCuentasBancarias {
	
	private List<CuentaBancaria> listaCuentas;
	
	public ServidorCuentasBancarias() {
		listaCuentas = new LinkedList<CuentaBancaria>();
	}

	public void inicioEscuchaPeticiones() {
		try (ServerSocket server = new ServerSocket(8888);){
			while(true) {
				//quedamos a la espera de peticiones
				System.out.println("Soy el servidor y escucho peticiones en el puerto 8888");						
				Socket socket = server.accept();			
				System.out.println("Ha llegado una nueva petición");			
								
				GestionConexionCuentaBancaria gestionConexiones = 
						new GestionConexionCuentaBancaria(socket, listaCuentas);
				gestionConexiones.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

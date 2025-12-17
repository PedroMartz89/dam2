package com.pberna.psp.ut3.ejemplobasicotcp;

import java.io.BufferedReader;
import java.io.IOException;

public class GestionarConexionTCP extends Thread {

	private BufferedReader reader;
	
	public GestionarConexionTCP(BufferedReader reader) {
		this.reader = reader;
	}
	
	@Override
	public void run() {
		
		//escribe todo lo que le llega por consola
		while(true) {
			
			try {
				String linea = reader.readLine();
				System.out.println("Cliente ha enviado :" + linea);
			} catch (IOException e) {
				System.err.println("Ha habido un error en la comunicación con el cliente");
				e.printStackTrace();
			}		
		}
	}
	
}

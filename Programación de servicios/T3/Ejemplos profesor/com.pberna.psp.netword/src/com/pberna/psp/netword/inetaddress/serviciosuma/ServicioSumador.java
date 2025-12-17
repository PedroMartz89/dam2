package com.pberna.psp.netword.inetaddress.serviciosuma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServicioSumador {
	public void aceptarPeticionesSuma() {
		try (ServerSocket server = new ServerSocket(8888);){			
			
			System.out.println("Soy el servidor y espero alguna conexión");
			
			while(true) {				
				try(Socket socket = server.accept();) {
								
					System.out.println("Ha llegado una nueva petición");
					
					try(InputStream inputStream = socket.getInputStream();
						OutputStream outputStream = socket.getOutputStream();) {
						InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
						OutputStreamWriter outputStreamReader = new OutputStreamWriter(outputStream);
						
						procesarSolicitudSuma(inputStreamReader, outputStreamReader);	
					}					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void procesarSolicitudSuma(InputStreamReader inputStreamReader, OutputStreamWriter outputStreamWriter) {
		
		
		try (BufferedReader br = new BufferedReader(inputStreamReader);
				BufferedWriter bw = new BufferedWriter(outputStreamWriter);) {
			String peticion = br.readLine();
			String []datosPeticion = peticion.split("[+]");
			
			if(datosPeticion.length != 2) {
				throw new ProtocoloSumadorException("No se ha mandado la petición con el formato correcto:" +
						peticion);				
			}
			
			int primerNumero = Integer.parseInt(datosPeticion[0]);
			int segundoNumero = Integer.parseInt(datosPeticion[1]);
			
			int resultado = primerNumero + segundoNumero;
			
			bw.write(resultado + "");
			bw.newLine();
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocoloSumadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

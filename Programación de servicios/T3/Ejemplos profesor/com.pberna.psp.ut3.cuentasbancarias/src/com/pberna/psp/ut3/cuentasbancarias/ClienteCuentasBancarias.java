package com.pberna.psp.ut3.cuentasbancarias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteCuentasBancarias {
	
	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in);
			Socket socket = new Socket("localhost", 8888)){
			
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);		
			BufferedReader reader = new BufferedReader(inputStreamReader);				
			PrintWriter writer = new PrintWriter(outputStream);	
									
			while(true) {
				System.out.println("Escriba el mensaje para el servidor");
				String mensaje = scanner.nextLine();
				
				System.out.println("Mandamos el mensaje " + mensaje);
				
				//mandamos el mensaje
				writer.println(mensaje);
				writer.flush();
				
				if(mensaje.equals("QUIT")) {
					break;
				}
				
				//leemos la respuesta y la mostramos
				System.out.println("Vamos a leer la respuesta");
				String respuesta = reader.readLine();
				System.out.println("Respuesta:" + respuesta);
			}		
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

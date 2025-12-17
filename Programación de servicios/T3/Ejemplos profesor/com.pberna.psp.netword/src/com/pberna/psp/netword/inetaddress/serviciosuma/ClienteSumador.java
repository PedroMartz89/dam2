package com.pberna.psp.netword.inetaddress.serviciosuma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteSumador {
	public static void main(String[] args) throws Exception {	
				
		if(args.length != 2) {
			System.err.println("Uso: ClienteSumador <numero1> <numero2>");
			return;
		}
		
		int numero1 = Integer.parseInt(args[0]);
		int numero2 = Integer.parseInt(args[1]);
		
		try (Socket socket = new Socket("localhost",8888);){
						
			System.out.println("Voy a hacer una nueva petición");
			
			try {
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
				
				hacerPeticionSuma(inputStreamReader, outputStreamWriter, numero1, numero2);	
			} catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	private static void hacerPeticionSuma(InputStreamReader inputStreamReader, OutputStreamWriter outputStreamWriter,
			int numero1, int numero2) {
		try (BufferedWriter bw = new BufferedWriter(outputStreamWriter);
			  BufferedReader br = new BufferedReader(inputStreamReader);) {
			bw.write(numero1+ "+" + numero2);
			bw.newLine();
			bw.flush();
			
			String respuesta = br.readLine();
			
			System.out.println("Respuesta:" + respuesta);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.pberna.psp.ut3.echo_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorEchoUdp {
	public void escucharPeticionesEcho() {
		DatagramSocket socketUDP = null;

		try {
			// 1. Crear un server socket, local port number
			socketUDP = new DatagramSocket(7777);
			
			// buffer para incoming data
			byte[] buffer = new byte[65536];
			DatagramPacket nuevoDatagramaUDP = new DatagramPacket(buffer, buffer.length);
			
			// 2. Esperar incoming data
			System.out.println("Server socket creado. Esperando datos entrantes...");
			
			// communication loop
			while (true) {
				socketUDP.receive(nuevoDatagramaUDP);				
				byte[] data = nuevoDatagramaUDP.getData();
				
				System.out.println("Ha llegado un nuevo mensaje");
								
				//convertimos a texto
				String mensajeComoTexto = new String(data, 0, nuevoDatagramaUDP.getLength());
				
				// echo incoming data - client ip : client port - client message
				System.out.println(nuevoDatagramaUDP.getAddress().getHostAddress() 
						+ " : " + nuevoDatagramaUDP.getPort() + " - " + mensajeComoTexto);
				
				//mensaje de respuesta
				mensajeComoTexto = "OK : " + mensajeComoTexto;
				
				//Mandamos el mensaje de respuesta al que nos ha enviado el mensaje
				DatagramPacket datagramaUDPRespuesta = new DatagramPacket(
						mensajeComoTexto.getBytes(), 
						mensajeComoTexto.getBytes().length, 
						nuevoDatagramaUDP.getAddress(), 
						nuevoDatagramaUDP.getPort());
				socketUDP.send(datagramaUDPRespuesta);
			}
		} catch (IOException e) {
			System.err.println("IOException " + e);
		}
	}

}

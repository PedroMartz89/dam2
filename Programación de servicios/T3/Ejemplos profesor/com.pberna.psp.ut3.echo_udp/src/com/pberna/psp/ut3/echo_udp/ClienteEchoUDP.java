package com.pberna.psp.ut3.echo_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteEchoUDP {
	public static void main(String args[]) {
		DatagramSocket socketUDP = null;

		int port = 7777;		
		BufferedReader cin = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			socketUDP = new DatagramSocket();
			InetAddress host = InetAddress.getByName("localhost");
			
			while (true) {
				// Lee la entrada y envía el mensaje
				System.out.println("Introduzca el mensaje a enviar : ");
				String mensaje = cin.readLine();
				
				//Convertimos de String a aray de bytes
				byte[] mensajeEnBytes = mensaje.getBytes();				
				DatagramPacket datagramaUDP = new DatagramPacket(
						mensajeEnBytes, mensajeEnBytes.length, host, port);
				
				//enviamos
				socketUDP.send(datagramaUDP);
								
				
				//creamos datagrampacket para recibir la respuesta
				byte[] buffer = new byte[65536];
				DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);								
				
				// recibimos la respuesta
				socketUDP.receive(respuesta);
				
				//convertimos de array de bytes a String
				byte[] respuestaComoBytes = respuesta.getData();
				String mensajeRespuesta = new String(respuestaComoBytes, 
						0, respuestaComoBytes.length);

				//imprimir los detalles del input data - client ip : client
				// port - client message				
				System.out.println(respuesta.getAddress().getHostAddress() + 
						" : " + respuesta.getPort() + " - " + mensajeRespuesta);

			}
		} catch (IOException e) {
			System.err.println("IOException " + e);
		}
	}
}

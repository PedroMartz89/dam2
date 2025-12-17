package com.pberna.psp.netword.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExamples {
	public static void infoEquipo() {
		try {
			
			InetAddress equipo = InetAddress.getLocalHost();
			
			System.out.println("Mi equipo es: "+equipo);
			System.out.println("Mi dirección IP es: "+equipo.getHostAddress());
			System.out.println("Mi nombre es: "+equipo.getHostName());
			System.out.println("Mi nombre canónico es: "+equipo.getCanonicalHostName());			
			
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		}
	}
	
	public static void infoEquipoAPartirNombre(String nombre) {
		try {
			
			InetAddress equipo = InetAddress.getByName(nombre);
			
			System.out.println("Mi equipo es: "+equipo);
			System.out.println("Mi dirección IP es: "+equipo.getHostAddress());
			System.out.println("Mi nombre es: "+equipo.getHostName());
			System.out.println("Mi nombre canónico es: "+equipo.getCanonicalHostName());			
			
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		}
	}
}

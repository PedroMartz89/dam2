package com.pberna.psp.netword.inetaddress;

import com.pberna.psp.netword.inetaddress.serviciosuma.ServicioSumador;

public class Principal {

	public static void main(String[] args) {
		//InetAddressExamples.infoEquipo();
		//InetAddressExamples.infoEquipoAPartirNombre("c06x16");
		//InetAddressExamples.infoEquipoAPartirNombre("fe80::d5f8:4fc7:b6e6:59cb");
		//NetworkInterfaceExamples.obtenerTodasInterfacesEIps();
		//String url = "https://username:password@www.iescierva.net:8080/data/sss/alumno.html?nre=456&ss=fg#top";			
		//UrlSamples.infoUrl(url);
		//UrlSamples.urlRelativas();
		//UrlReader.leerUrlTexto("https://moodle.iescierva.net");
		ServicioSumador servicioSumador = new ServicioSumador();
		servicioSumador.aceptarPeticionesSuma();
	}

}

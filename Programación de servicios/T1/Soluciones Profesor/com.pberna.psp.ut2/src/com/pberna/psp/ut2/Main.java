package com.pberna.psp.ut2;

import com.pberna.psp.ut2.interrupt.HiloEsperaIndefinidamente;
import com.pberna.psp.ut2.interrupt.HiloEsperaYMuestraMensaje;
import com.pberna.psp.ut2.lanzarhilos.HelloRunnable;
import com.pberna.psp.ut2.lanzarhilos.HelloThread;
import com.pberna.psp.ut2.lanzarhilos.HiloMuestraNumeroAleatorio;
import com.pberna.psp.ut2.nameThread.HiloDiceSuNombre;
import com.pberna.psp.ut2.priorityThread.HiloDiceSuNombreConPrioridad;

public class Main {

	public static void main(String[] args) {
		//ejemploUnHiloHelloWorld();
		//ejemploLanzarVariosHilos();
		//ejemploLanzarHiloRunnable();
		//ejemploLanzarHiloConNombre();
		//ejemploLanzarHilosDiferentePrioridad();
		//ejemploLanzaHiloYSeInterrumpe();
		ejemploLanzaHiloEsperaIndefinidamente();
	}	
	
	private static void ejemploLanzaHiloEsperaIndefinidamente() {
		HiloEsperaIndefinidamente hilo = new HiloEsperaIndefinidamente();
		hilo.start();
		
		try {
			Thread.currentThread().sleep(500);
			hilo.interrupt();
			
			System.out.println("Hemos interrumpido el hilo");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	private static void ejemploLanzaHiloYSeInterrumpe() {
		HiloEsperaYMuestraMensaje hilo = new HiloEsperaYMuestraMensaje();
		hilo.start();
		
		try {
			Thread.currentThread().sleep(2000);
			hilo.interrupt();
			
			System.out.println("Hemos interrumpido el hilo");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}



	private static void ejemploLanzarHilosDiferentePrioridad() {
		HiloDiceSuNombreConPrioridad hiloPedro = new HiloDiceSuNombreConPrioridad();
		hiloPedro.setName("Pedro");
		HiloDiceSuNombreConPrioridad hiloPaco = new HiloDiceSuNombreConPrioridad();
		hiloPaco.setName("Paco");		
		
		hiloPedro.setPriority(Thread.MIN_PRIORITY);
		hiloPaco.setPriority(Thread.MAX_PRIORITY);
		
		hiloPedro.start();
		hiloPaco.start();
		
		
		
		System.out.println("Fin hilo principal");
	}



	private static void ejemploLanzarHiloConNombre() {
		HiloDiceSuNombre hiloDiceSuNombre = new HiloDiceSuNombre();
		hiloDiceSuNombre.setName("Menganito");
		hiloDiceSuNombre.start();
		
		System.out.println("Fin");
	}



	private static void ejemploLanzarHiloRunnable() {
		Thread miHilo = new Thread(new HelloRunnable());
		miHilo.start();
		
		System.out.println("Fin hilo principal");
	}



	private static void ejemploLanzarVariosHilos() {
		HiloMuestraNumeroAleatorio hilo1 = new HiloMuestraNumeroAleatorio();
		HiloMuestraNumeroAleatorio hilo2 = new HiloMuestraNumeroAleatorio();
		HiloMuestraNumeroAleatorio hilo3 = new HiloMuestraNumeroAleatorio();
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		System.out.println("Fin hilo principal");
		
	}

	public static void ejemploUnHiloHelloWorld() {
		HelloThread miHilo = new HelloThread();
		miHilo.start();
		
		System.out.println("Fin hilo principal");
	}

}

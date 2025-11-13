package com.pberna.psp.ut2.solucion.manzanas;

import com.pberna.psp.ut2.solucion.manzanas.waitnotify.CestoManzanas;
import com.pberna.psp.ut2.solucion.manzanas.waitnotify.Chiquillo;
import com.pberna.psp.ut2.solucion.manzanas.waitnotify.Jardinero;

public class MainWaitNotify {

	private static final int CAPACIDAD_CESTO = 40;
	private static final int NUMERO_CHIQUILLOS = 4;
	
	public static void main(String[] args) {
		CestoManzanas cesto = new CestoManzanas(CAPACIDAD_CESTO);
		Jardinero jardinero = new Jardinero(cesto);
		Chiquillo[] chiquillos = new Chiquillo[NUMERO_CHIQUILLOS];
		
		//creamos los chiquillos y los iniciamos
		for(int i = 0; i < chiquillos.length; i++) {
			chiquillos[i] = new Chiquillo(cesto);
			chiquillos[i].setName("Chiquillo " + (i + 1));
			chiquillos[i].start();
		}
		
		//arrancamos el jardinero
		jardinero.start();
		
		//esperamos a que termine el jardinero para avisar a los chiquillos
		try {
			jardinero.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Chiquillo chiquillo: chiquillos) {
			chiquillo.interrupt();
		}
		
		System.out.println("Fin del hilo principal");
		
	}

}

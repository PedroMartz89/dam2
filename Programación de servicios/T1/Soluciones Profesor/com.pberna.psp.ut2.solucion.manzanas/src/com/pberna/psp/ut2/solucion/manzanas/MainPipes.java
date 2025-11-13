package com.pberna.psp.ut2.solucion.manzanas;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

import com.pberna.psp.ut2.solucion.manzanas.pipes.CestoManzanasPipes;
import com.pberna.psp.ut2.solucion.manzanas.pipes.ChiquilloPipes;
import com.pberna.psp.ut2.solucion.manzanas.pipes.JardineroPipes;

public class MainPipes {
	private static final int CAPACIDAD_CESTO = 20;
	private static final int NUMERO_CHIQUILLOS = 2;

	public static void main(String args[]) {
		CestoManzanasPipes cesto = new CestoManzanasPipes(CAPACIDAD_CESTO);

		// Creamos las tuberías y las enlazamos
		PipedWriter emisor = new PipedWriter();
		PipedReader receptor = null;
		try {
			receptor = new PipedReader(emisor);
		} catch (IOException e) {
			System.exit(0);
		}
		JardineroPipes jardinero = new JardineroPipes(emisor, cesto);
		jardinero.start();

		// creamos los chiquillos
		ChiquilloPipes[] chiquillos = new ChiquilloPipes[NUMERO_CHIQUILLOS];

		// creamos los chiquillos y los iniciamos
		for (int i = 0; i < chiquillos.length; i++) {
			chiquillos[i] = new ChiquilloPipes(receptor, cesto);
			chiquillos[i].setName("Chiquillo " + (i + 1));
			chiquillos[i].start();
		}

		// esperamos a que termine el jardinero para avisar a los chiquillos
		try {			
			jardinero.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (ChiquilloPipes chiquillo : chiquillos) {
			chiquillo.interrupt();
		}

		System.out.println("Fin del hilo principal");
	}
}

package com.pberna.psp.ut2.memoriacompartida;

public class EjemploMemoriaCompartida {
	
	private static final int NUMERO_HILOS = 100;
	
	public static void main(String args[]) {
		Contador contador = new Contador();

		HiloIncrementaContador[] hilosIncrementan = new HiloIncrementaContador[NUMERO_HILOS];
		for (int i = 0; i < hilosIncrementan.length; i++) {
			hilosIncrementan[i] = new HiloIncrementaContador(contador);			
		}
		
		HiloDecrementaContador[] hilosDecrementan = new HiloDecrementaContador[NUMERO_HILOS];
		for (int i = 0; i < hilosDecrementan.length; i++) {
			hilosDecrementan[i] = new HiloDecrementaContador(contador);			
		}		
		
		for(int i = 0; i < NUMERO_HILOS; i++) {
			hilosIncrementan[i].start();
			hilosDecrementan[i].start();
		}		

		try {
			for (int i = 0; i < hilosIncrementan.length; i++) {
				hilosIncrementan[i].join();
				hilosDecrementan[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("El valor final de contador es " + contador.valor());

	}
}

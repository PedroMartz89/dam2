package com.pberna.psp.ut2.join;

public class EjemploSumadorNumeros {
	public static void main(String args[]) {
		//creo la matriz de números y los hilos
		float [][] matrizNumeros = obtenerMatriz();
		HiloSumadorNumeros [] hilos = new HiloSumadorNumeros[matrizNumeros.length]; 
		
		//lanzo hilos pasándoles la fila de números
		for(int i=0; i < hilos.length; i++) {
			hilos[i] = new HiloSumadorNumeros(matrizNumeros[i]);
			hilos[i].start();
		}
		
		//esperamos a que finalicen todos los hilos
		for(int i=0; i < hilos.length; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//hacemos el cálculo final
		float resultadoFinal = 1;
		for(int i=0; i < hilos.length; i++) {
			resultadoFinal = resultadoFinal * hilos[i].getSumaTotal();			
		}

		System.out.println("El resultado final es " + resultadoFinal);
		
	}

	private static float[][] obtenerMatriz() {
		float [][] matriz = new float[3][200];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j= 0; j < matriz[i].length; j++) {
				matriz[i][j] = (float)Math.random() * 100;
			}
		}
		
		return matriz;
	}
}

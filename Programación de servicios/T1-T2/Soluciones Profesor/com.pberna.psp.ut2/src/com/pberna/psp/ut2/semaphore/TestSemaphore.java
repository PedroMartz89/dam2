package com.pberna.psp.ut2.semaphore;

public class TestSemaphore {
	public static void main(String args[]) {
		int numeroHilosDeCpu = 4;
		int numeroCpus = 2;
		
		//creamos ordenador e hilos
		Ordenador ordenador = new Ordenador(numeroCpus);
		for(int i=0; i< numeroHilosDeCpu; i++) {
			HiloDeCpu hilo = new HiloDeCpu(ordenador);
			hilo.setName("Hilo " + (i+1));
			hilo.start();
		}
		
		
	}
}

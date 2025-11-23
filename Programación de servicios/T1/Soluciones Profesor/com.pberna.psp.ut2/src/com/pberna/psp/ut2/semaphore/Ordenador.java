package com.pberna.psp.ut2.semaphore;

import java.util.concurrent.Semaphore;

public class Ordenador {
	private int numeroCpus;
	private Semaphore semaforo;
	
	public Ordenador(int numeroCpus) {
		this.numeroCpus = numeroCpus;
		semaforo = new Semaphore(numeroCpus);
	}
	
	public void ejecutarInstruccion(String instruccion) {		
		
		try {
			semaforo.acquire();
			
			System.out.println("Soy " + Thread.currentThread().getName() +
					"Voy a ejecutar la instruccion " + 
					instruccion + " quedan " + semaforo.availablePermits() + 
					" cpus libres");
			Thread.sleep((int) ((Math.random() * 500) + 500));			
			
			System.out.println("Soy " + Thread.currentThread().getName() +
					" he terminado la instrucción y quedan " + 
					semaforo.availablePermits() + " cpus libres"); 
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
}

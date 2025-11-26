package com.pberna.psp.ut2.soluciones.restaurante;

import java.util.concurrent.Semaphore;

public class Restaurante {
	
	private static final int NUMERO_MESAS = 10;
	
	private Semaphore semaforo;
	
	public Restaurante() {
		semaforo = new Semaphore(NUMERO_MESAS);
	}
	
	public boolean pedirMesa() {
		return semaforo.tryAcquire();
	}
	
	public void dejarMesa() {
		semaforo.release();		
	}
}

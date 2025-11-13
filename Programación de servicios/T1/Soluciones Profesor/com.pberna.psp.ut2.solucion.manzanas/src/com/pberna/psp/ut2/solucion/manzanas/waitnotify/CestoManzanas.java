package com.pberna.psp.ut2.solucion.manzanas.waitnotify;

public class CestoManzanas {

	private int capacidad;
	private int numeroManzanasActual;
	
	public CestoManzanas(int capacidad) {
		this.capacidad = capacidad;
		this.numeroManzanasActual = 0;
	}
	
	public synchronized int poner(int numeroManzanas) {
		
		int numeroManzanasSePuedenPoner = capacidad - numeroManzanasActual;
		while(numeroManzanasSePuedenPoner == 0) {
			try {
				System.out.println("Soy el hilo " + Thread.currentThread().getName() 
						+ " y no hay manzanas para coger");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int numeroManzanasPuestas = 
				Math.min(numeroManzanas, numeroManzanasSePuedenPoner);
		numeroManzanasActual += numeroManzanasPuestas;
		
		notifyAll();
		return numeroManzanasPuestas;				
	}

	public synchronized int coger(int numeroManzanasQuieroCoger) throws InterruptedException {		
		while(numeroManzanasActual == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw e;
			}
		}
		
		int numeroManzanasCogidasRealmente = 
				Math.min(numeroManzanasQuieroCoger, numeroManzanasActual);
		numeroManzanasActual -= numeroManzanasCogidasRealmente;
		
		notifyAll();		
		return numeroManzanasCogidasRealmente;
	}

}

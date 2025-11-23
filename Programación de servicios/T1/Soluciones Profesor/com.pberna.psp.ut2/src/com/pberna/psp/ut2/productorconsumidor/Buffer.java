package com.pberna.psp.ut2.productorconsumidor;

public class Buffer {
	private char contenido;
	private boolean disponible = false;

	public Buffer() {
	
	}

	public synchronized char consumir() {		
		while(!disponible){
			try{
				wait();
			}
			catch(InterruptedException ex){
				System.err.println("El hilo consumidor se ha interrumpido");
			}
		}
		
		disponible=false;		
		notify();
		return contenido;		
	}

	public synchronized void producir(char c) {
		while(disponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("El hilo productor se ha interrumpido");
			}
		}
		
		contenido = c;
		disponible = true;
		notify();
	}
}

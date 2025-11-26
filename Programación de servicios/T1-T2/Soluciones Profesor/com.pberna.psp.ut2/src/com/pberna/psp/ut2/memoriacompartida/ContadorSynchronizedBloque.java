package com.pberna.psp.ut2.memoriacompartida;

public class ContadorSynchronizedBloque {
private int contador;
	
	public ContadorSynchronizedBloque() {
		contador = 0;
	}
	
	public void incrementa() {
		
		synchronized(this) {
			int valor = contador;
			valor = valor + 1;
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contador = valor;
		}
	}
	
	public synchronized void decrementa() {
		synchronized(this) {
			int valor = contador;		
			valor = valor - 1;
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contador = valor;
		}
	}
	
	public synchronized int valor() {
		synchronized(this) {
			return contador;
		}
	}
}

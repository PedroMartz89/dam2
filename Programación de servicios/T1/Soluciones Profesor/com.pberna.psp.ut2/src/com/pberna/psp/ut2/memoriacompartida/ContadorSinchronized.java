package com.pberna.psp.ut2.memoriacompartida;

public class ContadorSinchronized {
	private int contador;
	
	public ContadorSinchronized() {
		contador = 0;
	}
	
	public synchronized void incrementa() {
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
	
	public synchronized void decrementa() {
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
	
	public synchronized int valor() {
		return contador;
	}
}

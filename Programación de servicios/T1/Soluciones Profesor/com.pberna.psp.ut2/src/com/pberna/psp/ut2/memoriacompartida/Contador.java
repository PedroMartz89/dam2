package com.pberna.psp.ut2.memoriacompartida;

public class Contador {
	private int contador;
	
	public Contador() {
		contador = 0;
	}
	
	public void incrementa() {
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
	
	public void decrementa() {
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
	
	public int valor() {
		return contador;
	}
}

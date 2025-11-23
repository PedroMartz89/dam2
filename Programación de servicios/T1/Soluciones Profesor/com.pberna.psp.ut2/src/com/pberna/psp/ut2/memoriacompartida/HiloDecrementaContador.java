package com.pberna.psp.ut2.memoriacompartida;

public class HiloDecrementaContador extends Thread {
private Contador contador;
	
	public HiloDecrementaContador(Contador contador) {
		this.contador = contador;
	}
	
	@Override
	public void run() {
		this.contador.decrementa();
		System.out.println("Hemos decrementado para un valor de " + 
				this.contador.valor());
	}
}

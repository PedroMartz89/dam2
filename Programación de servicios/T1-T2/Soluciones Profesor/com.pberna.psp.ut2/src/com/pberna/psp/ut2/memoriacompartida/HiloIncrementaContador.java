package com.pberna.psp.ut2.memoriacompartida;

public class HiloIncrementaContador extends Thread {
	
	private Contador contador;
	
	public HiloIncrementaContador(Contador contador) {
		this.contador = contador;
	}
	
	@Override
	public void run() {
		this.contador.incrementa();
		System.out.println("Hemos incrementado para un valor de " + 
				this.contador.valor());
	}
}

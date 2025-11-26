package com.pberna.psp.ut2.lock;

import java.util.Date;

public class HiloManipulaContador2 extends Thread {

	private Contador contador;
	
	public HiloManipulaContador2(Contador contador) {
		this.contador = contador;
	}
	
	@Override
	public void run() {
		System.out.println("Soy " + getName() + 
				" y empiezo a ejecutar. Hora: " + new Date());
		
		contador.incrementarContador2();
		contador.incrementarContador2();
		contador.decrementarContador2();		
		int valorContador2 = contador.valorContador2();
		
		System.out.println("Soy " + getName() + 
				" y el valor del contador2 es " + 
				valorContador2 + ". Hora" + new Date());
		
	}
}

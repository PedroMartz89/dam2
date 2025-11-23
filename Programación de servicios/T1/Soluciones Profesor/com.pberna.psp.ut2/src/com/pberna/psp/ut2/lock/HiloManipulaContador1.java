package com.pberna.psp.ut2.lock;

import java.util.Date;

public class HiloManipulaContador1 extends Thread {

	private Contador contador;
	
	public HiloManipulaContador1(Contador contador) {
		this.contador = contador;
	}
	
	@Override
	public void run() {
		System.out.println("Soy " + getName() + 
				" y empiezo a ejecutar. Hora: " + new Date());
		
		contador.incrementarContador1();
		contador.incrementarContador1();
		contador.decrementarContador1();		
		int valorContador1 = contador.valorContador1();
		
		System.out.println("Soy " + getName() + 
				" y el valor del contador1 es " + 
				valorContador1 + ". Hora" + new Date());
		
	}
}

package com.pberna.psp.ut2.solucion.manzanas.waitnotify;

public class Chiquillo extends Thread {

	private CestoManzanas cestoManzanas;
	
	public Chiquillo(CestoManzanas cestoManzanas) {
		this.cestoManzanas = cestoManzanas;
	}
	
	@Override
	public void run () {
		int totalManzanasCogidas = 0;
		
		while(true) {
			int numeroManzanasQuieroCoger = (int)(Math.random() * 5) + 1;			
			int numeroManzanasCogidas;
			try {
				numeroManzanasCogidas = cestoManzanas.coger(numeroManzanasQuieroCoger);
			} catch (InterruptedException e) {
				break;
			}
			totalManzanasCogidas += numeroManzanasCogidas;	
			
			System.out.println("Soy el chiquillo " + getName() + 
					" y quería coger " + numeroManzanasQuieroCoger + 
					" manzanas y he cogido " + numeroManzanasCogidas);
			
			if(Thread.interrupted()) {
				break;
			}
			
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}*/
		}
		
		//Termina el hilo y mostramos cuantas manzanas
		System.out.println("Soy el chiquillo " + getName() + 
				" y he cogido " + totalManzanasCogidas);
	}
	
}

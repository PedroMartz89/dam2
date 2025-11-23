package com.pberna.psp.ut2.interrupt;

public class HiloEsperaYMuestraMensaje extends Thread {

	@Override
	public void run() {
		try {
			int tiempoEspera = 1;
			sleep(tiempoEspera * 1000);
			System.out.println("He esperado " + tiempoEspera + " segundos");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

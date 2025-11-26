package com.pberna.psp.ut2.interrupt;

public class HiloEsperaIndefinidamente extends Thread {
	@Override
	public void run() {
		
		int i = 0;		
		while(true) {
			i++;
			if (i == Integer.MAX_VALUE) {
				if (Thread.interrupted()) {
					break;
				}
				System.out.println("Soy el hilo que espera indefinidamente");
				i = 0;
			}
		}
		System.out.println("Soy el hilo que espera indefinidamente y me he detenido");
		
	}
}

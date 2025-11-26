package com.pberna.psp.ut2.lanzarhilos;

public class HiloMuestraNumeroAleatorio extends Thread {
	
	@Override
	public void run() {
		int numero = (int) (Math.random() * 100);
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El número es " + numero);
	}
}

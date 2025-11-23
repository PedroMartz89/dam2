package com.pberna.psp.ut2.priorityThread;

public class HiloDiceSuNombreConPrioridad extends Thread {
	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hola, soy el hilo con nombre " + getName());	
	}
}

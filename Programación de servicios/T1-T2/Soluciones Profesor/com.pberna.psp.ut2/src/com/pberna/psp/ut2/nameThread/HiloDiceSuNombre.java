package com.pberna.psp.ut2.nameThread;

public class HiloDiceSuNombre extends Thread {

	@Override
	public void run() {
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hola, soy el hilo con nombre " + getName());	
	}
}

package com.pberna.psp.ut2.productorconsumidor;

public class TestProductorConsumidor {
	public static void main(String args[]) {
		Buffer buffer = new Buffer();
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor(buffer);
		
		//lanzar a ejecutar productor y consumidor
		productor.start();
		consumidor.start();
		
		//esperamos a que finalicen
		try {
			productor.join();
			consumidor.join();
		} catch (InterruptedException e) {
			System.err.println("El hilo principal se ha interrumpido");
		}
		
		System.out.println("El hilo principal ha terminado");
	}
}

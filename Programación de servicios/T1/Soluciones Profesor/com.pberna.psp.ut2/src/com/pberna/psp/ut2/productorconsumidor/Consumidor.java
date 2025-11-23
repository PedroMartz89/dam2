package com.pberna.psp.ut2.productorconsumidor;

public class Consumidor extends Thread {
	private Buffer buffer;

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		char valor;
		for (int i = 0; i < 10; i++) {
			valor = buffer.consumir();
			System.out.println(i + " Consumidor: " + valor);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				System.out.println("El hilo consumidor se ha interrumpido");
			}
		}
	}
}

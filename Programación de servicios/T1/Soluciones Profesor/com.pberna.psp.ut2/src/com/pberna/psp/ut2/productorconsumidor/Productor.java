package com.pberna.psp.ut2.productorconsumidor;

public class Productor extends Thread {
	private Buffer buffer;
	private final String letras = "abcdefghijklmnopqrstuvxyz";

	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			char c = letras.charAt((int) (Math.random() * letras.length()));
			buffer.producir(c);
			System.out.println(i + " Productor: " + c);
			try {
					sleep(100);
				} 
			catch (InterruptedException e) {
				System.err.println("Se ha interrumpido el hilo productor");
			}
		}
	}
}

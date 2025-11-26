package com.pberna.psp.ut2.productorconsumidorpipes;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

public class ProductorPipe extends Thread {

	private PipedWriter emisor = null;
	private PrintWriter flujoEmisor = null;

	public ProductorPipe(PipedWriter emisor)
	{
		this.emisor = emisor;
		flujoEmisor = new PrintWriter(emisor);
	}

	@Override
	public void run() {
		while (true) {
			escribirMensaje();
			// esperamos un tiempo aleatorio antes del
			// siguiente mensaje
			try {
				int msegs = (int) (Math.random() * 1000);
				sleep(msegs);
			} catch (InterruptedException e) {
				System.err.println("ProductorPipe interrumpido");
			}
		}
	}
	
	public synchronized void escribirMensaje()
	{
		int numeroMensaje; 
		String textoMensaje;
		
		// Creamos un número para el mensaje
		numeroMensaje = (int)(Math.random() * 100);
		textoMensaje = "mensaje #" + numeroMensaje;
		
		// enviamos el mensaje por la tubería
		flujoEmisor.println(textoMensaje);		
		
		// imprimimos por pantalla el mensaje
		System.out.println("Productor " + getName() +
		" almacena: " + textoMensaje);
	}
	
	@Override
	protected void finalize() throws IOException
	{
		if (flujoEmisor != null) { 
			flujoEmisor.close(); 
			flujoEmisor = null; 
		}
		
		if (emisor != null) { 
			emisor.close(); 
			emisor = null; 
		}
	}

}

package com.pberna.psp.ut2.productorconsumidorpipes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class ConsumidorPipe extends Thread {
	private PipedReader receptor = null;
	private BufferedReader flujoReceptor = null;

	public ConsumidorPipe(PipedReader receptor) {
		this.receptor = receptor;
		flujoReceptor = new BufferedReader(receptor);
	}

	@Override
	public void run() {
		while (true) {
			obtenerMensaje();
		}
	}

	public synchronized void obtenerMensaje() {
		String mensaje = null;
		try {
			// obtener mensaje de la tubería
			mensaje = flujoReceptor.readLine();			

			System.out.println("Consumidor " + getName() + 
					" obtuvo: " + mensaje);
		} catch (IOException ex) {
			System.err.println("Error del consumidor al leer de la tubería " 
					+ ex.getMessage());
		}
	}
	
	@Override
	protected void finalize() throws IOException
	{
		if (flujoReceptor != null) { 
			flujoReceptor.close(); 
			flujoReceptor = null; 
		}
		
		if (receptor != null) { 
			receptor.close(); 
			receptor = null; 
		}
	}

}

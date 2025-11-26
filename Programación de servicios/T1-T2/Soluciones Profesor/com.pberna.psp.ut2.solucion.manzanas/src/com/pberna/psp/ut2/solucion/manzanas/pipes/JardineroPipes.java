package com.pberna.psp.ut2.solucion.manzanas.pipes;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Date;

public class JardineroPipes extends Thread {
	private static final long TIEMPO_FUNCIONANDO = 20 * 1000; //20 segundos, o 20.000 milisegundos
	
	private PipedWriter emisor = null;
	private PrintWriter flujoEmisor = null;
	CestoManzanasPipes cestoManzanas;
	
	public JardineroPipes(PipedWriter emisor, CestoManzanasPipes cestoManzanas)
	{
		this.emisor = emisor;
		flujoEmisor = new PrintWriter(emisor);
		this.cestoManzanas = cestoManzanas;
		
	}
	
	@Override
	public void run () {
		Date fechaInicio = new Date();
		long milisegundos = 0;
		int numeroTotalManzanasPuestas = 0;
		
		do {
			
			int numeroManzanas = (int)(Math.random() * 10) + 1;			
			int numeroManzanasPuestas = cestoManzanas.poner(numeroManzanas);
			numeroTotalManzanasPuestas += numeroManzanasPuestas;
			
			if(numeroManzanasPuestas > 0) {				
				//escribimos el número de manzanas en el cesto
				escribirNumeroManzanas(numeroManzanasPuestas);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
						
			Date fechaActual = new Date();
			milisegundos = fechaActual.getTime() - 
					fechaInicio.getTime();
			
		} while(milisegundos <= TIEMPO_FUNCIONANDO);
		
		System.out.println("El jardinero ha finalizado y ha depositado " + 
				numeroTotalManzanasPuestas + " manzanas");		
	}
	
	public synchronized void escribirNumeroManzanas(int numeroManzanas)
	{		
		// enviamos el mensaje por la tubería	
		flujoEmisor.write(numeroManzanas);
		
		System.out.println("Soy el jardinero y he puesto " + 
				numeroManzanas + " manzanas");
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

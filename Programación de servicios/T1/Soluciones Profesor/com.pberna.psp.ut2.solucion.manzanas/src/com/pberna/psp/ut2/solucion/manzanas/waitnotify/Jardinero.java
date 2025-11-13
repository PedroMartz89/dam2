package com.pberna.psp.ut2.solucion.manzanas.waitnotify;

import java.util.Date;

public class Jardinero extends Thread {
	
	private CestoManzanas cestoManzanas;
	private static final long TIEMPO_FUNCIONANDO = 20 * 1000;
		
	public Jardinero (CestoManzanas cestoManzanas) {
		this.cestoManzanas = cestoManzanas;
	}
	
	@Override
	public void run () {
		Date fechaInicio = new Date();
		long milisegundos = 0;
		int numeroTotalManzanasPuestas = 0;
		
		do {
			
			int numeroManzanas = (int)(Math.random() * 10) + 1; 
			int numeroManzanasPuestas = 
					cestoManzanas.poner(numeroManzanas);
			numeroTotalManzanasPuestas += numeroManzanasPuestas;
			
			System.out.println("Soy el jardinero y he puesto " + 
					numeroManzanasPuestas + " manzanas");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			
			Date fechaActual = new Date();
			milisegundos = fechaActual.getTime() - 
					fechaInicio.getTime();
			
		} while(milisegundos <= TIEMPO_FUNCIONANDO);
		
		//Mostrat total manzanas
		System.out.println("El jardinero ha finalizado y ha depositado " + 
				numeroTotalManzanasPuestas + " manzanas");
	}

}

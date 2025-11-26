package com.pberna.psp.ut2.solucion.manzanas.pipes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

public class ChiquilloPipes extends Thread {
	
	private PipedReader receptor = null;
	private BufferedReader flujoReceptor = null;
	private CestoManzanasPipes cestoManzanas = null;
	
	public ChiquilloPipes(PipedReader receptor, CestoManzanasPipes cestoManzanas) {
		this.receptor = receptor;
		flujoReceptor = new BufferedReader(receptor);
		this.cestoManzanas = cestoManzanas;
	}
	
	@Override
	public void run () {
		int totalManzanasCogidas = 0;
		int totalManzanasDeshechadas = 0;
		
		while(true) {
			int numeroManzanasQuieroCoger = (int)(Math.random() * 5) + 1;			
			int numeroManzanasProducidas;			
			
			try {
				numeroManzanasProducidas = obtenerNumeroManzanasProducidas();
			} catch (IOException e) {				
				break;
			}			
			
			if(numeroManzanasQuieroCoger >= numeroManzanasProducidas) {
				totalManzanasCogidas += numeroManzanasProducidas;	
				
				System.out.println("Soy el chiquillo " + getName() + 
						" y quería coger " + numeroManzanasQuieroCoger + 
						" manzanas y he cogido " + numeroManzanasProducidas);
				cestoManzanas.quitar(numeroManzanasProducidas);				
			} else {
				totalManzanasCogidas += numeroManzanasQuieroCoger;	
				int numeroManzanasDeshechadas = numeroManzanasProducidas - numeroManzanasQuieroCoger;
				totalManzanasDeshechadas += numeroManzanasDeshechadas;
				
				System.out.println("Soy el chiquillo " + getName() + 
						" y quería coger " + numeroManzanasQuieroCoger + 
						" manzanas y he cogido " + numeroManzanasQuieroCoger + 
						" deshechando " + numeroManzanasDeshechadas);
				
				cestoManzanas.quitar(numeroManzanasProducidas);
			}
			
			if(Thread.interrupted()) {
				break;
			}
		}
		
		//Termina el hilo y mostramos cuantas manzanas
		System.out.println("Soy el chiquillo " + getName() + 
				" y he cogido " + totalManzanasCogidas + 
				" deshechando " + totalManzanasDeshechadas);
	}
	
	public synchronized int obtenerNumeroManzanasProducidas() throws IOException {
		
		try {			
			int numeroManzanasProducidas = flujoReceptor.read();			
			return numeroManzanasProducidas;			
		} catch (IOException ex) {
			throw ex;
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

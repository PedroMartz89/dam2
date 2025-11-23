package com.pberna.psp.ut2.semaphore;

public class HiloDeCpu extends Thread {

	private static final String [] INTRUCCIONES = 
		{"MOV", "POP", "INCR", "DECR", "SUM"};
	private static final int NUM_INSTRUCCIONES = 8;
	
	private Ordenador ordenador;
	
	public HiloDeCpu(Ordenador ordenador) {
		this.ordenador = ordenador;
	}
	
	@Override
	public void run() {
		for(int i=0 ; i < NUM_INSTRUCCIONES; i++) {
			//cojo un instrucción aleatoria
			int indice = 
					(int) (Math.random() * INTRUCCIONES.length);
			String instruccion =  INTRUCCIONES[indice];
			
			//ejecutamos
			ordenador.ejecutarInstruccion(instruccion);
		}
	}
}

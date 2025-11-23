package com.pberna.psp.ut2.cyclicbarrier;

public class BarrierAction implements Runnable {

	private String mensaje;
	
	public BarrierAction(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public void run() {
		System.out.println(mensaje);		
	}	
}

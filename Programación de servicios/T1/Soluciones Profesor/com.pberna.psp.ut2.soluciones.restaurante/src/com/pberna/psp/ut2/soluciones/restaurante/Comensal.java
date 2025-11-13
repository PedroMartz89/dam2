package com.pberna.psp.ut2.soluciones.restaurante;

import java.util.concurrent.CountDownLatch;

public class Comensal extends Thread {

	private Restaurante restaurante;
	private Caja caja;
	private CountDownLatch cuentaAtrasSalaMedioLlena;
	
	public Comensal(Restaurante restaurante, Caja caja,
			CountDownLatch cuentaAtrasSalaMedioLlena) {
		this.restaurante = restaurante;
		this.caja = caja;
		this.cuentaAtrasSalaMedioLlena = cuentaAtrasSalaMedioLlena;
	}
	
	@Override
	public void run() {
		
		//comensal pide mesa
		boolean hayMesaDisponible = restaurante.pedirMesa();
		
		while(!hayMesaDisponible) {
			int tiempoEspera = ((int)(400 * Math.random())) + 100;
			try {
				//System.out.println("Soy un comensal y espero porque no hay mesa libre");
				 sleep(tiempoEspera);
			} catch (InterruptedException e) {
				System.out.println("Un comensal se ha interrumpido");
				break;
			}
			
			hayMesaDisponible = restaurante.pedirMesa();
		}
	
		//simulamos el tiempo de comer
		cuentaAtrasSalaMedioLlena.countDown();
		int tiempoComiendo = ((int)(3000 * Math.random())) + 1000;		
		try {
			 System.out.println("Soy un comensal y estoy comiendo");
			 sleep(tiempoComiendo);
		} catch (InterruptedException e) {
			System.out.println("Un comensal se ha interrumpido mientras estaba comiendo");		
		}
		
		//pagar la cuenta
		float importeCuenta = (float) ((81 * Math.random())) + 20f;
		caja.pagar(importeCuenta, tiempoComiendo);
		
		//liberar la mesa
		System.out.println("Soy un comensal he pagado y dejo la mesa");
		restaurante.dejarMesa();
		
	}
}

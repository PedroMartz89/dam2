package com.pberna.psp.ut2.soluciones.restaurante;

import java.util.concurrent.CountDownLatch;

public class Main {

	private static final int NUMERO_COMENSALES = 100;
	
	public static void main(String[] args) {
		Caja caja = new Caja();
		Restaurante restaurante = new Restaurante();
		Comensal[] comensales  = new Comensal[NUMERO_COMENSALES];
		CountDownLatch cuentaAtrasSalaMedioLlena = new CountDownLatch(NUMERO_COMENSALES / 2);
		ResponsableSala responsableSala = new ResponsableSala(cuentaAtrasSalaMedioLlena);
		
		//creamos los comensales y comienza la simulación
		for(int i = 0; i < comensales.length ; i++) {
			comensales[i] = new Comensal(restaurante, caja, cuentaAtrasSalaMedioLlena);
			comensales[i].start();
		}
		
		//ponemos a funcionar el responsable de la sala
		responsableSala.start();
		
		for(int i = 0; i < comensales.length; i++) {
			try {
				comensales[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//mostramos el rendimiento
		System.out.println("El rendimiento del restaurante es " +
		 caja.rentabilidad());		
		
	}

}

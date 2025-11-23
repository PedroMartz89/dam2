package com.pberna.psp.ut2.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
	public static void main(String[] args) {
		// Creando el CountDownLatch
		CountDownLatch countDown = new CountDownLatch(2);
		System.out.println("Iniciando threads...");
		
		// crear 50 threads.
		for (int i = 0; i < 50; i++) {
			Worker worker = new Worker(countDown, "Worker #" + i);
			new Thread(worker).start();
		}
		// Iniciamos todas las tareas simultánemente cuando la
		// cuenta llega a 0
		try {
			System.out.println("Hilo principal espera 5 segundos");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		countDown.countDown();
		countDown.countDown();
		countDown.countDown();
		
		System.out.println("Hilo principal ha hecho operaciones counddown");
	}
}

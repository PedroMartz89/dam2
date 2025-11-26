package com.pberna.psp.ut2.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
	private CountDownLatch startLatch;
	private String name;

	public Worker(CountDownLatch startLatch, String name) {
		super();
		this.startLatch = startLatch;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			// Espera hasta que se envía la señal
			System.out.println("Thread " + name + " awaiting");
			this.startLatch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Running " + name + ".");
	}
}
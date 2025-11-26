package com.pberna.psp.ut2.lanzarhilos;

public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello from a thread with runnable");		
	}

}

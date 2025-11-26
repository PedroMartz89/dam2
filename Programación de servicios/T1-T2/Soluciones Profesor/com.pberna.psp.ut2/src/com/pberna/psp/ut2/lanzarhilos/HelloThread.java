package com.pberna.psp.ut2.lanzarhilos;

public class HelloThread extends Thread {

	@Override
	public void run() {
		try {
			sleep(10000);
			System.out.println("Hello from a thread!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

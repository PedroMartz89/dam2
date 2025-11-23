package com.pberna.psp.ut2.lock;

public class ContadorMultipleSynchronized implements Contador {
	private int contador1;
	private int contador2;

	public ContadorMultipleSynchronized() {
		contador1 = 0;
		contador2 = 0;
	}

	public synchronized void incrementarContador1() {
		try {
			Thread.sleep(1000);
			contador1++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public synchronized void decrementarContador1() {
		try {
			Thread.sleep(1000);
			contador1--;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public synchronized int valorContador1() {
		try {
			Thread.sleep(1000);
			return contador1;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return contador1;
		}
		
	}

	public synchronized void incrementarContador2() {
		try {
			Thread.sleep(1000);
			contador2++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public synchronized void decrementarContador2() {
		try {
			Thread.sleep(1000);
			contador2--;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public synchronized int valorContador2() {
		try {
			Thread.sleep(1000);
			return contador2;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return contador2;
		}
		
	}
}

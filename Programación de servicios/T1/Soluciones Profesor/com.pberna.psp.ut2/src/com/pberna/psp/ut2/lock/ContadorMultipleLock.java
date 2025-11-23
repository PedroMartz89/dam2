package com.pberna.psp.ut2.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ContadorMultipleLock implements Contador {
	private int contador1;
	private int contador2;
	private Lock lockContador1;
	private Lock lockContador2;
	
	public ContadorMultipleLock() {
		contador1 = 0;
		contador2 = 0;
		lockContador1 = new ReentrantLock();
		lockContador2 = new ReentrantLock();
	}
	
	public void incrementarContador1() {
		try {
			lockContador1.lock();
			
			Thread.sleep(1000);
			
			contador1++;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			lockContador1.unlock();
		}		
	}
	
	public void decrementarContador1() {
		try {
			lockContador1.lock();
			
			Thread.sleep(1000);
			
			contador1--;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lockContador1.unlock();
		}		
	}
	
	public int valorContador1() {
		try {
			lockContador1.lock();	
			
			Thread.sleep(1000);
			
			return contador1;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			lockContador1.unlock();
		}
	}
	
	public void incrementarContador2() {
		try {
			lockContador2.lock();	
			
			Thread.sleep(1000);
			
			contador2++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			lockContador2.unlock();
		}		
	}
	
	public void decrementarContador2() {
		try {
			lockContador2.lock();	
			
			Thread.sleep(1000);
			
			contador2--;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lockContador2.unlock();
		}		
	}
	
	public int valorContador2() {
		try {
			lockContador2.lock();
			
			Thread.sleep(1000);
			
			return contador2;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			lockContador2.unlock();
		}
	}
}

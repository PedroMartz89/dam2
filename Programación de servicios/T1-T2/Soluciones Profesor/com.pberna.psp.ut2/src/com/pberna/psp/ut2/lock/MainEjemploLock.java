package com.pberna.psp.ut2.lock;

public class MainEjemploLock {

	public static void main(String[] args) {
		//Contador contador = new ContadorMultipleLock();		
		Contador contador = new ContadorMultipleSynchronized();
		HiloManipulaContador1 hiloManipula1 = 
				new HiloManipulaContador1(contador);
		hiloManipula1.setName("Manipula1");
		
		HiloManipulaContador2 hiloManipula2 = 
				new HiloManipulaContador2(contador);
		hiloManipula2.setName("Manipula2");
		
		//arrancamos los hilos
		hiloManipula1.start();
		hiloManipula2.start();
		
		//esperamos a que finalicen
		try {
			hiloManipula1.join();
			hiloManipula2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin del programa");
		
	}

}

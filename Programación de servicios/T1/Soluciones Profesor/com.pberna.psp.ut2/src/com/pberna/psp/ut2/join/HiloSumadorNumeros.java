package com.pberna.psp.ut2.join;

public class HiloSumadorNumeros extends Thread {
	
	private float []fila;
	private float sumaTotal;
	
	public HiloSumadorNumeros(float []fila) {
		this.fila = fila;
		this.sumaTotal = 0;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < fila.length; i++) {
			sumaTotal += fila[i];
		}
		System.out.println("El resultado de la suma de la fila es " + sumaTotal);
	}
	
	public float getSumaTotal() {
		return sumaTotal;
	}
}

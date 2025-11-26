package com.pberna.psp.ut2.solucion.manzanas.pipes;

public class CestoManzanasPipes {
	private int capacidad;
	private int numeroManzanasActual;
	
	public CestoManzanasPipes(int capacidad) {
		this.capacidad = capacidad;
		this.numeroManzanasActual = 0;
	}
	
	public synchronized int poner(int numeroManzanas) {
		int numeroManzanasSePuedenPoner = capacidad - numeroManzanasActual;
		int numeroManzanasPuestas = 
				Math.min(numeroManzanas, numeroManzanasSePuedenPoner);
		numeroManzanasActual += numeroManzanasPuestas;
		return numeroManzanasPuestas;
	}
	
	public synchronized void quitar(int numeroManzanas) {
		numeroManzanasActual -= numeroManzanas;
	}
}

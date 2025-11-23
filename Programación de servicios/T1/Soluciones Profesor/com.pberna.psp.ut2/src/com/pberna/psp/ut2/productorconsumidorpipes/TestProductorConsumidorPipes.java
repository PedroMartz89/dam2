package com.pberna.psp.ut2.productorconsumidorpipes;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;


public class TestProductorConsumidorPipes {
	public static void main(String[] args) {
		try {
			// Creamos las tuberías y las enlazamos
			PipedWriter emisor = new PipedWriter();
			PipedReader receptor = new PipedReader(emisor);
			
			//creamos el productor y el consumidor
			ProductorPipe productor = new ProductorPipe(emisor);
			ConsumidorPipe consumidor = new ConsumidorPipe(receptor);
			
			//Arrancamos los hilos
			productor.start();
			consumidor.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

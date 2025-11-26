package com.pberna.psp.ut2.productorconsumidorpipes;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.LinkedList;
import java.util.List;

public class TestProductorConsumidorPipeMultiple {
	
	private static final int NUM_PRODUCTORES = 2;
	private static final int NUM_CONSUMIDORES = 1;
		
	public static void main(String[] args) {
		try {
			// Creamos las tuberías y las enlazamos
			PipedWriter emisor = new PipedWriter();
			PipedReader receptor = new PipedReader(emisor);
			
			//creamos productores y consumidores
			List<ProductorPipe> productores = new LinkedList<ProductorPipe>();
			for(int i = 0; i < NUM_PRODUCTORES; i++) {
				ProductorPipe productor = new ProductorPipe(emisor);
				productor.setName("Productor " + (i + 1));
				productores.add(productor);
			}
			
			List<ConsumidorPipe> consumidores = new LinkedList<ConsumidorPipe>();		
			for(int i = 0; i < NUM_CONSUMIDORES; i++) {
				ConsumidorPipe consumidor = new ConsumidorPipe(receptor);
				consumidor.setName("Consumidor " + (i + 1));
				consumidores.add(consumidor);
			}
			
			//Arrancamos productores y consumidores
			for(ProductorPipe productor: productores) {
				productor.start();
			}
			
			for(ConsumidorPipe consumidor: consumidores) {
				consumidor.start();
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

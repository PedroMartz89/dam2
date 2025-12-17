package com.pberna.psp.ut3.echo_udp;

public class Main {
	public static void main(String args[]) {
		ServidorEchoUdp servidor = new ServidorEchoUdp();
		servidor.escucharPeticionesEcho();
	}
}

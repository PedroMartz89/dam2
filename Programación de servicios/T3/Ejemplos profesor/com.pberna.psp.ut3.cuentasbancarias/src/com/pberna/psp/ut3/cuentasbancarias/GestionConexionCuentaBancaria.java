package com.pberna.psp.ut3.cuentasbancarias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class GestionConexionCuentaBancaria extends Thread {

	private Socket socket;
	private List<CuentaBancaria> listaCuentas;

	public GestionConexionCuentaBancaria(Socket socket, 
			List<CuentaBancaria> listaCuentas) throws IOException {
		this.socket = socket;
		this.listaCuentas = listaCuentas;
	}

	@Override
	public void run() {

		// escribe todo lo que le llega por consola

		try (InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader reader = new BufferedReader(inputStreamReader);
				PrintWriter writer = new PrintWriter(outputStream);) {
			
			while (true) {
				String mensaje = reader.readLine();
				System.out.println("Cliente ha enviado :" + mensaje);
				
				if (mensaje.startsWith("Balance")) {
					procesarMensajeBalance(mensaje, writer);
				} else if (mensaje.startsWith("Deposit")) {
					procesarMensajeDeposit(mensaje, writer);
				} else if (mensaje.startsWith("Withdraw")) {
					procesarMensajeWithdraw(mensaje, writer);
				} else if (mensaje.startsWith("QUIT")) {
					procesarMensajeQuit();
					break;
				} else {
					writer.println("Mensaje desconocido: " + mensaje);
					writer.flush();
				}
			}

		} catch (IOException e) {
			System.err.println("Ha habido un error en la comunicación con el cliente");
			e.printStackTrace();
		}

	}

	private void procesarMensajeBalance(String mensaje, PrintWriter writer) {
		String[] partesMesaje = mensaje.split(" ");
		String numeroCuenta = partesMesaje[1];		
		
		CuentaBancaria cuenta = buscarCuenta(numeroCuenta);
		
		if(cuenta != null) {
			writer.println(cuenta.getNumeroCuenta() + " " + cuenta.getSaldo());
			writer.flush();
		} else {
			CuentaBancaria nuevaCuenta = new CuentaBancaria(numeroCuenta);
			
			synchronized(listaCuentas) {			
				listaCuentas.add(nuevaCuenta);
			}
			
			writer.println(nuevaCuenta.getNumeroCuenta() + " " + nuevaCuenta.getSaldo());
			writer.flush();
		}
		
	}
	
	private CuentaBancaria buscarCuenta(String numeroCuenta) {
		for(CuentaBancaria cuenta:listaCuentas) {
			if(cuenta.getNumeroCuenta().equals(numeroCuenta)) {
				return cuenta;
			}
		}
		
		return null;
	}

	private void procesarMensajeDeposit(String mensaje, PrintWriter writer) {
		String[] partesMesaje = mensaje.split(" ");
		String numeroCuenta = partesMesaje[1];		
		double importe = Double.parseDouble(partesMesaje[2]);	
		
		CuentaBancaria cuenta = buscarCuenta(numeroCuenta);
		
		if(cuenta != null) {
			cuenta.deposit(importe);			
			writer.println(cuenta.getNumeroCuenta() + " " + cuenta.getSaldo());
			writer.flush();
		} else {
			CuentaBancaria nuevaCuenta = new CuentaBancaria(numeroCuenta);
			
			synchronized(listaCuentas) {			
				listaCuentas.add(nuevaCuenta);
			}
			nuevaCuenta.deposit(importe);
			
			writer.println(nuevaCuenta.getNumeroCuenta() + " " + nuevaCuenta.getSaldo());
			writer.flush();
		}
	}

	private void procesarMensajeWithdraw(String mensaje, PrintWriter writer) {
		String[] partesMesaje = mensaje.split(" ");
		String numeroCuenta = partesMesaje[1];		
		double importe = Double.parseDouble(partesMesaje[2]);	
		
		CuentaBancaria cuenta = buscarCuenta(numeroCuenta);
		
		if(cuenta != null) {
			cuenta.withdraw(importe);			
			writer.println(cuenta.getNumeroCuenta() + " " + cuenta.getSaldo());
			writer.flush();
		} else {
			CuentaBancaria nuevaCuenta = new CuentaBancaria(numeroCuenta);
			
			synchronized(listaCuentas) {			
				listaCuentas.add(nuevaCuenta);
			}
			nuevaCuenta.withdraw(importe);
			
			writer.println(nuevaCuenta.getNumeroCuenta() + " " + nuevaCuenta.getSaldo());
			writer.flush();
		}
	}

	private void procesarMensajeQuit() {
		try {
			socket.close();
		} catch (IOException e) {
			System.err.println("Error al cerrar socket cliente");
			e.printStackTrace();
		}
	}

}

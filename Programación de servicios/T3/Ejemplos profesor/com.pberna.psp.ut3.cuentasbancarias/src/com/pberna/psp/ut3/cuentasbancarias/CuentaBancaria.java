package com.pberna.psp.ut3.cuentasbancarias;

public class CuentaBancaria {
	private String numeroCuenta;
	private double saldo;
	
	public CuentaBancaria(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
		saldo = 0;
	}
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "CuentaBancaria [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}

	public synchronized void deposit(double importe) {
		saldo += importe;		
	}

	public synchronized void withdraw(double importe) {
		saldo -= importe;		
	}	
	
}

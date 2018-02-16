package com.storedprocedures.modelo;

import java.util.Map;

public class OutputData {
	
	public String numeroCuenta;
	public String numeroCliente;
	public Double saldo;
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	public String getNumeroCliente() {
		return numeroCliente;
	}
	
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public OutputData(String numeroCuenta, String numeroCliente, Double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.numeroCliente = numeroCliente;
		this.saldo = saldo;
	}
	
	public OutputData(){}
	
	public OutputData (Map<String, Object> out) {
		super();
		this.numeroCliente = out.get("idClienteOut").toString();
        this.numeroCuenta = out.get("idCuentaOut").toString();
        this.saldo = Double.parseDouble(out.get("saldoOut").toString());
	}
	

}

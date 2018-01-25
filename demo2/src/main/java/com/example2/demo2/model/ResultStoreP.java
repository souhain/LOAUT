package com.example2.demo2.model;

import java.math.BigDecimal;

public class ResultStoreP {

	private int idCliente;
	private BigDecimal saldo;
	private int idCuenta;
	
	
	
	public ResultStoreP(int idCliente, BigDecimal saldo, int idCuenta) {
		super();
		this.idCliente = idCliente;
		this.saldo = saldo;
		this.idCuenta = idCuenta;
	}


	public ResultStoreP() {}
	
	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public BigDecimal getSaldo() {
		return saldo;
	}



	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}



	public int getIdCuenta() {
		return idCuenta;
	}



	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}



	@Override
	public String toString() {
		return "ResultStoreP [idCliente=" + idCliente + ", idCuenta=" + idCuenta + ", saldo=" + saldo + "]";
	}
	
	
		
	
}

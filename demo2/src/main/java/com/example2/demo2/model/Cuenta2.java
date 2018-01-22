package com.example2.demo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
public class Cuenta2 {
	//llave primaria
	@Id
	@Column(name = "idCuenta2", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int idCuenta2;
	
	//atributos
	
	@Column(name = "saldo")
	private double saldo;
	
	//llave foranea
	@ManyToOne
    @JoinColumn(name = "Cliente2_idCliente2")
	private Cliente2 cliente2;
	
	
    public Cliente2 getCliente2() {
        return cliente2;
    }


	public void setCliente2(Cliente2 cliente2) {
		this.cliente2 = cliente2;
	}
	

	public int getIdCuenta2() {
		return idCuenta2;
	}



	public void setIdCuenta2(int idCuenta2) {
		this.idCuenta2 = idCuenta2;
	}



	public double getSaldo() {
		return saldo;
	}



	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	
	
}

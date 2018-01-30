package com.example2.demo2.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cuenta2")
public class Cuenta2 {
	//llave primaria
	@Id
	@Column(name = "id_cuenta2", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id_cuenta2;
	
	@Column(name="ejecutive_email")
	private String ejecutive_email;
	
	//atributos
	
	public String getEjecutive_email() {
		return ejecutive_email;
	}


	public void setEjecutive_email(String ejecutive_email) {
		this.ejecutive_email = ejecutive_email;
	}


	@Column(name = "saldo")
	private BigDecimal saldo;
	
	//llave foranea
	@ManyToOne
    @JoinColumn(name = "cliente2_id_cliente2")
	private Cliente2 cliente2;
	
	
    public Cliente2 getCliente2() {
        return cliente2;
    }


	public void setCliente2(Cliente2 cliente2) {
		this.cliente2 = cliente2;
	}
	

	public int getIdCuenta2() {
		return id_cuenta2;
	}



	public void setIdCuenta2(int idCuenta2) {
		this.id_cuenta2 = idCuenta2;
	}



	public BigDecimal getSaldo() {
		return saldo;
	}



	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Cuenta2 [id_cuenta2=" + id_cuenta2 + ", saldo=" + saldo ;
	}


	public Cuenta2() {}
}

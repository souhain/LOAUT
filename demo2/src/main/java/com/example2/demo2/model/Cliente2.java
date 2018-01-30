package com.example2.demo2.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.Table;

import javax.persistence.*;
@Entity
@Table(name="cliente2")
public class Cliente2 {
	
	//llave primaria
	@Id
    @Column(name = "id_cliente2", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id_cliente2;
	
	//atributos 
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	
	@OneToMany(mappedBy = "cliente2", cascade = CascadeType.ALL)
	private Set<Cuenta2> cuentas;
			
	
	public Set<Cuenta2> getCuenta2() {
        return cuentas;
    }

    public void setCuentas(Set<Cuenta2> cuentas) {
        this.cuentas= cuentas;
    }
	
	public int getId_Cliente2() {
		return id_cliente2;
	}

	public void setId_Cliente2(int idCliente2) {
		this.id_cliente2 = idCliente2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	


	@Override
	public String toString() {
		return "Cliente2  [id_cliente2=" + id_cliente2 + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", phone=" + phone + ", cuentas=" + cuentas + "]";
	}

	public Cliente2() {}
}	

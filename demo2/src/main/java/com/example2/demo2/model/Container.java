package com.example2.demo2.model;

import java.math.BigDecimal;

public class Container {
	private String name,address,email,phone,ejecutive_email;
	public String getEjecutive_email() {
		return ejecutive_email;
	}
	public void setEjecutive_email(String ejecutive_email) {
		this.ejecutive_email = ejecutive_email;
	}
	private BigDecimal saldo;
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
	@Override
	public String toString() {
		return "Container [name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + ", saldo="
				+ saldo + "]";
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}

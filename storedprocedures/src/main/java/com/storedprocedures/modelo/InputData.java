package com.storedprocedures.modelo;

public class InputData {
	private String name;
	private String phone;
	private String address;
	private String email;
	private String excecutive;
	private double amount;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getExcecutive() {
		return excecutive;
	}
	public void setExcecutive(String excecutive) {
		this.excecutive = excecutive;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "InputData [name=" + name + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", excecutive=" + excecutive + ", amount=" + amount + "]";
	}
	
	public InputData(String name, String phone, String address, String email, String excecutive, double amount) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.excecutive = excecutive;
		this.amount = amount;
	}
	
	public InputData() {}
}

package com.storedprocedures.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cliente2", catalog = "info_banco2", schema = "")
public class Cliente2 implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_cliente2")
	private Integer idCliente2;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente2IdCliente2")
	private List<Cuenta2> cuenta2List;

	public Cliente2() {
	}

	public Cliente2(Integer idCliente2) {
		this.idCliente2 = idCliente2;
	}

	public Integer getIdCliente2() {
		return idCliente2;
	}

	public void setIdCliente2(Integer idCliente2) {
		this.idCliente2 = idCliente2;
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

	@XmlTransient
	public List<Cuenta2> getCuenta2List() {
		return cuenta2List;
	}

	public void setCuenta2List(List<Cuenta2> cuenta2List) {
		this.cuenta2List = cuenta2List;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCliente2 != null ? idCliente2.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Cliente2)) {
			return false;
		}
		Cliente2 other = (Cliente2) object;
		if ((this.idCliente2 == null && other.idCliente2 != null)
				|| (this.idCliente2 != null && !this.idCliente2.equals(other.idCliente2))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "recursosdom.Cliente2[ idCliente2=" + idCliente2 + " ]";
	}

}

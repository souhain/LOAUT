package com.storedprocedures.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta2", catalog = "info_banco2", schema = "")
public class Cuenta2 implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_cuenta2")
	private Integer idCuenta2;
	@Column(name = "saldo")
	private Long saldo;
	@Column(name = "ejecutive_email")
	private String ejecutiveEmail;
	@JoinColumn(name = "cliente2_id_cliente2", referencedColumnName = "id_cliente2")
	@ManyToOne(optional = false)
	private Cliente2 cliente2IdCliente2;

	public Cuenta2() {
	}

	public Cuenta2(Integer idCuenta2) {
		this.idCuenta2 = idCuenta2;
	}

	public Integer getIdCuenta2() {
		return idCuenta2;
	}

	public void setIdCuenta2(Integer idCuenta2) {
		this.idCuenta2 = idCuenta2;
	}

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

	public String getEjecutiveEmail() {
		return ejecutiveEmail;
	}

	public void setEjecutiveEmail(String ejecutiveEmail) {
		this.ejecutiveEmail = ejecutiveEmail;
	}

	public Cliente2 getCliente2IdCliente2() {
		return cliente2IdCliente2;
	}

	public void setCliente2IdCliente2(Cliente2 cliente2IdCliente2) {
		this.cliente2IdCliente2 = cliente2IdCliente2;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCuenta2 != null ? idCuenta2.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Cuenta2)) {
			return false;
		}
		Cuenta2 other = (Cuenta2) object;
		if ((this.idCuenta2 == null && other.idCuenta2 != null)
				|| (this.idCuenta2 != null && !this.idCuenta2.equals(other.idCuenta2))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "recursosdom.Cuenta2[ idCuenta2=" + idCuenta2 + " ]";
	}

}

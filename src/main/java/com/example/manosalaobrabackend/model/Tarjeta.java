package com.example.manosalaobrabackend.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="tarjeta")
public class Tarjeta{
	@Id 
	@Column(name="numero",length=16, nullable=false, unique=true)
	private Long numero;
	@Column(name="tarjetahabiente",length=50, nullable=false, unique=false)
	private String tarjetahabiente;
	@Column(name="fecha_expiracion",length=50, nullable=false, unique=false)
	@Temporal(TemporalType.DATE)
	private Date fechaExpiracion;
	@Column(name="cvv",length=3, nullable=false, unique=false)
	private int cvv;
	@Column(name="banco",length=16, nullable=false, unique=false)
	private String banco;
	@Column(name="compania",length=16, nullable=false, unique=false)
	private String compania;
	///-----------------------!!!!! IMPORTANTE AÑADIR EL TIPO DE TARJETA DE CREDITO.
	
	//-------------- De claramos la relación ManyToOne para Tarjeta referenciando a cliente.
	//@ManyToOne
	//@JoinColumn(name = "id_cliente", referencedColumnName = "correo" ,nullable = false)
	//@JsonBackReference
	//private Cliente cliente;

	//----------------------  Constructores -> Equals
	public Tarjeta() {
	}

	public Tarjeta(Long numero, String tarjetahabiente, Date fechaExpiracion, int cvv, String banco, String compania) {
		this.numero = numero;
		this.tarjetahabiente = tarjetahabiente;
		this.fechaExpiracion = fechaExpiracion;
		this.cvv = cvv;
		this.banco = banco;
		this.compania = compania;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getTarjetahabiente() {
		return tarjetahabiente;
	}

	public void setTarjetahabiente(String tarjetahabiente) {
		this.tarjetahabiente = tarjetahabiente;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Tarjeta [numero=" + numero + ", tarjetahabiente=" + tarjetahabiente + ", fechaExpiracion="
				+ fechaExpiracion + ", cvv=" + cvv + ", banco=" + banco + ", compania=" + compania + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(banco, compania, cvv, fechaExpiracion, numero, tarjetahabiente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(banco, other.banco) && Objects.equals(compania, other.compania) && cvv == other.cvv
				&& Objects.equals(fechaExpiracion, other.fechaExpiracion) && Objects.equals(numero, other.numero)
				&& Objects.equals(tarjetahabiente, other.tarjetahabiente);
	}

	
}
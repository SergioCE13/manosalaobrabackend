package com.example.manosalaobrabackend.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tarjeta")
public class Tarjeta{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="numero",length=16, nullable=false, unique=true)
	private int numero;
	@Column(name="tarjetahabiente",length=50, nullable=false, unique=true)
	private String tarjetahabiente;
	@Column(name="fecha_expiracion",length=5, nullable=false, unique=true)
	private int fecha_expiracion;
	@Column(name="cvv",length=3, nullable=false, unique=true)
	private int cvv;
	@Column(name="banco",length=16, nullable=false, unique=true)
	private String banco;
	@Column(name="compania",length=16, nullable=false, unique=true)
	private String compania;
	
	public Tarjeta() {}
	
	public Tarjeta(Long id, int numero, String tarjetahabiente, int fecha_expiracion, int cvv, String banco, String compania) {
		this.id=id;
		this.numero=numero;
		this.tarjetahabiente=tarjetahabiente;
		this.fecha_expiracion=fecha_expiracion;
		this.cvv=cvv;
		this.banco=banco;
		this.compania=compania;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTarjetahabiente() {
		return tarjetahabiente;
	}

	public void setTarjetahabiente(String tarjetahabiente) {
		this.tarjetahabiente = tarjetahabiente;
	}

	public int getFecha_expiracion() {
		return fecha_expiracion;
	}

	public void setFecha_expiracion(int fecha_expiracion) {
		this.fecha_expiracion = fecha_expiracion;
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
		return "Tarjeta [id=" + id + ", numero=" + numero + ", tarjetahabiente=" + tarjetahabiente
				+ ", fecha_expiracion=" + fecha_expiracion + ", cvv=" + cvv + ", banco=" + banco + ", compania="
				+ compania + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(banco, compania, cvv, fecha_expiracion, id, numero, tarjetahabiente);
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
				&& fecha_expiracion == other.fecha_expiracion && Objects.equals(id, other.id) && numero == other.numero
				&& Objects.equals(tarjetahabiente, other.tarjetahabiente);
	}
	
	
	
}
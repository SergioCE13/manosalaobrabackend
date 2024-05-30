package com.example.manosalaobrabackend.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	//-------------- De claramos la relación ManyToOne para Tarjeta referenciando a cliente.
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "correo" ,nullable = false)
	@JsonBackReference
	private Cliente cliente;

	//----------------------  Constructores -> Equals
	public Tarjeta() {
	}

	public Tarjeta(Long numero, String tarjetahabiente, Date fechaExpiracion, int cvv, String banco, String compania,
			Cliente cliente) {
		this.numero = numero;
		this.tarjetahabiente = tarjetahabiente;
		this.fechaExpiracion = fechaExpiracion;
		this.cvv = cvv;
		this.banco = banco;
		this.compania = compania;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tarjeta [numero=").append(numero).append(", tarjetahabiente=").append(tarjetahabiente)
				.append(", fechaExpiracion=").append(fechaExpiracion).append(", cvv=").append(cvv).append(", banco=")
				.append(banco).append(", compania=").append(compania).append(", cliente=").append(cliente).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(banco, cliente, compania, cvv, fechaExpiracion, numero, tarjetahabiente);
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
		return Objects.equals(banco, other.banco) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(compania, other.compania) && cvv == other.cvv
				&& Objects.equals(fechaExpiracion, other.fechaExpiracion) && Objects.equals(numero, other.numero)
				&& Objects.equals(tarjetahabiente, other.tarjetahabiente);
	}
}
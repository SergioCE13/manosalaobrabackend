package com.example.manosalaobrabackend.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
 @Table(name = "direccion")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "calle", length= 45, nullable = false, unique = false)
	private String calle;
	@Column (name = "num_int", nullable = true, unique = false)
	private int numInterior;
	@Column(name = "num_ext", nullable = false, unique = false)
	private int numExterior;
	@Column(name = "cp", nullable = false, unique = false)
	private int codigoPostal;
	@Column(name = "colonia", nullable = false, unique = false)
	private String colonia;
	@Column(name = "municipio", nullable = false, unique = false)
	private String municipio;
	@Column(name = "ciudad", nullable = false, unique = false)
	private String ciudad;
	
	// ----------------------- Se declaran las relaciones de la entidad Direccion
	@ManyToOne
	@JoinColumn(name = "cliente_correo", referencedColumnName = "correo")
	@JsonBackReference
	private Cliente cliente;
	
	public Direccion() {
	}

	public Direccion(Long id, String calle, int numInterior, int numExterior, int codigoPostal, String colonia,
			String municipio, String ciudad, Cliente cliente) {
		this.id = id;
		this.calle = calle;
		this.numInterior = numInterior;
		this.numExterior = numExterior;
		this.codigoPostal = codigoPostal;
		this.colonia = colonia;
		this.municipio = municipio;
		this.ciudad = ciudad;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumInterior() {
		return numInterior;
	}

	public void setNumInterior(int numInterior) {
		this.numInterior = numInterior;
	}

	public int getNumExterior() {
		return numExterior;
	}

	public void setNumExterior(int numExterior) {
		this.numExterior = numExterior;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numInterior=" + numInterior + ", numExterior="
				+ numExterior + ", codigoPostal=" + codigoPostal + ", colonia=" + colonia + ", municipio=" + municipio
				+ ", ciudad=" + ciudad + ", cliente=" + cliente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, ciudad, cliente, codigoPostal, colonia, id, municipio, numExterior, numInterior);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(cliente, other.cliente) && codigoPostal == other.codigoPostal
				&& Objects.equals(colonia, other.colonia) && Objects.equals(id, other.id)
				&& Objects.equals(municipio, other.municipio) && numExterior == other.numExterior
				&& numInterior == other.numInterior;
	}

	
	
}

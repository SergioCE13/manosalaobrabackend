package com.example.manosalaobrabackend.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(name = "municipio", nullable = false, unique = false)
	private String municipio;
	@Column(name = "estado", nullable = false, unique = false)
	private String estado;
	@Column(name = "cp", nullable = false, unique = false)
	private int codigoPostal;
	
	@ManyToOne //(mappedBy = "cliente", cascade = cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private Cliente cliente;
	
	
	// Constructor vacío
	public Direccion() {
	}

	//Constructor completo
	public Direccion(Long id, String calle, int numInterior, int numExterior, String municipio, String estado,
			int codigoPostal) {
		this.id = id;
		this.calle = calle;
		this.numInterior = numInterior;
		this.numExterior = numExterior;
		this.municipio = municipio;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
	}

// Getters y Setters
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


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

// Método toString para imprimir la información de las direcciones
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Direccion [id=").append(id).append(", calle=").append(calle).append(", numInterior=")
				.append(numInterior).append(", numExterior=").append(numExterior).append(", municipio=")
				.append(municipio).append(", estado=").append(estado).append(", codigoPostal=").append(codigoPostal)
				.append("]");
		return builder.toString();
	}


	//Método hashCode para calcular el valor hash de los objetos
	@Override
	public int hashCode() {
		return Objects.hash(calle, codigoPostal, estado, id, municipio, numExterior, numInterior);
	}

	//Método equals para verificar que no existen objetos iguales.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(calle, other.calle) && codigoPostal == other.codigoPostal
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(municipio, other.municipio) && numExterior == other.numExterior
				&& numInterior == other.numInterior;
	}
	
	
	
}

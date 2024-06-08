package com.example.manosalaobrabackend.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Favorito")
public class Favorito {

	@EmbeddedId
	private FavoritoId id;
	
	@ManyToOne
	@JsonBackReference
	private Cliente cliente;
	
	@ManyToOne
	@JsonBackReference
	private Producto producto;
	

	public Favorito() {
	}

	public Favorito(FavoritoId id) {
		this.id = id;
	}

	public FavoritoId getId() {
		return id;
	}

	public void setId(FavoritoId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Favorito [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorito other = (Favorito) obj;
		return Objects.equals(id, other.id);
	}
	
}

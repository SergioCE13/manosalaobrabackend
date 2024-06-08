package com.example.manosalaobrabackend.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FavoritoId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name= "Cliente_favorito", length = 60, nullable = false)
	private String clienteFav;
	
	@Column(name = "Producto_favorito", length = 45, nullable = false)
    private String productoFav;

    public FavoritoId() {
    }

	public FavoritoId(String clienteFav, String productoFav) {
		this.clienteFav = clienteFav;
		this.productoFav = productoFav;
	}

	public String getClienteFav() {
		return clienteFav;
	}

	public void setClienteFav(String clienteFav) {
		this.clienteFav = clienteFav;
	}

	public String getProductoFav() {
		return productoFav;
	}

	public void setProductoFav(String productoFav) {
		this.productoFav = productoFav;
	}

	@Override
	public String toString() {
		return "FavoritoId [clienteFav=" + clienteFav + ", productoFav=" + productoFav + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteFav, productoFav);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoritoId other = (FavoritoId) obj;
		return Objects.equals(clienteFav, other.clienteFav) && Objects.equals(productoFav, other.productoFav);
	}
    
	

}

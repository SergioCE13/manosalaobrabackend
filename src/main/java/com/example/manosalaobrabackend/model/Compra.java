package com.example.manosalaobrabackend.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // Generamos una entidad para la tabla de compra
@Table (name = "compra")
public class Compra {

	 @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	@Column (name = "fechaHora", length = 30, nullable = false, unique= false)
	private LocalDateTime fechaHora; // Utilizamos la api LocalDateTime para almacenar fecha y hora.
	@Column (name = "total", length = 10, nullable = false, unique= false)
	private double total;
	@Column (name = "sinIva", length = 10, nullable = false, unique= false)
	private double sinIva;
	@Column (name = "cantidadProducto", length = 200, nullable = false, unique= false)
	private int cantidadProducto;
	
	
	// Creamos un constructor vacío
	public Compra() {
		
	}


	// Y un constructor con los campos llenos
	public Compra(Long id, LocalDateTime fechaHora, double total, double sinIva, int cantidadProducto) {
		this.id = id;
		this.fechaHora = fechaHora;
		this.total = total;
		this.sinIva = sinIva;
		this.cantidadProducto = cantidadProducto;
	}


	// Mandamos a llamar getters y setters
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDateTime getFechaHora() {
		return fechaHora;
	}



	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public double getSinIva() {
		return sinIva;
	}



	public void setSinIva(double sinIva) {
		this.sinIva = sinIva;
	}



	public int getCantidadProducto() {
		return cantidadProducto;
	}



	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	//Mandamos a llamar el método toString para imprimir la información de la compra.
	@Override
	public String toString() {
		return "Compra [id=" + id + ", fechaHora=" + fechaHora + ", total=" + total + ", sinIva=" + sinIva
				+ ", cantidadProducto=" + cantidadProducto + "]";
	}


	//Utilizamos un método hashcode para determinar el valor hash de las compras.
	@Override
	public int hashCode() {
		return Objects.hash(cantidadProducto, fechaHora, id, sinIva, total);
	}


	//Usamos el método equals para verificar que no se repitan los objetos.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return cantidadProducto == other.cantidadProducto && Objects.equals(fechaHora, other.fechaHora)
				&& Objects.equals(id, other.id)
				&& Double.doubleToLongBits(sinIva) == Double.doubleToLongBits(other.sinIva)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}
	
	
	
	
	
	
	
	
	
	
	
}

package com.example.manosalaobrabackend.model;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Indicamos que esta clase es una OMR 
@Table(name = "producto") //Indicamos la creación de la tabla con el nombre "producto."
public class Producto {
	//Declaramos los atributos de la entidad comenzando por el Id:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre", length = 45, nullable = false, unique = true)
	private String nombre;
	@Column(name = "precio", scale = 2, nullable = false, unique = false)
	private double precio;
	@Column(name = "medida_alto", scale = 2, nullable = false, unique = false )
	private double medidaAlto;
	@Column(name = "medida_acho", scale = 2, nullable = false, unique = false)
	private double medidaAncho;
	@Column(name = "medida_largo", scale = 2, nullable = false, unique = false)
	private double medidaLargo;
	@Column(name = "descripcion", length = 500, nullable = false, unique = false)
	private String descripcion;
	@Column(name = "tecnica", length = 45, nullable = false, unique = false)
	private String tecnica; 
	@Column(name = "materiales", length = 100, nullable = false, unique = false)
	private String materiales;
	@Column(name = "stock", nullable = false, unique = false)
	private int stock;
	@Column(name = "info_adicional", length = 200, nullable = false, unique = false)
	private String infoAdicional;
	
	
	//Declaramos el constructor que necesita JPA para construir cualquier objeto.
	public Producto() {
	}

// Declaramos un constructor con todos los atributos de la entidad
	public Producto(Long id, String nombre, double precio, double medidaAlto, double medidaAncho, double medidaLargo,
			String descripcion, String tecnica, String materiales, int stock, String infoAdicional) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.medidaAlto = medidaAlto;
		this.medidaAncho = medidaAncho;
		this.medidaLargo = medidaLargo;
		this.descripcion = descripcion;
		this.tecnica = tecnica;
		this.materiales = materiales;
		this.stock = stock;
		this.infoAdicional = infoAdicional;
	}

	
	
	//Getters y Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getMedidaAlto() {
		return medidaAlto;
	}


	public void setMedidaAlto(double medidaAlto) {
		this.medidaAlto = medidaAlto;
	}


	public double getMedidaAncho() {
		return medidaAncho;
	}


	public void setMedidaAncho(double medidaAncho) {
		this.medidaAncho = medidaAncho;
	}


	public double getMedidaLargo() {
		return medidaLargo;
	}


	public void setMedidaLargo(double medidaLargo) {
		this.medidaLargo = medidaLargo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTecnica() {
		return tecnica;
	}


	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}


	public String getMateriales() {
		return materiales;
	}


	public void setMateriales(String materiales) {
		this.materiales = materiales;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getInfoAdicional() {
		return infoAdicional;
	}


	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

//Declaramos un metodo toString para imprimir la información del Producto
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", medidaAlto=" + medidaAlto
				+ ", medidaAncho=" + medidaAncho + ", medidaLargo=" + medidaLargo + ", descripcion=" + descripcion
				+ ", tecnica=" + tecnica + ", materiales=" + materiales + ", stock=" + stock + ", infoAdicional="
				+ infoAdicional + "]";
	}

//Declaramos el método hashCode para verificar el valor hash de los objetos.
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, infoAdicional, materiales, medidaAlto, medidaAncho, medidaLargo, nombre,
				precio, stock, tecnica);
	}

//Declaramos el método equals para verificar que no existan objetos iguales.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(infoAdicional, other.infoAdicional) && Objects.equals(materiales, other.materiales)
				&& Double.doubleToLongBits(medidaAlto) == Double.doubleToLongBits(other.medidaAlto)
				&& Double.doubleToLongBits(medidaAncho) == Double.doubleToLongBits(other.medidaAncho)
				&& Double.doubleToLongBits(medidaLargo) == Double.doubleToLongBits(other.medidaLargo)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock
				&& Objects.equals(tecnica, other.tecnica);
	}
	
	
	
	
	
	
}

package com.example.manosalaobrabackend.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity //Indicamos que esta clase es una OMR 
@Table(name = "producto") //Indicamos la creación de la tabla con el nombre "producto."
public class Producto {
	//Declaramos los atributos de la entidad comenzando por el Id:
	@Id
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
	@Column(name = "categoria", length = 45, nullable = false, unique = false)
	private String categoria; 
	@Column(name = "descripcion", length = 500, nullable = false, unique = false)
	private String descripcion;
	@Column(name = "tecnica", length = 45, nullable = false, unique = false)
	private String tecnica; 
	//@Column(name = "materiales", length = 100, nullable = false, unique = false)
	//private String materiales;
	@Column(name = "stock", nullable = false, unique = false)
	private int stock;
	@Column(name = "info_adicional", length = 200, nullable = false, unique = false)
	private String infoAdicional;
	
	//Como un archivo de tipo BLOB que permite subir una imagen del producto
	@Lob //Large OBject, indica que un archivo de tipo BLOB se enviara a la base de datos. (img, pdf,xsl, etc)
	@Column(name = "imagenes", nullable = false, unique = false)
	private List<String> imagenes;
	

	
	// ------------------- Declaramos la relación ManyToOne  con respecto a la Entidad vendedor Muchos productos pueden tener un vendedor,y un vendedor puede tener muchos productos :
		//@ManyToOne
		//@JoinColumn (name = "vendedor")
		//public Vendedor vendedor;
	//Con compra
		//@ManyToOne
		//@JoinColumn (name = "compra")
		//public Compra compra;
		
	//Con Carrito
		//@ManyToOne //Muchos productos pueden estar en un carrito
		//@JoinColumn (name = "carrito")
		//private Carrito carrito;
		
	//Con Wishlist
		//@ManyToOne 
		//@JoinColumn (name = "wishlist")
		//private
		
	//Declaramos el constructor que necesita JPA para construir cualquier objeto.
	public Producto() {
	}



	public Producto(String nombre, double precio, double medidaAlto, double medidaAncho, double medidaLargo,
			String categoria, String descripcion, String tecnica, int stock, String infoAdicional,
			List<String> imagenes) {
		this.nombre = nombre;
		this.precio = precio;
		this.medidaAlto = medidaAlto;
		this.medidaAncho = medidaAncho;
		this.medidaLargo = medidaLargo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.tecnica = tecnica;
		this.stock = stock;
		this.infoAdicional = infoAdicional;
		this.imagenes = imagenes;
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



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
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



	public List<String> getImagenes() {
		return imagenes;
	}



	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [nombre=").append(nombre).append(", precio=").append(precio).append(", medidaAlto=")
				.append(medidaAlto).append(", medidaAncho=").append(medidaAncho).append(", medidaLargo=")
				.append(medidaLargo).append(", categoria=").append(categoria).append(", descripcion=")
				.append(descripcion).append(", tecnica=").append(tecnica).append(", stock=").append(stock)
				.append(", infoAdicional=").append(infoAdicional).append(", imagenes=").append(imagenes).append("]");
		return builder.toString();
	}



	@Override
	public int hashCode() {
		return Objects.hash(categoria, descripcion, imagenes, infoAdicional, medidaAlto, medidaAncho, medidaLargo,
				nombre, precio, stock, tecnica);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(imagenes, other.imagenes) && Objects.equals(infoAdicional, other.infoAdicional)
				&& Double.doubleToLongBits(medidaAlto) == Double.doubleToLongBits(other.medidaAlto)
				&& Double.doubleToLongBits(medidaAncho) == Double.doubleToLongBits(other.medidaAncho)
				&& Double.doubleToLongBits(medidaLargo) == Double.doubleToLongBits(other.medidaLargo)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock
				&& Objects.equals(tecnica, other.tecnica);
	}


	
	
}

	

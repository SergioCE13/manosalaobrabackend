package com.example.manosalaobrabackend.model;

import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
	
	//Como un archivo de tipo BLOB que permite subir una imagen del producto
	@Lob //Large OBject, indica que un archivo de tipo BLOB se enviara a la base de datos. (img, pdf,xsl, etc)
	@Column (name ="producto", length = 200, nullable = false, unique=false)
	private byte [] productos;
	
	
	// ------------------- Declaramos la relación ManyToOne  con respecto a la Entidad vendedor Muchos productos pueden tener un vendedor,y un vendedor puede tener muchos productos :
		@ManyToOne
		@JoinColumn (name = "vendedor")
		public Vendedor vendedor;
	//Con compra
		@ManyToOne
		@JoinColumn (name = "compra")
		public Compra compra;
		
	//Con Carrito
		@ManyToOne //Muchos productos pueden estar en un carrito
		@JoinColumn (name = "carrito")
		private Carrito carrito;
		
	//Con Wishlist
		//@ManyToOne 
		//@JoinColumn (name = "wishlist")
		//private
		
	//Declaramos el constructor que necesita JPA para construir cualquier objeto.
	public Producto() {
	}
	
	//Se crea constructor.
	public Producto(String nombre, double precio, double medidaAlto, double medidaAncho, double medidaLargo,
			String descripcion, String tecnica, String materiales, int stock, String infoAdicional, byte[] productos,
			Vendedor vendedor, Compra compra, Carrito carrito) {
		super();
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
		this.productos = productos;
		this.vendedor = vendedor;
		this.compra = compra;
		this.carrito = carrito;
	}
	
	//Se crean getters y setter

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

	public byte[] getProductos() {
		return productos;
	}

	public void setProductos(byte[] productos) {
		this.productos = productos;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	//Se crea ToString
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", medidaAlto=" + medidaAlto + ", medidaAncho="
				+ medidaAncho + ", medidaLargo=" + medidaLargo + ", descripcion=" + descripcion + ", tecnica=" + tecnica
				+ ", materiales=" + materiales + ", stock=" + stock + ", infoAdicional=" + infoAdicional
				+ ", productos=" + Arrays.toString(productos) + ", vendedor=" + vendedor + ", compra=" + compra
				+ ", carrito=" + carrito + "]";
	}

	//Se crea hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(productos);
		result = prime * result + Objects.hash(carrito, compra, descripcion, infoAdicional, materiales, medidaAlto,
				medidaAncho, medidaLargo, nombre, precio, stock, tecnica, vendedor);
		return result;
	}

	//Se crea equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(carrito, other.carrito) && Objects.equals(compra, other.compra)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(infoAdicional, other.infoAdicional)
				&& Objects.equals(materiales, other.materiales)
				&& Double.doubleToLongBits(medidaAlto) == Double.doubleToLongBits(other.medidaAlto)
				&& Double.doubleToLongBits(medidaAncho) == Double.doubleToLongBits(other.medidaAncho)
				&& Double.doubleToLongBits(medidaLargo) == Double.doubleToLongBits(other.medidaLargo)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Arrays.equals(productos, other.productos) && stock == other.stock
				&& Objects.equals(tecnica, other.tecnica) && Objects.equals(vendedor, other.vendedor);
	}

	
	
	
	
}

	

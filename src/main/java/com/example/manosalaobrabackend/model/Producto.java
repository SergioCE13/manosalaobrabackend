package com.example.manosalaobrabackend.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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
	@Column(name = "foto", nullable = true, length = 1048576) // la longitud permite imagenes de hasta 1 MB 
	private byte[] foto;
	
	//------------------------------------- Definimos las relaciones de la entidad Producto
	// 1. Relación ManyToOne con vendedor.
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "vendedor", referencedColumnName = "correo") 
	private Vendedor vendedor;
	
	//2. Relación *implícita* OneToMany con comentario.
	//3. Relación *implicita* OneToMany con carrito.
	//4. Relación ManyToMany con cliente -- para generar Favoritos --.
	@ManyToMany
	@JoinTable(
			name = "favoritos",
			joinColumns = @JoinColumn(name = "nombre_producto", referencedColumnName = "nombre", columnDefinition = "VARCHAR(45) NOT NULL"),
			inverseJoinColumns = @JoinColumn(name = "coreo_cliente", referencedColumnName = "correo", columnDefinition = "VARCHAR(45) NOT NULL")
			)
	private Set<Cliente> cliente;
	
	//5. Relación ManyToMany con compra.
	@ManyToMany
	@JoinTable(
			name = "producto_comprado",
			joinColumns = @JoinColumn(name = "nombre_producto"),
			inverseJoinColumns = @JoinColumn(name = "correo_cliente")
			)
	private Set<Compra> compra;
	
	//Declaramos el constructor que necesita JPA para construir cualquier objeto.
	public Producto() {
	}

	public Producto(String nombre, double precio, double medidaAlto, double medidaAncho, double medidaLargo,
			String categoria, String descripcion, String tecnica, int stock, String infoAdicional, byte[] foto) {
		super();
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
		this.foto = foto;
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



	public byte[] getFoto() {
		return foto;
	}



	public void setFoto(byte[] foto) {
		this.foto = foto;
	}



	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", medidaAlto=" + medidaAlto + ", medidaAncho="
				+ medidaAncho + ", medidaLargo=" + medidaLargo + ", categoria=" + categoria + ", descripcion="
				+ descripcion + ", tecnica=" + tecnica + ", stock=" + stock + ", infoAdicional=" + infoAdicional
				+ ", foto=" + Arrays.toString(foto) + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + Objects.hash(categoria, descripcion, infoAdicional, medidaAlto, medidaAncho,
				medidaLargo, nombre, precio, stock, tecnica);
		return result;
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
				&& Arrays.equals(foto, other.foto) && Objects.equals(infoAdicional, other.infoAdicional)
				&& Double.doubleToLongBits(medidaAlto) == Double.doubleToLongBits(other.medidaAlto)
				&& Double.doubleToLongBits(medidaAncho) == Double.doubleToLongBits(other.medidaAncho)
				&& Double.doubleToLongBits(medidaLargo) == Double.doubleToLongBits(other.medidaLargo)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock
				&& Objects.equals(tecnica, other.tecnica);
	}
	
	
	
}

	

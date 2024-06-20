package com.example.manosalaobrabackend.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Declaramos que esta clase se maneja como una entidad
@Table(name = "vendedor") // Declaramos el nombre de la tabla de la entidad en SQL
public class Vendedor {
	
	@Id // Declaramos la llave primaria y después todos los atributos.
	@Column(name = "correo", length = 45, nullable = false, unique = true)
	private String correo;
	//@Column(name = "rfc", length = 13, nullable = false, unique = true)
	//private String rfc;
	@Column(name = "nombre", length = 45, nullable = false, unique = false)
	private String nombre;
	@Column(name = "ape_paterno", length = 45, nullable = false, unique = false)
	private String apellidoPaterno;
	@Column(name = "ape_materno", length = 45, nullable = false, unique = false)
	private String apellidoMaterno;
	@Column(name = "genero", length = 45, nullable = false, unique = false)
	private String genero;
	@Column(name = "telefono", length = 10, nullable = false, unique = false)
	private Long telefono;
	@Column(name = "fecha_nacimiento", length = 10, nullable = false, unique = false)
	private String fechaNacimiento;
	@Column(name = "contraseña", length = 45, nullable = false, unique = false)
	private String password;
	
	@Lob 
	@Column (name = "foto", nullable = true, length = 1048576)
	private byte[] foto;
	
	@OneToMany
	@JsonManagedReference
	List <Producto> productos;
	
	//Declaramos el constructor vacío que necesita JPA para crear cualquier objeto.
	public Vendedor() {
	}


	public Vendedor(String correo, String nombre, String apellidoPaterno, String apellidoMaterno, String genero,
			Long telefono, String fechaNacimiento, String password, byte[] foto) {
		this.correo = correo;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.genero = genero;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.foto = foto;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Long getTelefono() {
		return telefono;
	}


	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	@Override
	public String toString() {
		return "Vendedor [correo=" + correo + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", genero=" + genero + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + ", password=" + password + ", foto=" + Arrays.toString(foto)
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + Objects.hash(apellidoMaterno, apellidoPaterno, correo, fechaNacimiento, genero,
				nombre, password, telefono);
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
		Vendedor other = (Vendedor) obj;
		return Objects.equals(apellidoMaterno, other.apellidoMaterno)
				&& Objects.equals(apellidoPaterno, other.apellidoPaterno) && Objects.equals(correo, other.correo)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Arrays.equals(foto, other.foto)
				&& Objects.equals(genero, other.genero) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(telefono, other.telefono);
	}


	
}

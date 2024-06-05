package com.example.manosalaobrabackend.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Declaramos que esta clase será una entidad
@Table(name = "cliente") //Asignamos el nombre de la tabla para la entidad
public class Cliente {
	@Id // Asignamos un Id
	@Column(name = "correo", length = 45, nullable = false, unique = true)
	private String correo;
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
	@Column(name = "fecha_nacimiento", length = 10, nullable  = false, unique = false)
	private String fechaNacimiento;
	@Column(name = "contraseña", length = 45, nullable = false, unique = false)
	private String password;
	
	// ------------------- Declaramos las relaciones de la entidad Cliente
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Direccion> direcciones;
	
	
	//Declaramos un construtor para JPA
	public Cliente() {
	}


	public Cliente(String correo, String nombre, String apellidoPaterno, String apellidoMaterno, String genero,
			Long telefono, String fechaNacimiento, String password, List<Direccion> direcciones) {
		this.correo = correo;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.genero = genero;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.direcciones = direcciones;
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


	public List<Direccion> getDirecciones() {
		return direcciones;
	}


	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}


	@Override
	public String toString() {
		return "Cliente [correo=" + correo + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", genero=" + genero + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + ", password=" + password + ", direcciones=" + direcciones
				+ "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, correo, direcciones, fechaNacimiento, genero, nombre,
				password, telefono);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellidoMaterno, other.apellidoMaterno)
				&& Objects.equals(apellidoPaterno, other.apellidoPaterno) && Objects.equals(correo, other.correo)
				&& Objects.equals(direcciones, other.direcciones)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(genero, other.genero)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password)
				&& Objects.equals(telefono, other.telefono);
	}

	
	
}

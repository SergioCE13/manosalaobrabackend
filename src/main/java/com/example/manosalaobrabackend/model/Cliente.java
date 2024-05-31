package com.example.manosalaobrabackend.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	// ------------------- Declaramos la relación ManyToOne  con respecto a la Entidad vendedor:
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	public List<Tarjeta> tarjetas;
	
	// ------------------- Declaramos la relación OneToMany con respecto a la Entidad Tarjeta:
	//@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	//public List<Direccion> direcciones;
	
	
	//Declaramos un construtor para JPA
	public Cliente() {
	}
	
	

	public Cliente(String correo, String nombre, String apellidoPaterno, String apellidoMaterno, String genero,
			Long telefono, String fechaNacimiento, String password, List<Tarjeta> tarjetas) {
		this.correo = correo;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.genero = genero;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.tarjetas = tarjetas;
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

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [correo=").append(correo).append(", nombre=").append(nombre)
				.append(", apellidoPaterno=").append(apellidoPaterno).append(", apellidoMaterno=")
				.append(apellidoMaterno).append(", genero=").append(genero).append(", telefono=").append(telefono)
				.append(", fechaNacimiento=").append(fechaNacimiento).append(", password=").append(password)
				.append(", tarjetas=").append(tarjetas).append("]");
		return builder.toString();
	}



	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, correo, fechaNacimiento, genero, nombre, password,
				tarjetas, telefono);
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
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(genero, other.genero)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password)
				&& Objects.equals(tarjetas, other.tarjetas) && Objects.equals(telefono, other.telefono);
	}

	
}

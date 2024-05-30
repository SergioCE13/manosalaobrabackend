package com.example.manosalaobrabackend.model;

import java.util.List;
import java.util.Objects;

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
	@Column(name = "fecha_nacimiento", length = 10, nullable  = false, unique = false)
	private String fechaNacimiento;
	@Column(name = "contraseña", length = 45, nullable = false, unique = false)
	private String password;
	
	// ------------------- Declaramos la relación ManyToOne  con respecto a la Entidad vendedor:
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Tarjeta> tarjetas;
	
	// ------------------- Declaramos la relación OneToMany con respecto a la Entidad Tarjeta:
	//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	//public List<Direccion> direcciones;
	
	//Declaramos un construtor para JPA
	public Cliente() {
	}

	//Declaramos un constructor con todos los atributos.
	public Cliente(String correo, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento,
			String password) {
		this.correo = correo;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
	}

	//Getters y Setters
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

	//Creamos un método toString para imprimir la información de los clientes.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [correo=").append(correo).append(", nombre=").append(nombre)
				.append(", apellidoPaterno=").append(apellidoPaterno).append(", apellidoMaterno=")
				.append(apellidoMaterno).append(", fechaNacimiento=").append(fechaNacimiento).append(", password=")
				.append(password).append("]");
		return builder.toString();
	}

	//Declaramos un método para verificar el valor hash de los objetos.
	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, correo, fechaNacimiento, nombre, password);
	}

	//Declaramos un método equals para verificar que no haya objetos iguales.
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
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password);
	}
	
	
	
	
	
}

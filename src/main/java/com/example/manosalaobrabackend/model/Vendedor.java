package com.example.manosalaobrabackend.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Declaramos que esta clase se maneja como una entidad
@Table(name = "vendedor") // Declaramos el nombre de la tabla de la entidad en SQL
public class Vendedor {
	
	@Id // Declaramos la llave primaria y después todos los atributos.
	@Column(name = "correo", length = 45, nullable = false, unique = true)
	private String correo;
	@Column(name = "rfc", length = 13, nullable = false, unique = true)
	private String rfc;
	@Column(name = "nombre", length = 45, nullable = false, unique = false)
	private String nombre;
	@Column(name = "ape_paterno", length = 45, nullable = false, unique = false)
	private String apellidoPaterno;
	@Column(name = "ape_materno", length = 45, nullable = false, unique = false)
	private String apellidoMaterno;
	@Column(name = "fecha_nacimiento", length = 10, nullable = false, unique = false)
	private String fechaNacimiento;
	@Column(name = "contraseña", length = 45, nullable = false, unique = false)
	private String password;
	
	//Declaramos el constructor vacío que necesita JPA para crear cualquier objeto.
	public Vendedor() {
	}

	//Declaramos el constructor con todos los atributos de la entidad
	public Vendedor(String correo, String rfc, String nombre, String apellidoPaterno, String apellidoMaterno,
			String fechaNacimiento, String password) {
		this.correo = correo;
		this.rfc = rfc;
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


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
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

	//Método toString para imprimir la información de los vendedores.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vendedor [correo=").append(correo).append(", rfc=").append(rfc).append(", nombre=")
				.append(nombre).append(", apellidoPaterno=").append(apellidoPaterno).append(", apellidoMaterno=")
				.append(apellidoMaterno).append(", fechaNacimiento=").append(fechaNacimiento).append(", password=")
				.append(password).append("]");
		return builder.toString();
	}

	//Declaramos un método hashCode para verificar el valor hash de los objetos
	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, correo, fechaNacimiento, nombre, password, rfc);
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
		Vendedor other = (Vendedor) obj;
		return Objects.equals(apellidoMaterno, other.apellidoMaterno)
				&& Objects.equals(apellidoPaterno, other.apellidoPaterno) && Objects.equals(correo, other.correo)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(rfc, other.rfc);
	}
	
	
}

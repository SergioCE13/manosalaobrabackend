package com.example.manosalaobrabackend.model;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Se declara que la clase sera una entidad
	@Entity 
	@Table (name = "Respuestas") //Asi es como se llama la tabla
	
public class Respuestas {
		//Se declaran los atributos comenzando por la id.
		@Id 
		@GeneratedValue (strategy = GenerationType.IDENTITY) //Es como se generara  el valor de la clave primaria
		@Column (name = "respuestas", nullable = true, unique = false)
		public int respuestas;
		@Column (name = "cuerpo", length = 350, nullable =true, unique = false)
		public String cuerpo;
		@Column (name = "cantLike", nullable = true, unique = true)
		public int cantLike;
		@Column (name = "fechaHora", nullable = false )
		private Timestamp fechaHora;
		@Column (name = "correo", length = 45, nullable = false, unique =false )
		private String correo;
	
		//Se declara un constructor vacio para Jpa
		public Respuestas () {}
		
		//Se declara un constructor con todos los atributos 
		public Respuestas(int respuestas, String cuerpo, int cantLike, Timestamp fechaHora, String correo) {
			super();
			this.respuestas = respuestas;
			this.cuerpo = cuerpo;
			this.cantLike = cantLike;
			this.fechaHora = fechaHora;
			this.correo = correo;
		}

		//Se declaran los getters y setters
		public int getRespuestas() {
			return respuestas;
		}

		public void setRespuestas(int respuestas) {
			this.respuestas = respuestas;
		}

		public String getCuerpo() {
			return cuerpo;
		}

		public void setCuerpo(String cuerpo) {
			this.cuerpo = cuerpo;
		}

		public int getCantLike() {
			return cantLike;
		}

		public void setCantLike(int cantLike) {
			this.cantLike = cantLike;
		}

		public Timestamp getFechaHora() {
			return fechaHora;
		}

		public void setFechaHora(Timestamp fechaHora) {
			this.fechaHora = fechaHora;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}
		
		//Se declara el metodo ToString para imprimir la informacion de los clientes.
		@Override
		public String toString() {
			return "Respuestas [respuestas=" + respuestas + ", cuerpo=" + cuerpo + ", cantLike=" + cantLike
					+ ", fechaHora=" + fechaHora + ", correo=" + correo + "]";
		}

		//Se declara el metodo hashCode para verificar el valor hash de los objetos.
		@Override
		public int hashCode() {
			return Objects.hash(cantLike, correo, cuerpo, fechaHora, respuestas);
		}
		
		//Se declara el metodo equals para verificar el valor equals de los objetos.
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Respuestas other = (Respuestas) obj;
			return cantLike == other.cantLike && Objects.equals(correo, other.correo)
					&& Objects.equals(cuerpo, other.cuerpo) && Objects.equals(fechaHora, other.fechaHora)
					&& respuestas == other.respuestas;
		}
		
			
		
		
		
		
		
		
		

		
		
		
}

	
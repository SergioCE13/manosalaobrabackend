package com.example.manosalaobrabackend.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id_comentario;
    
    @Column(name = "fecha_hora", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_hora = LocalDateTime.now();
    
    @Column(length = 350, nullable = false, unique = false)
    private String cuerpo;

    @Column(length = 1, nullable = false, unique = false)
    private int estrellas;
    
    @Column(nullable = true, unique = false, columnDefinition = "INT DEFAULT 0")
    private int megusta;
    
    // --------------------------------- Definimos las relaciones de la entidad comentario.
    // 1. Relación ManyToOne con cliente
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "correo")
    @JsonBackReference
    private Cliente cliente;
    
    // 2. Relación OneToMany con respuestas.
    @OneToMany(mappedBy = "comentario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Respuestas> respuestas;
    
    // 3. Relación ManyToOne con producto.
    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "nombre")
    @JsonBackReference
    private Producto producto;
    
	public Comentario() {
	}


	public Comentario(Long id_comentario, LocalDateTime fecha_hora, String cuerpo, int estrellas, int megusta) {
		super();
		this.id_comentario = id_comentario;
		this.fecha_hora = fecha_hora;
		this.cuerpo = cuerpo;
		this.estrellas = estrellas;
		this.megusta = megusta;
	}


	public Long getId_comentario() {
		return id_comentario;
	}


	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}


	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}


	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}


	public String getCuerpo() {
		return cuerpo;
	}


	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}


	public int getEstrellas() {
		return estrellas;
	}


	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}


	public int getMegusta() {
		return megusta;
	}


	public void setMegusta(int megusta) {
		this.megusta = megusta;
	}


	@Override
	public String toString() {
		return "Comentario [id_comentario=" + id_comentario + ", fecha_hora=" + fecha_hora + ", cuerpo=" + cuerpo
				+ ", estrellas=" + estrellas + ", megusta=" + megusta + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cuerpo, estrellas, fecha_hora, id_comentario, megusta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return Objects.equals(cuerpo, other.cuerpo) && estrellas == other.estrellas
				&& Objects.equals(fecha_hora, other.fecha_hora) && Objects.equals(id_comentario, other.id_comentario)
				&& megusta == other.megusta;
	}

}

package com.example.manosalaobrabackend.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Declaramos que esta clase será una entidad
@Table(name = "carrito") // Asignamos el nombre de la tabla para la entidad
public class Carrito {
    
    @Id // Asignamos un Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "cliente_correo", length = 45, nullable = false)
    private String clienteCorreo;
    
    @Column(name = "num_productos", nullable = false)
    private int numProductos;
    
   
    
    // Constructor para JPA
    public Carrito() {
    }

    // Constructor con todos los atributos
    public Carrito(String clienteCorreo, Long productoId,  int numProductos) {
        this.clienteCorreo = clienteCorreo;
        this.numProductos = numProductos;
        
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteCorreo() {
        return clienteCorreo;
    }

    public void setClienteCorreo(String clienteCorreo) {
        this.clienteCorreo = clienteCorreo;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int cantidad) {
        this.numProductos = cantidad;
    }

  
    

    // Método toString para imprimir la información del carrito
    @Override
   	public String toString() {
   		return "Carrito [id=" + id + ", clienteCorreo=" + clienteCorreo + ", numProductos=" + numProductos + "]";
   	}
   

    @Override
	public int hashCode() {
		return Objects.hash(clienteCorreo, id, numProductos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return Objects.equals(clienteCorreo, other.clienteCorreo) && Objects.equals(id, other.id)
				&& numProductos == other.numProductos;
	}
}
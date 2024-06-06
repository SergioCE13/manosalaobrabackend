package com.example.manosalaobrabackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.manosalaobrabackend.model.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
// Más adelante se harán consultas desde aquí
	
	@Query("SELECT d FROM Direccion d JOIN d.cliente c WHERE c.correo = ?1")
	List<Direccion> findByCorreo(String correo);
}

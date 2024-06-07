package com.example.manosalaobrabackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.manosalaobrabackend.model.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
	
	@Query("SELECT d FROM Tarjeta d JOIN d.cliente c WHERE c.correo = ?1")
	List<Tarjeta> findByCorreo(String correo);

}

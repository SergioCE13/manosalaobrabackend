package com.example.manosalaobrabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.manosalaobrabackend.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
	//Más adelante se podrán realizar consultas (queries) desde aquí: JPQL (Java Persistence Query Language)

	
}

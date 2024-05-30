package com.example.manosalaobrabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.manosalaobrabackend.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	//Más adelante se podrá realizar consultas (queries) desde aquí: JPQL (Java Persistence Query Language)
	
	@Query("SELECT u FROM Signup u WHERE u.email = ?1")
	Producto findByproducto(String email);
	
	@Query("SELECT u FROM Signup u WHERE u.username = ?1")
	Producto findByusername (String username);
	
}

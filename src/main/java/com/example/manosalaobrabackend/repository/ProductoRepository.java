package com.example.manosalaobrabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.manosalaobrabackend.model.Producto;

public interface ProductoRepository extends JpaRepository <Producto, String>{
	//Más adelante se podrá realizar consultas (queries) desde aquí: JPQL (Java Persistence Query Language)
	
 }
	
	


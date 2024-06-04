package com.example.manosalaobrabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.manosalaobrabackend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	
}

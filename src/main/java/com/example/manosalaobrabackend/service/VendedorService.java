package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.manosalaobrabackend.model.Vendedor;
import com.example.manosalaobrabackend.repository.VendedorRepository;

@Repository
public class VendedorService {
	private VendedorRepository vendedorRepository;

	@Autowired
	public VendedorService(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}
	
	public List<Vendedor> getAll(){
		return vendedorRepository.findAll();
	}
	
	
}

package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.manosalaobrabackend.exceptions.UserNotFoundException;
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
	
	public Vendedor postVendedor(Vendedor newVendedor) {
		return vendedorRepository.save(newVendedor);
	}
	
	public Vendedor getById(String correo) {
		return vendedorRepository.findById(correo)
				.orElseThrow(() -> new UserNotFoundException(correo));
	}
	
	public Vendedor updateVendedor(Vendedor vendedor, String id) {
		return vendedorRepository.findById(id)
				.map(vendedorMap -> {
					vendedorMap.setNombre(vendedor.getNombre());
					vendedorMap.setApellidoPaterno(vendedor.getApellidoPaterno());
					vendedorMap.setApellidoMaterno(vendedor.getApellidoMaterno());
					vendedorMap.setGenero(vendedor.getGenero());
					vendedorMap.setTelefono(vendedor.getTelefono());
					vendedorMap.setFechaNacimiento(vendedor.getFechaNacimiento());
					vendedorMap.setPassword(vendedor.getPassword());
					return vendedorRepository.save(vendedorMap);
				})
				.orElseThrow(() -> new UserNotFoundException(id));
	}
}

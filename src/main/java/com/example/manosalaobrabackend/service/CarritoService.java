package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.exceptions.CarritoNotFoundException;
import com.example.manosalaobrabackend.model.Carrito;
import com.example.manosalaobrabackend.repository.CarritoRepository;

@Service 
public class CarritoService {
	private CarritoRepository carritoRepository;
	

	@Autowired
	public CarritoService(CarritoRepository carritoRepository) {
		this.carritoRepository = carritoRepository;
	}

	public List<Carrito> getAll(){
		return carritoRepository.findAll();
	}
	
	public Carrito getById(Long id) {
		return carritoRepository.findById(id)
				.orElseThrow(() -> new CarritoNotFoundException(id));
	}
	
	public Carrito postCarrito(Carrito carrito) {
		return carritoRepository.save(carrito);
	}
	
	public void deleteCarrito(Long id) {
		carritoRepository.deleteById(id);
	}
	
}



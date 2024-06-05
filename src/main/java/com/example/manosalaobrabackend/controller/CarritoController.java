package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Carrito;
import com.example.manosalaobrabackend.service.CarritoService;

@RestController
@RequestMapping("/api/mao/carrito")
public class CarritoController {
	private final CarritoService carritoService;

	@Autowired
	public CarritoController(CarritoService carritoService) {
		this.carritoService = carritoService;
	}
	
	@GetMapping
	public List<Carrito> getAllControler(){
		return carritoService.getAll();
	}
	
	@GetMapping("/{id}")
	public Carrito getCarrito(@PathVariable(name = "id") Long id) {
		return carritoService.getById(id);
	}
	
	@PostMapping
	public Carrito newCarrito(Carrito carrito) {
		return carritoService.postCarrito(carrito);
	}
	
	@DeleteMapping
	public void dropCarrito(Long id) {
		carritoService.deleteCarrito(id);
	}
	
	
}
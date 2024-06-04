package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
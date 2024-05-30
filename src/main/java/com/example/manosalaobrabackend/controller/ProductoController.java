package com.example.manosalaobrabackend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Producto;
import com.example.manosalaobrabackend.service.ProductoService;


@RestController  // Anotación que indica que esta clase es un controlador REST de Spring.
@RequestMapping("/api/manosalaobrabackend/producto") // Anotación que define la url base para todas las rutas manejadas por este controlador.
public class ProductoController {
//Se manda a llamar Service
	private final ProductoService productoService;
	
	//Inyeccion de Dependencias (constructor)
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	//Mapear Métodos
	@GetMapping
	public List<Producto> getAllController(){
		return productoService.getAll();
	}
	
	
		
}

	

	
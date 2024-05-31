package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Compra;
import com.example.manosalaobrabackend.service.CompraService;

@RestController // Clase que maneja solicitudes HTTP entrantes y envía respuestasHTTP en una aplicación web de SPRING.
@RequestMapping("/api/mao/compra") // Anotación que define la url base para todas las rutas manejadas poor este controlador.
public class CompraController {
	
	private final CompraService compraService;
	
	//Inyección de dependencias (constructor)
	@Autowired
	public CompraController(CompraService compraService) {
		this.compraService = compraService;
	}
	
	//Mapear Métodos
	@GetMapping
	public List<Compra> getAllController(){
		return compraService.getAll();
	}
	
	@GetMapping("/{id}")
	public Compra getCompraById(@PathVariable(name= "id")Long id) {
		return compraService.getById(id);
	}
	
	@PostMapping
	public Compra nuevaCompra(@RequestBody Compra compra) {
		return compraService.postCompra(compra);
	}
	

}

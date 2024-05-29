package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Compra;
import com.example.manosalaobrabackend.service.CompraService;

@RestController // Clase que maneja solicitudes HTTP entrantes y envía respuestasHTTP en una aplicación web de SPRING.
@RequestMapping("/api/manosalaobrabackend/compra") // Anotación que define la url base para todas las rutas manejadas poor este controlador.
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

}

package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Direccion;
import com.example.manosalaobrabackend.service.DireccionService;



@RestController // Clase que maneja solicitudes HTTP entrantes y envía respuestas HTTP en una aplicación web de SPRING.
@RequestMapping("/api/mao/direccion")//: Define la url base para todas las rutas manejadas por este controlador.
public class DireccionController {

	private final DireccionService direccionService;
	@Autowired
	public DireccionController(DireccionService direccionService) {
		this.direccionService = direccionService;
	}
	
	//Mapear Métodos
	@GetMapping
	public List<Direccion> getAllController(){
		return direccionService.getAll();
	}
	
	@PostMapping
	public Direccion nuevaDireccion(@RequestBody Direccion direccion) {
		return direccionService.postDireccion(direccion);
	}
	
	@GetMapping("/{id}")
	public Direccion DireccionById(@PathVariable (name = "id")Long id) {
		return direccionService.getById(id);
	}

	
	
	
	
	
}

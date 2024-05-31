package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Respuestas;
import com.example.manosalaobrabackend.service.RespuestasService;

@RestController
@RequestMapping("/api/mao/respuestas")
public class RespuestasController {
	//Se manda a llamar al servicio
	private final RespuestasService respuestasService;

	//Se inyectan las dependencias
	@Autowired
	public RespuestasController(RespuestasService RespuestasService) {
		this.respuestasService = RespuestasService;
	}
	
	//Mapeando los metodos
	@GetMapping
	public List<Respuestas> getAllControler(){
		return respuestasService.getAll();
	}
	
}
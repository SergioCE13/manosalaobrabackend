package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Respuestas;
import com.example.manosalaobrabackend.repository.RespuestasRepository;
import com.example.manosalaobrabackend.service.RespuestasService;

@RestController
@RequestMapping("/api/manosalaobrabackend/respuestas")
public class RespuestasController {
	private final RespuestasService respuestasService;

	@Autowired
	public RespuestasController(RespuestasService RespuestasService) {
		this.respuestasService = RespuestasService;
	}
	
	@GetMapping
	public List<Respuestas> getAllControler(){
		return respuestasService.getAll();
	}
	
}	


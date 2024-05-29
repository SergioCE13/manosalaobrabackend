package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.model.Respuestas;
import com.example.manosalaobrabackend.repository.RespuestasRepository;

@Service 
public class RespuestasService {
	private RespuestasRepository respuestasRepository;

	@Autowired
	public RespuestasService(RespuestasRepository respuestasRepository) {
		this.respuestasRepository = respuestasRepository;
	}

	public List<Respuestas> getAll(){
		return respuestasRepository.findAll();
	}
	
}

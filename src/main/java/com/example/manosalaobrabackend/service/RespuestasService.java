package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.manosalaobrabackend.exceptions.RespuestasNotFoundException;

import com.example.manosalaobrabackend.model.Respuestas;
import com.example.manosalaobrabackend.repository.RespuestasRepository;

@Service 
public class RespuestasService {
	//Se manda a llamar a RespuestasRepository
	private RespuestasRepository respuestasRepository;

	@Autowired
	public RespuestasService(RespuestasRepository respuestasRepository) {
		this.respuestasRepository = respuestasRepository;
	}

	public List<Respuestas> getAll(){
		return respuestasRepository.findAll();
	}

	public Respuestas postRespuestas(Respuestas newRespuestas) {
		return respuestasRepository.save(newRespuestas);
	}
	
	public Respuestas updateREspuestas(Respuestas respuestas, String id) {
		return respuestasRepository.findById(id)
				.map(respuestasMap -> {
					respuestasMap.setRespuestas(respuestas.getRespuestas());
					respuestasMap.setCuerpo(respuestas.getCuerpo());
					respuestasMap.setCantLike(respuestas.getCantLike());
					respuestasMap.setFechaHora(respuestas.getFechaHora());
					respuestasMap.setCorreo(respuestas.getCorreo());
					return respuestasRepository.save(respuestasMap);			
				})
				.orElseThrow(()-> new RespuestasNotFoundException(id));
	}
	
	

}
package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.exceptions.DireccionNotFoundException;
import com.example.manosalaobrabackend.model.Direccion;
import com.example.manosalaobrabackend.repository.DireccionRepository;

@Service // Esta anotación indica que esta clase es un servicio en la arquitectura de Spring
public class DireccionService {
	private DireccionRepository direccionRepository;
	
	//:Indica que este constructor se usará para inyectar dependencias de Spring, cuando se cree una instancia de DireccionService, se creará una instancia de DireccionRepository y la pasará al constructor de DireccionService.
	@Autowired 
	public DireccionService(DireccionRepository direccionRepository) {
		//Asigna el repositorio inyectado al campo de la clase.
		this.direccionRepository = direccionRepository;
	}
	
	//Método publico que retorna una lista de todos los productos
	public List<Direccion> getAll(){
		//Se retornan todos los productos encontrados.
		return direccionRepository.findAll();
	}
	
	public Direccion postDireccion(Direccion nuevaDireccion) {
		return direccionRepository.save(nuevaDireccion);
	}
	
	
	public Direccion getById(Long id) {
		return direccionRepository.findById(id)
				.orElseThrow(()->new DireccionNotFoundException(id));
	}

}

package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.exceptions.CompraNotFoundException;
import com.example.manosalaobrabackend.model.Compra;
import com.example.manosalaobrabackend.repository.CompraRepository;

@Service // Anotación que indica que esta clase es un servicio en la arquitectura Spring
public class CompraService {
	private CompraRepository compraRepository;
	
	//Anotación que indica que este constructor se utilizará para inyectar dependencias de Spring, así que cuando se cree una instancia de CompraService, se creará una instancia de CompraRepository y la pasará al constructor de CompraService.
	@Autowired
	public CompraService(CompraRepository compraRepository) {
		//Asigna el reposirio inyectado al campo de la clase
		this.compraRepository = compraRepository;
	}
	//Método publico que retorna una lista de todas las compras
	public List <Compra> getAll(){
		//Se retornan todas las compras encontradas.
		return compraRepository.findAll();
	}
	
	// Post compra. Guardamos las compras realizadas
	public Compra postCompra(Compra nuevaCompra) {
		return compraRepository.save(nuevaCompra);
	}
	
	// Get Compra mediante Id, creamos un método que nos permita  recuperar un usuario por Id, y tenemos que validar mediante backend que la compra especificada con el Id exista.
	public Compra getById(Long id) {
		return compraRepository.findById(id)
				.orElseThrow(() -> new CompraNotFoundException(id));
	}
	
	
	
	
}

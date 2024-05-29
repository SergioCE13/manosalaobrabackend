package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.model.Producto;
import com.example.manosalaobrabackend.repository.ProductoRepository;

@Service // Anotación que indica que esta clase es un servicio en la arquitectura Spring
public class ProductoService {
	private ProductoRepository productoRepository;

	//Anotación que indica que este constructor se utilizará para inyectar dependencias de Spring, esto quiere decir que cuando se cree una instancia de ProductoService, se creará una instancia de ProductoRepository y la pasará al constructor de ProductoService.
	@Autowired
	public ProductoService(ProductoRepository productoRepository) { 
		//Asigna el repositorio inyectado al campo de la clase
		this.productoRepository = productoRepository;
	}
	
	//Método publico que retorna una lista de todos los productos.
	public List<Producto> getAll(){
		//Se retornan todos los productos encontrados.
		return productoRepository.findAll();
	}
	
	
}

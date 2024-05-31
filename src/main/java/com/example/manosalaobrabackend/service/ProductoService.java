package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.exceptions.ProductoNotFoundException;
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

	public Producto postProducto(Producto newProducto) {
		return productoRepository.save(newProducto); //retorna un método desde JPARepository(save)
	}
	
	//productos
	public  Producto getById(String id) {
		return productoRepository.findById(id)
				.orElseThrow(() -> new ProductoNotFoundException(id));
	}
	
	public Producto deleteProducto(Producto producto, String name) {
		return productoRepository.save(producto);
	}
	
	
	//Debe de crear la excepción producto NotFoundException
	
	
	//Productos esoecifico
	public Producto updateProducto(Producto producto, String id) {
		return productoRepository.findById(id)
				.map(productoMap -> {
					productoMap.setNombre(producto.getNombre());
					productoMap.setPrecio(producto.getPrecio());
					productoMap.setMedidaAlto(producto.getMedidaAlto());
					productoMap.setMedidaAncho(producto.getMedidaAncho());
					productoMap.setMedidaLargo(producto.getMedidaLargo());
					productoMap.setDescripcion(producto.getDescripcion());
					productoMap.setTecnica(producto.getTecnica());
					productoMap.setStock(producto.getStock());
					productoMap.setInfoAdicional(producto.getInfoAdicional());
					productoMap.setImagenes(producto.getImagenes());
	
					return productoRepository.save(productoMap);
					
				})
				.orElseThrow(() -> new ProductoNotFoundException(id));
  }
}


package com.example.manosalaobrabackend.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.manosalaobrabackend.model.Producto;
import com.example.manosalaobrabackend.service.ProductoService;





@RestController  // Anotación que indica que esta clase es un controlador REST de Spring.
@RequestMapping("/api/mao/producto") // Anotación que define la url base para todas las rutas manejadas por este controlador.
public class ProductoController {
//Se manda a llamar Service
	private final ProductoService productoService;
	
	//Inyeccion de Dependencias (constructor)
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	//Mapear Métodos
	@GetMapping
	public List<Producto> getAllController(){
		return productoService.getAll();
	}
	
	@PostMapping
	public Producto newProducto (@RequestBody Producto producto) {
		return productoService.postProducto(producto);
	}
	
	@GetMapping ("/{id}")
	public Producto getProductoById(@PathVariable (name = "id") String id) {
		return productoService.getById(id);
	}
	
	@PutMapping ("/{id}")
	public Producto updateProducto (@RequestBody Producto producto, @PathVariable (name = "id") String name) {
		return productoService.updateProducto (producto,name);
	}
	
	@DeleteMapping ("/{id}")
	public Producto deleteProducto (@RequestBody Producto producto, @PathVariable (name = "id") String name) {
		return productoService.deleteProducto (producto,name);
	}
	
	/*
	 * //Se crea la excepción
	@GetMapping ("/{name}")
	public ResponseEntity<Producto> getProductoById (@PathVariable String name){
	Producto producto = productoService.getById(name);
	if (name == null) {
		throw new ProductoNotFoundException ("Producto not found with name" + name);
		}
		return new ResponseEntity <>(producto, HttpStatus.OK);
	}
	 * */
               
}
	

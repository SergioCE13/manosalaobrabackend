package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public String newProducto (
			@RequestParam("nombre") String nombre,
			@RequestParam("precio") double precio,
			@RequestParam("medida_alto") double medidaAlto,
			@RequestParam("medida_ancho") double medidaAncho,
			@RequestParam("medida_largo") double medidaLargo,
			@RequestParam("categoria") String categoria,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("tecnica") String tecnica,
			@RequestParam("stock") int stock,
			@RequestParam("info_adicional") String infoAdicional,
			@RequestParam("foto") MultipartFile file){
		return productoService.postProducto(nombre, precio, medidaAlto, medidaAncho, medidaLargo, categoria, descripcion, tecnica, stock, infoAdicional, file);
	}
	
	@GetMapping ("/{id}")
	public Producto getProductoById(@PathVariable (name = "id") String id) {
		return productoService.getById(id);
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
	

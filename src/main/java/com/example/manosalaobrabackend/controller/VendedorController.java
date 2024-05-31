package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Vendedor;
import com.example.manosalaobrabackend.service.VendedorService;
@RestController
@RequestMapping("/api/mao/vendedor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class VendedorController {
	private VendedorService vendedorService;

	@Autowired
	public VendedorController(VendedorService vendedorService) {
		this.vendedorService = vendedorService;
	}
	
	@GetMapping
	public List<Vendedor> getAllController(){
		return vendedorService.getAll();
	}
	
	//Mapear Post y recibir como parámetro del método una anotación @RequestBody pra vinularlo con el valor (atributos) del cuerpo del modelo
	@PostMapping
	public Vendedor newUser(@RequestBody Vendedor vendedor) { //Cuando se vea una anotacion Reuest Body signific que voy a recibir todos los atrbutos existentes en el modelo, por ende, se deben indicar en el oren en que estan en el modelo.
		return vendedorService.postVendedor(vendedor);
	}
	
	@GetMapping("/{id}")
	public Vendedor getUserbyId(@PathVariable(name = "id") String correo) {
		return vendedorService.getById(correo);
	}
	
	
	@PutMapping("/{id}")
	public Vendedor updateVendedor(@RequestBody Vendedor vendedor, @PathVariable(name = "id") String id) {
		return vendedorService.updateVendedor(vendedor, id);
	}
	
	
}

package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.manosalaobrabackend.model.Vendedor;
import com.example.manosalaobrabackend.service.VendedorService;
@RestController
@RequestMapping("/api/mao/vendedor")

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

	public String newVendedor(
			@RequestParam("correo") String correo,
			@RequestParam("nombre") String nombre,
			@RequestParam("ape_paterno") String apellidoPaterno,
			@RequestParam("ape_materno") String apellidoMaterno,
			@RequestParam("genero") String genero,
			@RequestParam("telefono") Long telefono ,
			@RequestParam("fecha_nacimiento") String fechaNacimiento,
			@RequestParam("contraseña") String password,
			@RequestParam("foto") MultipartFile file) {
		return vendedorService.postVendedor(correo, nombre, apellidoPaterno, apellidoMaterno, genero, telefono, fechaNacimiento, password, file);

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

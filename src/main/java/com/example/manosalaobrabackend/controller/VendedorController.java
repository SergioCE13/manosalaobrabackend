package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Vendedor;
import com.example.manosalaobrabackend.service.VendedorService;

@RestController
@RequestMapping("/api/manosalaobrabackend/vendedor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class VendedorController {
	
	public VendedorService vendedorService;

	@Autowired
	public VendedorController(VendedorService vendedorService) {
		this.vendedorService = vendedorService;
	}
	
	@GetMapping
	public List<Vendedor> getAllController(){
		return vendedorService.getAll();
	}
	
	
}

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

import com.example.manosalaobrabackend.model.Tarjeta;
import com.example.manosalaobrabackend.service.TarjetaService;

@RestController
@RequestMapping("/api/mao/tarjeta")
public class TarjetaController {
	private TarjetaService tarjetaService;
	
	@Autowired
	public TarjetaController (TarjetaService tarjetaService) {
		this.tarjetaService = tarjetaService;
	}
	
	@GetMapping
	public List<Tarjeta> getAllControler(){
		return tarjetaService.getAll();
	}
	
	@GetMapping("/{id}")
	public Tarjeta getTarjetaById(@PathVariable(name = "id") Long id) {
		return tarjetaService.getById(id);
	}
	
	@PostMapping
	public Tarjeta newTarjeta(@RequestBody Tarjeta tarjeta) {
		return tarjetaService.postTarjeta(tarjeta);
	}
	
	@PutMapping
	public Tarjeta updateTarjeta(@RequestBody Tarjeta tarjeta, @PathVariable(name = "id") Long id) {
		return tarjetaService.updateTarjeta(tarjeta, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTarjeta(@PathVariable(name = "id") Long id) {
		tarjetaService.deleteTarjeta(id);
	}
	
}

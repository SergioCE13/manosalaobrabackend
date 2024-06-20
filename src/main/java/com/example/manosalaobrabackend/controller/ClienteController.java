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

import com.example.manosalaobrabackend.model.Cliente;
import com.example.manosalaobrabackend.service.ClienteService;
@RestController
@RequestMapping("/api/mao/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ClienteController {
	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public List<Cliente> getAllControler(){
		return clienteService.getAll();
	}
	
	//Mapear Post y recibir como parámetro del método una anotación @RequestBody pra vinularlo con el valor (atributos) del cuerpo del modelo
	@PostMapping
	public Cliente newUser(@RequestBody Cliente cliente) { //Cuando se vea una anotacion Reuest Body signific que voy a recibir todos los atrbutos existentes en el modelo, por ende, se deben indicar en el oren en que estan en el modelo.
		return clienteService.postCliente(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente getUserbyId(@PathVariable(name = "id") String correo) {
		return clienteService.getById(correo);
	}
	
	
	@PutMapping("/{id}")
	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable(name = "id") String id) {
		return clienteService.updateCliente(cliente, id);
	}

	
}

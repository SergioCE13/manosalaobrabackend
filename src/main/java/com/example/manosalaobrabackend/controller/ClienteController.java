package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Cliente;
import com.example.manosalaobrabackend.service.ClienteService;

@RestController
@RequestMapping("/api/manosalaobrabackend/cliente")
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
	
	
}

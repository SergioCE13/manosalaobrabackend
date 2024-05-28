package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.model.Cliente;
import com.example.manosalaobrabackend.repository.ClienteRepository;

@Service 
public class ClienteService {
	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
	
}

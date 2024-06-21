package com.example.manosalaobrabackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Favorito;
import com.example.manosalaobrabackend.model.FavoritoId;
import com.example.manosalaobrabackend.service.FavoritoService;

@RestController // Clase que maneja solicitudes HTTP entrentes y envía respuestas HTTP en una aplicación web de SPRING.
@RequestMapping("/api/mao/direccion")
public class FavoritoController {
	
	
	@Autowired
    private FavoritoService favoritoService;


}
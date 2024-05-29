package com.example.manosalaobrabackend.exceptions;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	// Método de control(constructor) 
	public UserNotFoundException(String id) {
		super("No se logro encontrar al usuario con el id: " + id);
	}
}

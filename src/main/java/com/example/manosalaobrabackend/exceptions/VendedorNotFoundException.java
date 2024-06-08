package com.example.manosalaobrabackend.exceptions;

public class VendedorNotFoundException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public VendedorNotFoundException (String message) {
		super("El vendedor con el id: "+ message + "no fue encontrado");
	}
}

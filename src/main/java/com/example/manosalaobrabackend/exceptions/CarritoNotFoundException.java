package com.example.manosalaobrabackend.exceptions;

public class CarritoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CarritoNotFoundException(Long id) {
		super("El carrito de compra con el id " + id + " no ha sido encontrado");
	}
}

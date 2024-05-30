package com.example.manosalaobrabackend.exceptions;

public class TarjetaNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public TarjetaNotFoundException(Long id) {
		super("No se logró encontrar la tarjeta con el número: " + id);
	}
	

}

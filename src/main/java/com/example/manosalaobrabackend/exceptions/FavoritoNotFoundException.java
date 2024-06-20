package com.example.manosalaobrabackend.exceptions;

public class FavoritoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public FavoritoNotFoundException(Long id) {
		super("No se logró encontrar la direccion con el id:  " + id);
	}
}

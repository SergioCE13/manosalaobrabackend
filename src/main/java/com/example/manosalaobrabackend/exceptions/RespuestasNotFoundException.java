package com.example.manosalaobrabackend.exceptions;

public class RespuestasNotFoundException extends RuntimeException {
	private static final long serialversionUID = 1L;
	
	public RespuestasNotFoundException(String id) {
		super ("No se logró encontrar la respuesta con el id: " + id);
	}
}

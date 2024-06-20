package com.example.manosalaobrabackend.exceptions;

public class ComentarioNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ComentarioNotFoundException(Long id) {
		super("El comentario principal con el id " + id + " no ha sido encontrado");
	}
}

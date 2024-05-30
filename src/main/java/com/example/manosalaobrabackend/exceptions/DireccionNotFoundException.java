package com.example.manosalaobrabackend.exceptions;

public class DireccionNotFoundException extends RuntimeException{	
	private static final long serialVersionUID = 1L;

public  DireccionNotFoundException(Long id) {
	super ("No se logró encontrar la direccion con el id:  " + id);
}
}

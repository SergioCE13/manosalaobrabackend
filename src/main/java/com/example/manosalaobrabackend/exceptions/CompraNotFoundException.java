package com.example.manosalaobrabackend.exceptions;

public class CompraNotFoundException extends RuntimeException {
	private static final long serialVersionCID=1L;
	
	public CompraNotFoundException(Long id) {
		super ("No se logró encontrar la compra con el id:  " + id);
	}

}

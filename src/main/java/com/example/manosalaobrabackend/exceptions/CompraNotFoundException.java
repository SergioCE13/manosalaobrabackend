package com.example.manosalaobrabackend.exceptions;

public class CompraNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CompraNotFoundException(Long id) {
		super ("No se logró encontrar la compra con el id:  " + id);
	}

}

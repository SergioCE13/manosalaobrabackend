package com.example.manosalaobrabackend.exceptions;

public class ProductoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoNotFoundException (String message){
		super("El producto con el id: "+ message + " no fue encontrado");
}

}

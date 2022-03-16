package com.app.pamu.exception;

public class BrandNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BrandNotFoundException() {
		super();
	}

	public BrandNotFoundException(String message) {
		super(message);
	}
}

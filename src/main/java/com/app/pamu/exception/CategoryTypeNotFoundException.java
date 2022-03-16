package com.app.pamu.exception;

public class CategoryTypeNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public CategoryTypeNotFoundException(){
		super();
	}
	
	public CategoryTypeNotFoundException(String message){
		super(message);
	}
}

package com.stg.exceptions;

public class CustomException extends RuntimeException{
	private String errorMesaage;
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.errorMesaage;
	}

	public CustomException() {
		super();
	}

	public CustomException(String errorMesaage) {
		super();
		this.errorMesaage = errorMesaage;
	}
}

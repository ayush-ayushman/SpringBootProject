package com.ty.userservice.exception;

public class MyException extends RuntimeException {

	public MyException() {
		super("User not found");
		
	}
	public MyException(String t) {
		super(t);
		
	}

	
	

}

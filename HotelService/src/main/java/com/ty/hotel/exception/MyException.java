package com.ty.hotel.exception;

public class MyException extends RuntimeException{
	public MyException() {
		super("Hotel not found");
		
	}
	public MyException(String t) {
		super(t);
		
	}

}

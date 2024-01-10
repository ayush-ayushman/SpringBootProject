package com.ty.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.userservice.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MyException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(MyException ex)
	{
		String st=ex.getMessage();
		ApiResponse build=ApiResponse.builder().message(st).success(true).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<>(build,HttpStatus.NOT_FOUND);
		
	}

}

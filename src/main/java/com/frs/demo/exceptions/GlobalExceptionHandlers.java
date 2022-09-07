package com.frs.demo.exceptions;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandlers extends ResponseEntityExceptionHandler {
	@ExceptionHandler(NoSuchFlatBookingException.class)
	public ResponseEntity<String> handleNoSuchContact(NoSuchFlatBookingException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<String> handleNoSuchUser(NoSuchUserException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OperationFailedException.class)
	public ResponseEntity<String> handleOperationFailed(OperationFailedException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("Please change method request type and try again",HttpStatus.METHOD_NOT_ALLOWED);
	}

}

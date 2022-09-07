package com.frs.demo.exceptions;

import javax.naming.AuthenticationException;

public class InvalidException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5557455558204069430L;

	public InvalidException(String message) {
		super(message);
	}

}
package com.frs.demo.exceptions;

import javax.naming.AuthenticationException;

public class NoFlatPresentException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5167571133500734180L;

	public NoFlatPresentException(String message) {
		super(message);
	}
}

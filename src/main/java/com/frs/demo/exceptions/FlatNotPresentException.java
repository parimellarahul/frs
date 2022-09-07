package com.frs.demo.exceptions;

import javax.naming.AuthenticationException;

public class FlatNotPresentException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7304412414475836034L;
	
	public FlatNotPresentException(String message) {
		super(message);
	}

	
}

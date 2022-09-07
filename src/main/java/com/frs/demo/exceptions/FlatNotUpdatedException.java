package com.frs.demo.exceptions;

import javax.naming.AuthenticationException;

public class FlatNotUpdatedException extends AuthenticationException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3600430232877516313L;

	public FlatNotUpdatedException(String message) {
		super(message);
	}

}


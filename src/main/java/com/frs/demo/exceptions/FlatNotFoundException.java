package com.frs.demo.exceptions;

import javax.naming.AuthenticationException;

public class FlatNotFoundException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7563644447583536115L;
	public FlatNotFoundException(String message) {
		super(message);
	}

}
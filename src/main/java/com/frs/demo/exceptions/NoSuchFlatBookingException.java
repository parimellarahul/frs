package com.frs.demo.exceptions;

@SuppressWarnings("serial")
public class NoSuchFlatBookingException extends Exception {
	public NoSuchFlatBookingException(String msg) {
		super(msg);

}
}
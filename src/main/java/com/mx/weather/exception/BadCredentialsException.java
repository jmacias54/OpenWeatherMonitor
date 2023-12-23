package com.mx.weather.exception;

public class BadCredentialsException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 */
	public BadCredentialsException(String msg) {
		super(msg);
	}

	/**
	 * @param mensaje
	 * @param exception
	 */
	public BadCredentialsException(String mensaje, Throwable exception) {
		super(mensaje);
	}
}

package com.banana.exceptions;

public class BRException extends Exception {

	private static final long serialVersionUID = 1L;

	public BRException(String message) {
        super(message);
    }

    public BRException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

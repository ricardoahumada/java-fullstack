package com.banana.util;

public class NoExisteException extends Exception {
	public NoExisteException() {}

	public NoExisteException(String message) {
		super(message);
	}
}
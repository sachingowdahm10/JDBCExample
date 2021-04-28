package com.mt.generatepassport.exceptions;

public class ControllerException extends Exception {

	public ControllerException(String message, Exception exception) {
		super(message, exception);
	}
}

package com.mt.generatepassport.exceptions;

public class ServiceException extends Exception {

	public ServiceException(String message, Exception exception) {
		super(message, exception);
	}
	
}

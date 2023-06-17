package com.masai.Exceptions;

public class NoRecordFoundException extends RuntimeException {
	
	public NoRecordFoundException() {
		super();
	}
	
	public NoRecordFoundException(String message) {
		super(message);
	}

}

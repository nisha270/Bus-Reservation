package com.masai.Exceptions;

import org.hibernate.sql.model.internal.TableUpdateNoSet;

public class NoSeatAvailableException extends RuntimeException{
	
	public NoSeatAvailableException(String message) {
		super(message);
	}

}

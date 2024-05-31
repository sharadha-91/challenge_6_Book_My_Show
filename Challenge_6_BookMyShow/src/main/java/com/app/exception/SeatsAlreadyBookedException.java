package com.app.exception;

public class SeatsAlreadyBookedException extends Exception 
{

	public SeatsAlreadyBookedException() {
		
	}
	public SeatsAlreadyBookedException(String message) {
		super(message);
	}
}

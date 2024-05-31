package com.app.exception;

public class BookTicketRequestValidationException extends Exception{
	
	public BookTicketRequestValidationException() {
		
	}

		public BookTicketRequestValidationException(String message) {
		 super(message);
	}
}

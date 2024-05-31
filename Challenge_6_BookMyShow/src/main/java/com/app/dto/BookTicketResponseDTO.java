package com.app.dto;

import com.app.model.Ticket;
import com.app.response.Response;
import com.app.response.ResponseStatus;

public class BookTicketResponseDTO {
	
	private Response response;
	private Ticket ticket;
	
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	
	
	
	
}

	

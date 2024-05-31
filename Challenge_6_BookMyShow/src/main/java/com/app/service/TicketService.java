package com.app.service;

import java.util.List;

import com.app.exception.InvalidUser;
import com.app.model.Ticket;

public interface TicketService {
	
	Ticket bookTicket(int userId, int showId, List<Integer> seatIds) throws InvalidUser, Exception;

}

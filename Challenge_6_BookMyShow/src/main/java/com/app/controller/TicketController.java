package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookTicketRequestDTO;
import com.app.dto.BookTicketResponseDTO;
import com.app.exception.InvalidBookTicketException;
import com.app.model.Ticket;
import com.app.response.Response;
import com.app.response.ResponseStatus;
import com.app.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	private TicketService ticketService;
	
	@Autowired
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@PostMapping("/book")
	public BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO) {
		
		BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
		
		try {
			validateBookTicketRequest(requestDTO);
			requestDTO.getUserId();
		Ticket ticket =	ticketService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatId());
		  Response response = Response.getSuccessResponse();
		responseDTO.setTicket(ticket);
		responseDTO.setResponse(response);
		}catch(Exception e) {
			  Response response = Response.getFailureResponse(e.getMessage());
	            responseDTO.setResponse(response);
		}
		return responseDTO;
	}
	
	private static  void validateBookTicketRequest(BookTicketRequestDTO requestDTO) throws InvalidBookTicketException {
		
		if(requestDTO.getUserId() <= 0) {
			throw new InvalidBookTicketException(" UserId should not be negative");
		}
		if(requestDTO.getShowId()<=0) {
			throw new InvalidBookTicketException("showId should not be negative");
		}
		if(requestDTO.getShowSeatId() == null || requestDTO.getShowSeatId().isEmpty()) {
			throw new InvalidBookTicketException("seat id should be present");
		}
		
	}
	
	

}

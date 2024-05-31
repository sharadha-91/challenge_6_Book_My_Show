package com.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.dto.BookTicketRequestDTO;
import com.app.dto.BookTicketResponseDTO;
import com.app.exception.InvalidUser;
import com.app.model.Ticket;
import com.app.response.ResponseStatus;
import com.app.service.TicketService;

@SpringBootTest
public class TicketControllerTest {
//      3 Scenarios
//      1. Validation fails 					-> Negative
//      2. Ticket service fails 				-> Positive
//      3. Ticket service gives a ticket obj    -> Positive
	
	@MockBean
	private TicketService tickteService;
	@MockBean
	private TicketController ticketController;
	
	public void testBookTicket_ShowIdNegative() throws Exception {
		//1.Arrange
		BookTicketRequestDTO requestDto = new BookTicketRequestDTO();
		requestDto.setShowId(-1);
		requestDto.setUserId(1);
		requestDto.setShowSeatId(List.of(1,2,3,4));
		
		when(tickteService.bookTicket(requestDto.getUserId(), requestDto.getShowId(), requestDto.getShowSeatId()))
		.thenThrow(Exception.class);
		
		//2.Act
		
		BookTicketResponseDTO responseDTO = ticketController.bookTicket(requestDto);
		//3. Assert
		 assertNotNull(responseDTO, "ResponseDto should NOT be null");
	        assertNotNull(responseDTO.getResponse());
	        assertEquals(ResponseStatus.FAILURE, responseDTO.getResponse());
	        assertNotNull(responseDTO.getResponse());
	        assertNull(responseDTO.getTicket(), "Ticket should not be generated");
		
	}
	public void testBookTicket_UserIdNegative() throws Exception {
		//1.Arrange
		BookTicketRequestDTO requestDTO = new BookTicketRequestDTO();
		
		requestDTO.setShowId(1);
		requestDTO.setUserId(-1);
		requestDTO.setShowSeatId(List.of(1,2,3,4));
		
		when(tickteService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatId()))
		.thenThrow(Exception.class);
		//2.Act
		BookTicketResponseDTO responseDto = ticketController.bookTicket(requestDTO);
		
		//3.Assert
		assertNotNull(responseDto, "Response dto should not be null");
        assertNotNull(responseDto.getResponse());
        assertEquals(ResponseStatus.FAILURE, responseDto.getResponse());
        assertNotNull(responseDto.getResponse());
        assertNull(responseDto.getTicket(), "Ticket should not be generated");
		
	}
	
	public void testBookTicket_Positive() throws  Exception {
		//1.Arrange
		BookTicketRequestDTO requestDto = new BookTicketRequestDTO();
	        requestDto.setShowId(1);
	        requestDto.setUserId(1);
	        requestDto.setShowSeatId(List.of(1,2,3,4));
	        
	        when(tickteService.bookTicket(requestDto.getUserId(),
	                requestDto.getShowId(), requestDto.getShowSeatId())).thenReturn(new Ticket());
		//2.Act
	        BookTicketResponseDTO responseDto = ticketController.bookTicket(requestDto); 
	      
		//3.Assert
	        assertNotNull(responseDto, "Response dto should not be null");
	        assertNotNull(responseDto.getResponse());
	        assertEquals(ResponseStatus.SUCCESS, responseDto.getResponse());
	        assertNull(responseDto.getResponse());
	        assertNotNull(responseDto.getTicket(), "Ticket should be generated");
		
	}

	 // TODO: Cover empty show seat ids and null show seat ids
	
//	public void testBookTicket_EmptySeatId) throws  Exception {
//		
//		
//	}
//		public void testBookTicket_NullSeatId) throws  Exception {
//		
//		
//	}
	
	@Test
    void testBookTicket_ShowSeatIdsEmptyOrNull() throws Exception {
        // Arrange
        BookTicketRequestDTO requestDTO = new BookTicketRequestDTO();
        requestDTO.setShowId(1);
        requestDTO.setUserId(1);
        requestDTO.setShowSeatId(null);;

        when(tickteService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatId()))
                .thenThrow(Exception.class);

        // Act
        BookTicketResponseDTO responseDTO = ticketController.bookTicket(requestDTO);

        // Assert
        assertNotNull(responseDTO, "ResponseDto should NOT be null");
        assertNotNull(responseDTO.getResponse());
        assertEquals(ResponseStatus.FAILURE, responseDTO.getResponse());
        assertNotNull(responseDTO.getResponse());
        assertNull(responseDTO.getTicket(), "Ticket should not be generated");
    }

	
	
}

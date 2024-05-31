package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.BookTicketRequestValidationException;
import com.app.exception.InvalidBookTicketException;
import com.app.exception.InvalidUser;
import com.app.exception.SeatsUnavailableException;
import com.app.model.SeatStatus;
import com.app.model.Show;
import com.app.model.Show_Seat;
import com.app.model.Ticket;
import com.app.model.User;
import com.app.repository.ShowRepository;
import com.app.repository.ShowSeatRepository;
import com.app.repository.TicketRepository;
import com.app.repository.UserRepository;
@Service
public class TicketServiceImpl implements TicketService{

	
	private ShowRepository showRepository;
	private ShowSeatRepository showSeatRepository;
	private TicketRepository ticketRepository;
	private UserRepository userRepository;
	
	@Autowired
	public TicketServiceImpl(ShowRepository showRepository,ShowSeatRepository showSeatRepository,TicketRepository ticketRepository,UserRepository userRepository) {
		this.showRepository = showRepository;
		this.showSeatRepository = showSeatRepository;
		this.ticketRepository = ticketRepository;
		this.userRepository = userRepository;
	}
	
	
	@Override
	public Ticket bookTicket(int userId, int showId, List<Integer> seatIds) throws Exception {
		
		   /*
        1. Check if the user is valid
        2. Showid in showSeatIds and given showId should match
        3. Start transaction (SERIALIZABLE)
        4. select * from show_seats where id in (showSeatIds) and seat_status = 'Available' and show_id = {{showId}} for update
        5. if all seats are not available
        6. throw error and rollback the transaction
        7. Update show_seats set seat_status = 'BLOCKED' where ids in (showSeatIds)
        8. Generate ticket object
        9. Store ticket object in DB and return
         */
		    User user = new User();
		    Optional<User> optionUser = userRepository.findById(userId);
		    if(optionUser.isPresent()) {
		    	user =optionUser.get();
		    }else {
		    	throw new InvalidUser();
		    }
		    
		   Show show = showRepository.findById(showId).orElseThrow(()-> new BookTicketRequestValidationException("Invalid show id"));
	      Show_Seat showseat = showSeatRepository.findById(seatIds.get(0)).orElseThrow(()-> new BookTicketRequestValidationException("Seat Id is invalid"));
		
	       if(showseat.getShow().getId()!= showId) {
	    	   throw new InvalidBookTicketException("Given seats dont belong to same show");
	       }
	       
	       List<Show_Seat> showseats = null;
	       if(showseats.size() != seatIds.size()) {
	    	   throw new SeatsUnavailableException(" some of the seats you are trying to book are unavailble");	    	   
	       }
	       
	       
	       for(Show_Seat ss : showseats) {
	    	   ss.setBookedBy(user);
	    	   ss.setSeatStatus(SeatStatus.BLOCKED);
	       }
	       
	       showSeatRepository.saveAll(showseats);
	       
	       Ticket ticket = new Ticket();
	       ticket.setMovie(show.getMovie());
	       ticket.setShow(show);
	       ticket.setShowSeats(showseats);
	       ticket.setBookedBy(user);
	       
	       
	       return ticketRepository.save(ticket);
	}

}

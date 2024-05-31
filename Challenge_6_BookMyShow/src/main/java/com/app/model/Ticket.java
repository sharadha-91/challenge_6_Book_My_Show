package com.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="ticket")
public class Ticket extends BaseModel {
	
	//private double amount;
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private Show show;
	@ManyToOne
	private User bookedBy;
	@OneToMany
    private List<Show_Seat> showSeats;
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public User getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}
	public List<Show_Seat> getShowSeats() {
		return showSeats;
	}
	public void setShowSeats(List<Show_Seat> showSeats) {
		this.showSeats = showSeats;
	}
	
    
//	@ManyToMany
//	private List<Seat> listOfSeats;
//	@Enumerated
//	private TicketStatus ticketStatus;
    
    
	

}

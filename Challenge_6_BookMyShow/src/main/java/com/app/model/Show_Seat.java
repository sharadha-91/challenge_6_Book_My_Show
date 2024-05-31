package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity(name="show_seats")
public class Show_Seat extends BaseModel{
	
	@ManyToOne
	private Show show;
	@ManyToOne
	private Seat seat;
	@Enumerated
	private SeatStatus seatStatus;
	@ManyToOne
	private User bookedBy;
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public SeatStatus getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}
	public User getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}

	
	
}

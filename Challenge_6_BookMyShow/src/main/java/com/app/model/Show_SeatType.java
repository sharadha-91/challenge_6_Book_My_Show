package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name="seattype_shows")
public class Show_SeatType extends BaseModel{
	
	private SeatType seatType;
	@ManyToOne
	private Show show;
	private double price;
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
